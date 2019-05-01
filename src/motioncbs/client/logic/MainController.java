package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import motioncbs.client.ui.signup.SignUpView;
import motioncbs.server.MotionCBSServiceImpl;
import motioncbs.shared.FieldVerifier;
import motioncbs.shared.User;

public class MainController {

    //Opretter objekter af contentpanel og Kontrakt mellem server og client?????
    private ContentPanel content;
    private MotionCBSServiceAsync motionCBSService;
    private SignUpView signUpView;


    private ListDataProvider<User> listProviderUsers;

    //opretter objekter af adminController og userController

    private AdminController adminController;
    private UserController userController;

    //opretter constructor

    public MainController (ContentPanel content, MotionCBSServiceAsync motionCBSService) {

        this.content = content;
        this.motionCBSService = motionCBSService;
        this.signUpView = content.getSignUpView();

        listProviderUsers = new ListDataProvider<>();

        adminController = new AdminController(content, motionCBSService);
        userController = new UserController(content, motionCBSService);
        bindHandlers();


    }

    public void bindHandlers(){
        content.getLoginView().addClickHandlers(new LoginClickHandler());
        content.getLoginView().addClickHandlers(new SignUpClickHandler());
        signUpView.getRadioButtonA().addClickHandler(new customertype1());
        signUpView.getRadioButtonB().addClickHandler(new customertype2());
        signUpView.getRadioButtonC().addClickHandler(new customertype3());
        signUpView.getFemaleCheckbox().addClickHandler(new rKvindeBtn());
        signUpView.getMaleCheckbox().addClickHandler(new rMandBtn());
        signUpView.getShowPass().addClickHandler(new visPassBox());
        signUpView.getHidePass().addClickHandler(new skjulPassBox());
        signUpView.addClickHandlers(new SignUpAsMemberClickHandler());
        signUpView.getRydBtn().addClickHandler(new clearInput());
    }
    class customertype1 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {

            if (event.getSource() == signUpView.getRadioButtonA()){
                signUpView.getRadioButtonB().setChecked(false);
                signUpView.getRadioButtonC().setChecked(false);
            }
        }
    }

    class customertype2 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
             if (event.getSource() == signUpView.getRadioButtonB()){
                signUpView.getRadioButtonA().setChecked(false);
                signUpView.getRadioButtonC().setChecked(false);
            }
        }
    }

    class customertype3 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == signUpView.getRadioButtonC()){
                signUpView.getRadioButtonA().setChecked(false);
                signUpView.getRadioButtonB().setChecked(false);
            }
        }
    }

    class rKvindeBtn implements ClickHandler {
        @Override
        public void onClick(ClickEvent event){
            if (event.getSource() == signUpView.getFemaleCheckbox()){
                signUpView.getMaleCheckbox().setChecked(false);
            }
        }
    }
    class rMandBtn implements ClickHandler {
        @Override
        public void onClick(ClickEvent event){
            if (event.getSource() == signUpView.getMaleCheckbox()){
                signUpView.getFemaleCheckbox().setChecked(false);
            }
        }
    }

    class visPassBox implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            signUpView.getShowPass();
            {
                signUpView.getPasswordBox().getElement().setAttribute("type", "text");
                signUpView.getHidePass().setChecked(false);
            }
        }
    }

    class skjulPassBox implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            signUpView.getHidePass();
            {
                signUpView.getPasswordBox().getElement().setAttribute("type", "password");
                signUpView.getShowPass().setChecked(false);
            }
        }
    }


    class clearInput implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == signUpView.getRydBtn()){
                signUpView.clearInput();
            }
        }
    }

    class SignUpClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == content.getLoginView().getSignUpBtn()){
                content.changeView(content.getSignUpView());
            }

        }
    }

    class SignUpAsMemberClickHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {
            if (FieldVerifier.isValidName(signUpView.getFornavnBox().getText())
                    && FieldVerifier.isValidName(signUpView.getEfternavnBox().getText())
                    && FieldVerifier.isValidAge(signUpView.getAlderBox().getText())
                    && FieldVerifier.isValidBrugernavn(signUpView.getBrugernavnBox().getText())
                    && FieldVerifier.isValidPass(signUpView.getPasswordBox().getText())
                    && FieldVerifier.isGenderPicked(signUpView.getFemaleCheckbox().isChecked())
                    || FieldVerifier.isGenderPicked(signUpView.getMaleCheckbox().isChecked())
                    && FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonA().getValue())
                    || FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonB().getValue())
                    || FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonC().getValue()))
            {
                String firstName = signUpView.getFornavnBox().getText();
                String lastName = signUpView.getEfternavnBox().getText();
                int age = Integer.parseInt(signUpView.getAlderBox().getText());
                String username = signUpView.getBrugernavnBox().getText();
                String password = signUpView.getPasswordBox().getText();


                final User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAge(age);
                user.setUsername(username);
                user.setPassword(password);

                if (signUpView.getMaleCheckbox().getValue()) {
                    user.setGender("Male");
                } else if (signUpView.getFemaleCheckbox().getValue()) {
                    user.setGender("Female");
                }

                if (signUpView.getRadioButtonA().getValue()) {
                    user.setCustomertype(1);
                } else if (signUpView.getRadioButtonB().getValue()) {
                    user.setCustomertype(2);
                } else if (signUpView.getRadioButtonC().getValue()) {
                    user.setCustomertype(3);
                }

                motionCBSService.createUser(user, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Fejl i server kald - Kunne ikke oprette bruger");
                    }

                    @Override
                    public void onSuccess(Boolean isCreated) {

                        if (!isCreated) {
                            Window.alert("Could not create user");
                        } else {

                            /* If the user is created the text fields are cleared
                             * and the user is added to the list of users
                             */
                            //signUpView.clearInput();
                            listProviderUsers.getList().add(user);

                            //Udskriver de indtastede data bortset fra brugernavn og password
                            Window.alert("Du har nu oprettet dig med foelgende oplysninger: " + "\n"
                                    + "Fornavn: " + user.getFirstName() + "\n"
                                    + "efternavn: " + user.getLastName() + "\n"
                                    + "alder: " + user.getAge() + "\n"
                                    + "username: " + user.getUsername() + "\n"
                                    + "password: " + user.getPassword() + "\n"
                                    + "Køn: " + user.getGender() + "\n"
                                    + "Medlemstype: " + user.getCustomertype());
                        }

                        signUpView.clearInput();
                        content.changeView(content.getLoginView());

                    }

                });

            } else {
                // Brugeren får besked hvis han/hun ikke har udfyldt felterne korrekt.
                if (!FieldVerifier.isValidName(signUpView.getFornavnBox().getText()))
                    Window.alert("Venligst indtast et fornavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidName(signUpView.getEfternavnBox().getText()))
                    Window.alert("Venligst indtast et efternavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidAge(signUpView.getAlderBox().getText()))
                    Window.alert("For at være medlem skal du mindst være 15 år, og højst 99");

                if (!FieldVerifier.isGenderPicked(signUpView.getFemaleCheckbox().isChecked())
                        && !FieldVerifier.isGenderPicked(signUpView.getMaleCheckbox().isChecked()))
                    Window.alert("Du skal vælge ét køn");

                if (!FieldVerifier.isValidBrugernavn(signUpView.getBrugernavnBox().getText()))
                    Window.alert("Indast et brugernavn på minimum 3 karakter! (tal og/eller bogstaver)");

                if (!FieldVerifier.isValidPass(signUpView.getPasswordBox().getText()))
                    Window.alert("Dit password skal være på minimum 4 karakterer! (tal og/eller bogstaver)");


                if (!FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonA().isChecked())
                        && !FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonB().isChecked())
                        && !FieldVerifier.isCustomertypePicked(signUpView.getRadioButtonC().isChecked()))
                    Window.alert("Du skal vælge et medlemskab A, B eller C");

                content.changeView(content.getSignUpView());
            }

        }
    }




    class LoginClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == content.getLoginView().getLoginBtn()){
            //henter indhold fra usernamebox og passwordbox og saetter det lig String username og password
            String username = content.getLoginView().getUsernameBox().getText();
            String password = content.getLoginView().getPasswordBox().getText();


// RPC authenticating user method
            motionCBSService.authorizeUser(username, password, new AsyncCallback<User>() {

                /*
                 * Handles error from callback function
                 */
                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Der skete en fejl");
                }

                /*
                 * Handles success response from callback
                 * The callback returns a user
                 */
                @Override
                public void onSuccess(User user) {
                    // Failed to match input with User in database
                    if (user == null) {
                        Window.alert("Wrong username or password");
                    } else {

                        // Clearing the text fields (username & password) from
                        // the login screen
                        content.getLoginView().clearTextBox();

                        /*
                         * 1) User match in database,
                         * 2) Checks access level Admin != User
                         * 3) Change the view to either admin or user view
                         */
                        if (user.getCustomertype() == 4) {
                            adminController.loadUser(user);
                            content.changeView(content.getAdminMainView());
                            content.getAdminMainView().changeView(content.getAdminMainView().getAdminAllUserInfoView());

                        } else  {
                            userController.loadUser(user);
                            content.changeView(content.getUserMainView());
                            content.getUserMainView().changeView(content.getUserMainView().getUserInfoView());
                        }
                    }

                }
            });

        }
    }
}

}




