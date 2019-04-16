package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import motioncbs.server.MotionCBSServiceImpl;
import motioncbs.shared.User;

public class MainController {

    //Opretter objekter af contentpanel og Kontrakt mellem server og client?????
    private ContentPanel content;
    private MotionCBSServiceAsync motionCBSService;

    //opretter objekter af adminController og userController

    private AdminController adminController;
    private UserController userController;

    //opretter constructor

    public MainController (ContentPanel content, MotionCBSServiceAsync motionCBSService) {

        this.content = content;
        this.motionCBSService = motionCBSService;

        adminController = new AdminController(content, motionCBSService);
        userController = new UserController(content, motionCBSService);
        bindHandlers();
    }

    public void bindHandlers(){
        content.getLoginView().addClickHandlers(new LoginClickHandler());
    }

    class LoginClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
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
                        if (user.getMedlemstype() == 4) {
                            adminController.loadUser(user);
                            content.changeView(content.getAdminMainView());
                            content.getAdminMainView().changeView(content.getAdminMainView().getAdminStatsView());

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




