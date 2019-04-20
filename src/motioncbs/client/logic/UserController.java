package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import motioncbs.client.ui.user.userInfoView.UserInfoView;
import motioncbs.client.ui.user.userMainView.UserMainView;
import motioncbs.shared.User;

import java.util.ArrayList;

public class UserController {

    private ContentPanel contentPanel;
    private UserMainView userMainView;
    private MotionCBSServiceAsync motionCBSServiceAsync;
    private User currentUser;


    //instantierer et objekt af ListDataProvideren som indeholder en arraylist med brugerne
    // der skal vises i vores datagrid
    private ListDataProvider<User> listProviderUsers;

    //opretter constructor

    public UserController(ContentPanel contentPanel, MotionCBSServiceAsync motionCBSService) {
        this.contentPanel = contentPanel;
        this.motionCBSServiceAsync = motionCBSService;
        this.userMainView = contentPanel.getUserMainView();

        bindHandlers();

        listProviderUsers = new ListDataProvider<>();

        userMainView.getUserInfoView().initUsersTable(listProviderUsers);



    }

    private void bindHandlers() {
        userMainView.addClickHandlers(new MenuClickHandler());

        userMainView.getUserSettingsView().getChangeProfileBtn().addClickHandler(new ChangeInfoClickHandler());

    }

    //metode der fortaeller hvad der sker naar der bliver trykket paa de forskellige buttons.
    class MenuClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == userMainView.getInfoBtn()) {
                userMainView.changeView(userMainView.getUserInfoView());

            } else if (event.getSource() == userMainView.getSettingsBtn()) {
                userMainView.changeView(userMainView.getUserSettingsView());

            } else if (event.getSource() == userMainView.getUsersBtn()) {
                userMainView.changeView(userMainView.getUserMainView());
            } else if (event.getSource() == userMainView.getLogoutBtn()) {
                contentPanel.changeView(contentPanel.getLoginView());

                listProviderUsers.getList().clear();
                currentUser=null;

            }
        }
    }

    class ChangeInfoClickHandler implements  ClickHandler {

        //tager alt informationen fra de indtastede informationer fra textbokse, Radiobuttons og checkbokse og aendrer dem til brugerens nye oplysninger
        @Override
        public void onClick(ClickEvent event) {
            currentUser.setFirstName(userMainView.getUserSettingsView().getFirstNameBox().getText());
            currentUser.setLastName(userMainView.getUserSettingsView().getLastNameBox().getText());
            int i = Integer.parseInt(userMainView.getUserSettingsView().getAgeBox().getText());
            currentUser.setAge(i); //??? en anden get for int?
            currentUser.setUsername(userMainView.getUserSettingsView().getUsernameBox().getText());
            currentUser.setPassword(userMainView.getUserSettingsView().getPasswordBox().getText());
            if (userMainView.getUserSettingsView().getMaleCheckbox().getValue() == true) {
                currentUser.setGender("Male");
            } else if (userMainView.getUserSettingsView().getFemaleCheckbox().getValue() == true) {
                currentUser.setGender("Female");
            }
            if (userMainView.getUserSettingsView().getRadioButtonA().getValue() == true) {
                currentUser.setCustomertype(1);
            } else if (userMainView.getUserSettingsView().getRadioButtonB().getValue() == true) {
                currentUser.setCustomertype(2);
            } else if (userMainView.getUserSettingsView().getRadioButtonC().getValue() == true) {
                currentUser.setCustomertype(3);
            }

            motionCBSServiceAsync.changeUserInfo(currentUser, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Fejl i server kald - Kunne ikke opdatere informationer");
                }

                @Override
                public void onSuccess(Void result) {


                Window.alert("Det lykkedes at opdatere dine informationer");
                }

            });
            loadTables();
            listProviderUsers.getList().clear();
            listProviderUsers.refresh();
            userMainView.changeView(userMainView.getUserInfoView());
            userMainView.getUserInfoView().initUsersTable(listProviderUsers);



        }
    }

















    public void loadUser(User currentUser) {
        this.currentUser = currentUser;
        loadTables();
    }

    /**
     * Method which both loads:
     * 1) The table of users into the DataProvider which contains an ArrayList.

     * This is done by making a RPC call to the server which gets the users from the database
     */
    private void loadTables() {

        // The RPC to get all the users
        motionCBSServiceAsync.getUsers(currentUser.getId(), new AsyncCallback<ArrayList<User>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Could not load users");
            }

            @Override
            public void onSuccess(ArrayList<User> users) {
                // Adding all the users to the DataProvider (ArrayList)
                listProviderUsers.getList().addAll(users);
            }
        });
    }
}
