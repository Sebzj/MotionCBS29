package MotionCBS.client.logic;

import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;
import MotionCBS.client.ui.login.LoginView;
import MotionCBS.shared.User;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MainController {

    //Opretter objekter af contentpanel og Kontrakt mellem server og client?????
    private ContentPanel content;
    private MotionCBSServiceAsync motionCBSServiceAsync;

    //opretter objekter af adminController og userController

    private AdminController adminController;
    private UserController userController;

    //opretter constructor

    public MainController (ContentPanel content, MotionCBSServiceAsync motionCBSService) {


        this.content = content;
        this.motionCBSServiceAsync = motionCBSService;

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


        }
    }
}



