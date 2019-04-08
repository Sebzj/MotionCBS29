package MotionCBS.client.logic;

import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;
import MotionCBS.client.ui.login.LoginView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class MainController {

    //Opretter objekter af contentpanel og Kontrakt mellem server og client?????
    private ContentPanel content;
    private MotionCBSServiceAsync rpcService;

    //opretter objekter af adminController og userController

    private AdminController adminController;
    private UserController userController;

    //opretter constructor

    public MainController (ContentPanel content, MotionCBSServiceAsync rpcService) {


        this.content = content;
        this.rpcService = rpcService;

        bindHandlers();
    }

    public void bindHandlers(){
        content.getLoginView().addClickHandlers(new LoginClickHandler());
    }

    class LoginClickHandler implements ClickHandler{

        @Override
        public void onClick(ClickEvent event) {
    //henter indhold fra usernamebox og passwordbox og saetter det lig String username og password
            String username = content.getLoginView().getUsernameBox().getText();
            String password = content.getLoginView().getPasswordBox().getText();
        }
    }

}



