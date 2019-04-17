package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
                currentUser=null;

            }
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
