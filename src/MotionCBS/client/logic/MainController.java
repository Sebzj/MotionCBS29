package MotionCBS.client.logic;

import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;

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


    }



}



