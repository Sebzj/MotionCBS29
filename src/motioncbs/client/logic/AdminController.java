package motioncbs.client.logic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import motioncbs.client.ui.admin.AdminMainView.AdminMainView;
import motioncbs.shared.User;

import java.util.ArrayList;

public class AdminController {


    private User currentUser;
    private ContentPanel contentPanel;
    private AdminMainView adminMainView;
    private MotionCBSServiceAsync motionCBSServiceAsync;
    //opretter constructor

    private ListDataProvider<User> listProviderUsers;


    public AdminController (ContentPanel contentPanel, MotionCBSServiceAsync motionCBSServiceAsync) {

        this.contentPanel = contentPanel;
        this.motionCBSServiceAsync = motionCBSServiceAsync;
        this.adminMainView = contentPanel.getAdminMainView();

        bindHandlers();
    }

    //Metode til at binde vores handlers til menu knapperne
    private void bindHandlers() {
        adminMainView.addClickHandlers(new MenuClickHandler());
    }


    class MenuClickHandler implements ClickHandler {


        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == adminMainView.getLogoutBtn()) {
                contentPanel.changeView(contentPanel.getLoginView());
            } else if(event.getSource() == adminMainView.getOpretBtn()) {
                adminMainView.changeView(adminMainView.getAdminCreateUserView());
            }else if(event.getSource() == adminMainView.getUserInfoBtn()) {
                adminMainView.changeView(adminMainView.getAdminAllUserInfoView());
            }else if(event.getSource() == adminMainView.getStatsViewBtn()) {
                adminMainView.changeView(adminMainView.getAdminStatsView());
            }
        }
    }


        /**
         * Method which is executed when a user (admin) is logged in
         * It sets the current user and loading the users table
         *
         * @param currentUser
         */
        public void loadUser(User currentUser) {
            this.currentUser = currentUser;

        }


    }

