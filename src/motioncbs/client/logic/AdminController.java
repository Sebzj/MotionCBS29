package motioncbs.client.logic;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import motioncbs.client.ui.admin.AdminMainView.AdminMainView;
import motioncbs.shared.FieldVerifier;
import motioncbs.shared.User;

import java.util.ArrayList;

class AdminController {


    private User currentUser;
    private User user;
    private ContentPanel content;
    private AdminMainView adminMainView;
    private MotionCBSServiceAsync motionCBSServiceAsync;
    private ListDataProvider<User> listProviderUsers;


    //opretter constructor
    AdminController(ContentPanel content, MotionCBSServiceAsync motionCBSService) {

        this.content = content;
        this.motionCBSServiceAsync = motionCBSService;
        this.adminMainView = content.getAdminMainView();

        bindHandlers();


        listProviderUsers = new ListDataProvider<>();

        adminMainView.getAdminAllUserInfoView().initUsersTable(listProviderUsers);

    }

    // metode der binder clickhandlers til buttons
    private void bindHandlers() {
        adminMainView.addClickHandlers(new MenuClickHandler());

        adminMainView.getAdminCreateUserView().getSkjulPass().addClickHandler(new skjulPassBox());
        adminMainView.getAdminCreateUserView().getVisPass().addClickHandler(new visPassBox());
        adminMainView.getAdminCreateUserView().getMdA().addClickHandler(new customertype1());
        adminMainView.getAdminCreateUserView().getMdB().addClickHandler(new customertype2());
        adminMainView.getAdminCreateUserView().getMdC().addClickHandler(new customertype3());
        adminMainView.getAdminCreateUserView().getOpretKnap().addClickHandler(new opretMedlem());
        adminMainView.getAdminCreateUserView().getRkvinde().addClickHandler(new rKvindeBtn());
        adminMainView.getAdminCreateUserView().getRmand().addClickHandler(new rMandBtn());
        adminMainView.getAdminCreateUserView().getRydBtn().addClickHandler(new rydBtn());
        adminMainView.getAdminAllUserInfoView().addDeleteHandler(new deleteMemberBtn());
        adminMainView.getAdminAllUserInfoView().addUpdateHandler(new updateUserInfoBtn());
        adminMainView.getAdminUserChangeInfoView().getChangeUserInfBtn().addClickHandler(new editUserHandler());

        //adminMainView.getAdminUserChangeInfoView().addClickHandlers(new editUserHandler());
    }

    private class editUserHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {

            //checker om inputs overholder krav og tilføjer værdierne til brugeren
        if(adminMainView.getAdminUserChangeInfoView().valdateInput()){
            //toemmer input
            adminMainView.getAdminUserChangeInfoView().clearInput();

            User user = adminMainView.getAdminUserChangeInfoView().getUser();

            motionCBSServiceAsync.changeUserInfo(user, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Kunne ikke opdatere brugeren, fejl i kald til server");
                }

                @Override
                public void onSuccess(Void result) {
                    Window.alert("Det lykkedes at opdatere brugerens informationer");

                    //Udskriver de indtastede data bortset fra brugernavn og password
                    Window.alert("Dine oplysninger er nu rettet til: " +
                            "" + "\n" + "Fornavn: " + user.getFirstName()
                            + "\n" + "efternavn: " + user.getLastName()
                            + "\n" + "alder: " + user.getAge()
                            + "\n" + "Køn: " + user.getGender()
                            + "\n" + "Medlemstype: " + user.getCustomertype());

                    //adminMainView.getAdminUserChangeInfoView().clearInput();

                    loadTables();
                    listProviderUsers.getList().clear();
                    // updatere dataprovider til så den viser det nye input
                    listProviderUsers.refresh();
                    // viser updateret celltable
                    adminMainView.changeView(adminMainView.getAdminAllUserInfoView());

                    adminMainView.getAdminAllUserInfoView().initUsersTable(listProviderUsers);


                }
            });
        }




           }
    }

    //metode der fortæller hvad der skal ske når man trykker paa vores Action Cell 'update'
    class updateUserInfoBtn implements ActionCell.Delegate<User>{

        @Override
        public void execute(final User user) {
            adminMainView.getAdminUserChangeInfoView().clearInput();
            adminMainView.getAdminUserChangeInfoView().setUser(user);
            adminMainView.changeView(adminMainView.getAdminUserChangeInfoView());

        }
    }

    class deleteMemberBtn implements ActionCell.Delegate<User> {

        @Override
        public void execute(final User user) {

            //Spørger om man er sikker på at brugeren skal slettes
            boolean deleteUserConfirmed = Window.confirm("Are you sure you want to delete:\n" + user.getUsername()
                    + " \nWith id: " + user.getId());
            // Window.alert(user.getId() + "");
            //hvis man er sikker bliver der lavet et RPC kald til databasen der anmoder om sletning af en bruger med et bestemt id
            if (deleteUserConfirmed) {
                motionCBSServiceAsync.deleteUser(user.getId(), new AsyncCallback<Boolean>() {

                    //onFailure beskriver hvad der skal ske hvis RPC kaldet ikke virker som det skal
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Something went wrong");
                    }

                    /*
                     * onSuccess definerer hvordan serveren skal svare tilbage hvis kaldet lykkes
                     */
                    @Override
                    public void onSuccess(Boolean isDeleted) {
                        if (!isDeleted) {
                            Window.alert("Could not delete user");
                        } else {
                            // Hvis brugeren bliver slettet, fjerner vi den fra user-listen
                            listProviderUsers.getList().remove(user);
                        }

                    }
                });
            }

        }
    }




    //metode der fortæller hvad der sker når der bliver trykket på de forskellige buttons i vores adminMainView.
    class MenuClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == adminMainView.getUserInfoBtn()) {
                adminMainView.changeView(adminMainView.getAdminAllUserInfoView());


            } else if (event.getSource() == adminMainView.getOpretBtn()) {
                adminMainView.changeView(adminMainView.getAdminCreateUserView());

            } else if (event.getSource() == adminMainView.getStatsViewBtn()) {
                adminMainView.changeView(adminMainView.getAdminStatsView());

            }
            else if (event.getSource() == adminMainView.getRandomBtn()){
                adminMainView.changeView(adminMainView.getAdminUserChangeInfoView());
            }
            else if (event.getSource() == adminMainView.getLogoutBtn()) {
                content.changeView(content.getLoginView());

                currentUser = null;
                listProviderUsers.getList().clear();

            }
        }
    }

    //Metoder der bliver eksekveret når admin logger ind. Herefter sætter den admin til current user og loader resterende users table.
    void loadUser(User currentUser) {
        this.currentUser = currentUser;
        loadTables();
    }

    //Metode der indlæser user tablet ind til DataProvideren som indeholder en ArrayList.
    // Dette sker ved et RPC-kald som indhendter brugerene fra databasen
    private void loadTables() {
        motionCBSServiceAsync.getUsers(currentUser.getId(), new AsyncCallback<ArrayList<User>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Could not load users");
            }

            @Override
            public void onSuccess(ArrayList<User> users) {
                // tilføjer alle vores brugere til DataProvideren (ArrayList)
                listProviderUsers.getList().addAll(users);
            }
        });

    }
    //ved klik på knappen der rydder alt text og radiobuttons valg m.m.
        class rydBtn implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getRydBtn();
            {
                adminMainView.getAdminCreateUserView().clearInput();
            }
        }

    }

    //ved klik på radibutton'en bliver passwordet synligt
    class visPassBox implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getVisPass();
            {
                adminMainView.getAdminCreateUserView().getPasswordBox().getElement().setAttribute("type", "text");
                adminMainView.getAdminCreateUserView().getSkjulPass().setChecked(false);
            }
        }
    }

    //ved klik på radibutton'en bliver passwordet skjult
    class skjulPassBox implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getSkjulPass();
            {
                adminMainView.getAdminCreateUserView().getPasswordBox().getElement().setAttribute("type", "password");
                adminMainView.getAdminCreateUserView().getVisPass().setChecked(false);
            }
        }
    }

    class customertype1 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getMdA();
            {
                adminMainView.getAdminCreateUserView().getMdB().setChecked(false);
                adminMainView.getAdminCreateUserView().getMdC().setChecked(false);
            }
        }
    }

    class customertype2 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getMdB();
            {
                adminMainView.getAdminCreateUserView().getMdA().setChecked(false);
                adminMainView.getAdminCreateUserView().getMdC().setChecked(false);
            }
        }
    }

    class customertype3 implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            adminMainView.getAdminCreateUserView().getMdC();
            {
                adminMainView.getAdminCreateUserView().getMdA().setChecked(false);
                adminMainView.getAdminCreateUserView().getMdB().setChecked(false);
            }
        }
    }

    class rKvindeBtn implements ClickHandler {
        @Override
        public void onClick(ClickEvent event){
            adminMainView.getAdminCreateUserView().getRkvinde();
            {
                adminMainView.getAdminCreateUserView().getRmand().setChecked(false);
            }
        }
    }
    class rMandBtn implements ClickHandler {
        @Override
        public void onClick(ClickEvent event){
            adminMainView.getAdminCreateUserView().getRmand();
            {
                adminMainView.getAdminCreateUserView().getRkvinde().setChecked(false);
            }
        }
    }











//metode der fortaeller hvad der skal ske naar man trykker paa opret bruger
    class opretMedlem implements ClickHandler {

        //Fieldverifier der checker om vores inputs er som ønskede og hvis de er viser window alert vores indtastede input.
        @Override
        public void onClick(ClickEvent event) {
            if (FieldVerifier.isValidName(adminMainView.getAdminCreateUserView().getFornavnBox().getText())
                    && FieldVerifier.isValidName(adminMainView.getAdminCreateUserView().getEfternavnBox().getText())
                    && FieldVerifier.isValidAge(adminMainView.getAdminCreateUserView().getAlderBox().getText())
                    && FieldVerifier.isValidBrugernavn(adminMainView.getAdminCreateUserView().getBrugernavnBox().getText())
                    && FieldVerifier.isValidPass(adminMainView.getAdminCreateUserView().getPasswordBox().getText())
                    && FieldVerifier.isGenderPicked(adminMainView.getAdminCreateUserView().getRkvinde().isChecked())
                    || FieldVerifier.isGenderPicked(adminMainView.getAdminCreateUserView().getRmand().isChecked())
                    && FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdA().getValue())
                    || FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdB().getValue())
                    || FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdC().getValue()))
            {

                String firstName = adminMainView.getAdminCreateUserView().getFornavnBox().getText();
                String lastName = adminMainView.getAdminCreateUserView().getEfternavnBox().getText();
                int age = Integer.parseInt(adminMainView.getAdminCreateUserView().getAlderBox().getText());
                String username = adminMainView.getAdminCreateUserView().getBrugernavnBox().getText();
                String password = adminMainView.getAdminCreateUserView().getPasswordBox().getText();


                final User user = new User();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAge(age);
                user.setUsername(username);
                user.setPassword(password);

                if (adminMainView.getAdminCreateUserView().getRmand().getValue()) {
                    user.setGender("Male");
                } else if (adminMainView.getAdminCreateUserView().getRkvinde().getValue()) {
                    user.setGender("Female");
                }

                if (adminMainView.getAdminCreateUserView().getMdA().getValue()) {
                    user.setCustomertype(1);
                } else if (adminMainView.getAdminCreateUserView().getMdB().getValue()) {
                    user.setCustomertype(2);
                } else if (adminMainView.getAdminCreateUserView().getMdC().getValue()) {
                    user.setCustomertype(3);
                }


                motionCBSServiceAsync.createUser(user, new AsyncCallback<Boolean>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert("Fejl i server kald - Kunne ikke opdatere informationer");
                    }

                    @Override
                    public void onSuccess(Boolean isCreated) {

                        if (!isCreated) {
                            Window.alert("Could not create user");
                        } else {

                            // Hvis brugeren er oprettet bliver felterne ryddet og brugeren oprettet til listen
                            adminMainView.getAdminCreateUserView().clearInput();
                            listProviderUsers.getList().add(user);

                            //Udskriver de indtastede data bortset fra brugernavn og password
                            Window.alert("Følgende bruger er oprettet: " + "\n"
                                    + "Fornavn: " + user.getFirstName() + "\n"
                                    + "efternavn: " + user.getLastName() + "\n"
                                    + "alder: " + user.getAge() + "\n"
                                    + "username: " + user.getUsername() + "\n"
                                    + "password: " + user.getPassword() + "\n"
                                    + "Køn: " + user.getGender() + "\n"
                                    + "Medlemstype: " + user.getCustomertype());
                        }


                        loadTables();
                        listProviderUsers.getList().clear();
                        listProviderUsers.refresh();
                        adminMainView.changeView(adminMainView.getAdminAllUserInfoView());
                        adminMainView.getAdminAllUserInfoView().initUsersTable(listProviderUsers);

                    }

                });

            } else {
                // Brugeren får besked hvis han/hun ikke har udfyldt felterne korrekt.
                if (!FieldVerifier.isValidName(adminMainView.getAdminCreateUserView().getFornavnBox().getText()))
                    Window.alert("Venligst indtast et fornavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidName(adminMainView.getAdminCreateUserView().getEfternavnBox().getText()))
                    Window.alert("Venligst indtast et efternavn på min. 2 bogstaver! " + "\n");

                if (!FieldVerifier.isValidAge(adminMainView.getAdminCreateUserView().getAlderBox().getText()))
                    Window.alert("For at være medlem skal du mindst være 15 år, og højst 99");

                if (!FieldVerifier.isGenderPicked(adminMainView.getAdminCreateUserView().getRkvinde().isChecked())
                        && !FieldVerifier.isGenderPicked(adminMainView.getAdminCreateUserView().getRmand().isChecked()))
                    Window.alert("Du skal vælge ét køn");

                if (!FieldVerifier.isValidBrugernavn(adminMainView.getAdminCreateUserView().getBrugernavnBox().getText()))
                    Window.alert("Indast et brugernavn på minimum 3 karakter! (tal og/eller bogstaver)");

                if (!FieldVerifier.isValidPass(adminMainView.getAdminCreateUserView().getPasswordBox().getText()))
                    Window.alert("Dit password skal være på minimum 4 karakterer! (tal og/eller bogstaver)");


                if (!FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdA().isChecked())
                        && !FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdB().isChecked())
                        && !FieldVerifier.isCustomertypePicked(adminMainView.getAdminCreateUserView().getMdC().isChecked()))
                    Window.alert("Du skal vælge et medlemskab A, B eller C");

                Window.alert("Dine oplysninger blev ikke opdateret");
                adminMainView.changeView(adminMainView.getAdminCreateUserView());
            }


        }


    }
}

