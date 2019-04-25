package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import motioncbs.client.ui.user.userMainView.UserMainView;
import motioncbs.client.ui.user.userSettingsView.UserSettingsView;
import motioncbs.shared.FieldVerifier;
import motioncbs.shared.User;



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
    // metode der binder clickhandlers til buttons
    private void bindHandlers() {
        userMainView.addClickHandlers(new MenuClickHandler());

        userMainView.getUserSettingsView().addClickHandlers(new ChangeInfoClickHandler());

        userMainView.getUserInfoView().addClickHandler(new ChangeInformationBtnClickhandler());
    }

    class ChangeInformationBtnClickhandler implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            userMainView.getUserInfoView().getChangeInfoBtn();
            {
                userMainView.changeView(userMainView.getUserSettingsView());
            }
        }
    }
    //metode der fortaeller hvad der sker naar der bliver trykket paa de forskellige buttons.
    class MenuClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == userMainView.getInfoBtn()) {
                userMainView.changeView(userMainView.getUserInfoView());

            } else if (event.getSource() == userMainView.getSettingsBtn()) {
                userMainView.changeView(userMainView.getUserSettingsView());
                //toemmer textbokse og input i settingsView naar man gaar derind
                userMainView.getUserSettingsView().clearInput();

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
            if (FieldVerifier.isValidName(userMainView.getUserSettingsView().getFirstNameBox().getText())
                    && FieldVerifier.isValidName(userMainView.getUserSettingsView().getLastNameBox().getText())
                    && FieldVerifier.isValidAge(userMainView.getUserSettingsView().getAgeBox().getText())
                    && FieldVerifier.isValidBrugernavn(userMainView.getUserSettingsView().getUsernameBox().getText())
                    && FieldVerifier.isValidPass(userMainView.getUserSettingsView().getPasswordBox().getText())
                    && FieldVerifier.isGenderPicked(userMainView.getUserSettingsView().getFemaleCheckbox().isChecked())
                    || FieldVerifier.isGenderPicked(userMainView.getUserSettingsView().getMaleCheckbox().isChecked())
                    && FieldVerifier.isCustomertypePicked(userMainView.getUserSettingsView().getRadioButtonA().isChecked())
                    || FieldVerifier.isCustomertypePicked(userMainView.getUserSettingsView().getRadioButtonB().isChecked())
                    || FieldVerifier.isCustomertypePicked(userMainView.getUserSettingsView().getRadioButtonC().isChecked())) {


                currentUser.setFirstName(userMainView.getUserSettingsView().getFirstNameBox().getText());
                currentUser.setLastName(userMainView.getUserSettingsView().getLastNameBox().getText());
                int i = Integer.parseInt(userMainView.getUserSettingsView().getAgeBox().getText());
                currentUser.setAge(i);
                currentUser.setUsername(userMainView.getUserSettingsView().getUsernameBox().getText());
                currentUser.setPassword(userMainView.getUserSettingsView().getPasswordBox().getText());

                if (userMainView.getUserSettingsView().getMaleCheckbox().isChecked()) {
                    currentUser.setGender("Male");
                } else if (userMainView.getUserSettingsView().getFemaleCheckbox().isChecked()) {
                    currentUser.setGender("Female");
                }
                if (userMainView.getUserSettingsView().getRadioButtonA().getValue()) {
                    currentUser.setCustomertype(1);
                } else if (userMainView.getUserSettingsView().getRadioButtonB().getValue()) {
                    currentUser.setCustomertype(2);
                } else if (userMainView.getUserSettingsView().getRadioButtonC().getValue()) {
                    currentUser.setCustomertype(3);
                }


                motionCBSServiceAsync.changeUserInfo(currentUser, new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Fejl i server kald - Kunne ikke opdatere informationer");
                    }

                    @Override
                    public void onSuccess(Void updated) {

                        Window.alert("Det lykkedes at opdatere dine informationer");

                        //Udskriver de indtastede data bortset fra brugernavn og password
                        Window.alert("Dine oplysninger er nu rettet til: " +
                                "" + "\n" + "Fornavn: " +  currentUser.getFirstName()
                                + "\n" + "efternavn: " +  currentUser.getLastName()
                                + "\n" + "alder: " + currentUser.getAge()
                                + "\n" + "Køn: " + currentUser.getGender()
                                + "\n" + "Medlemstype: " + currentUser.getCustomertype());

                        userMainView.getUserSettingsView().clearInput();

                        loadTables();
                        listProviderUsers.getList().clear();
                        listProviderUsers.refresh();
                        userMainView.changeView(userMainView.getUserInfoView());
                        userMainView.getUserInfoView().initUsersTable(listProviderUsers);


                        userMainView.getUserSettingsView().clearInput();

                        // Window.alert("Could not update your information");
                        //userMainView.changeView(userMainView.getUserSettingsView());

                    }


                });


            }
            else {
                // Brugeren får besked hvis han/hun ikke har udfyldt felterne korrekt.
                if (!FieldVerifier.isValidName(userMainView.getUserSettingsView().getFirstNameBox().getText()))
                    Window.alert("Venligst indtast et fornavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidName(userMainView.getUserSettingsView().getLastNameBox().getText()))
                    Window.alert("Venligst indtast et efternavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidAge(userMainView.getUserSettingsView().getAgeBox().getText()))
                    Window.alert("For at være medlem skal du mindst være 15 år, og højst 99");

                if (!FieldVerifier.isValidBrugernavn(userMainView.getUserSettingsView().getUsernameBox().getText()))
                    Window.alert("Indast et brugernavn på minimum 3 karakter! (tal og/eller bogstaver)");

                if (!FieldVerifier.isValidPass(userMainView.getUserSettingsView().getPasswordBox().getText()))
                    Window.alert("Dit password skal være på minimum 4 karakterer! (tal og/eller bogstaver)");

                if (userMainView.getUserSettingsView().getMaleCheckbox().isChecked()
                        && userMainView.getUserSettingsView().getFemaleCheckbox().isChecked()
                    || !FieldVerifier.isGenderPicked(userMainView.getUserSettingsView().getMaleCheckbox().isChecked())
                    && !FieldVerifier.isGenderPicked(userMainView.getUserSettingsView().getFemaleCheckbox().isChecked()))
                    Window.alert("Du skal vælge ét køn");

                if (userMainView.getUserSettingsView().getRadioButtonA().getValue() == null
                        && userMainView.getUserSettingsView().getRadioButtonB().getValue() == null
                        && userMainView.getUserSettingsView().getRadioButtonC().getValue() == null)
                    Window.alert("Du skal vælge et medlemskab A, B eller C");

                //Window.alert("Dine oplysninger blev ikke opdateret");
                userMainView.changeView(userMainView.getUserSettingsView());

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
   /* private void loadTables() {

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
    */
   private void loadTables(){
       motionCBSServiceAsync.getCurrentUser(currentUser.getId(), new AsyncCallback<User>() {
           @Override
           public void onFailure(Throwable caught) {
               Window.alert("Could not load your information");
           }

           @Override
           public void onSuccess(User result) {
               listProviderUsers.getList().add(currentUser);

           }
       });
   }
}
