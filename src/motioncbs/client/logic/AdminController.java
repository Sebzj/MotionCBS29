package MotionCBS.client.logic;

import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;
import MotionCBS.client.ui.admin.AdminMainView.AdminMainView;
import MotionCBS.client.ui.user.userMainView.UserMainView;

public class AdminController {

    private ContentPanel contentPanel;
    private AdminMainView adminMainView;
    private MotionCBSServiceAsync motionCBSServiceAsync;
    //opretter constructor

    public AdminController (ContentPanel contentPanel, MotionCBSServiceAsync motionCBSServiceAsync) {

        this.contentPanel = contentPanel;
        this.motionCBSServiceAsync = motionCBSServiceAsync;
        this.adminMainView = contentPanel.getAdminMainView();

    }

}

