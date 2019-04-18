package motioncbs.client.logic;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import motioncbs.client.ui.admin.AdminMainView.AdminMainView;
import motioncbs.shared.User;

import java.util.ArrayList;

class AdminController {

    private User currentUser;
    private ContentPanel content;
    private AdminMainView adminMainView;
    private MotionCBSServiceAsync motionCBSServiceAsync;
    //opretter constructor

    AdminController(ContentPanel content, MotionCBSServiceAsync motionCBSService) {

        this.content = content;
        this.motionCBSServiceAsync = motionCBSService;
        this.adminMainView = content.getAdminMainView();

        bindHandlers();
    }

    private void bindHandlers() {
        adminMainView.addClickHandlers(new MenuClickHandler());
    }
    //metode der fortaeller hvad der sker naar der bliver trykket paa de forskellige buttons i adminMainView.
    class MenuClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {
            if (event.getSource() == adminMainView.getUserInfoBtn()) {
                adminMainView.changeView(adminMainView.getAdminAllUserInfoView());

            } else if (event.getSource() == adminMainView.getOpretBtn()) {
                adminMainView.changeView(adminMainView.getAdminCreateUserView());

            } else if (event.getSource() == adminMainView.getStatsViewBtn()) {
                adminMainView.changeView(adminMainView.getAdminStatsView());

            } else if (event.getSource() == adminMainView.getAdminUserChangeInfoView()) {
                adminMainView.changeView(adminMainView.getAdminUserChangeInfoView());

            } else if (event.getSource() == adminMainView.getRandomBtn()) {
                adminMainView.changeView(adminMainView.getAdminUserChangeInfoView());

            } else if (event.getSource() == adminMainView.getLogoutBtn()) {
                content.changeView(content.getLoginView());

                currentUser=null;

            }
        }
    }

    void loadUser(User currentUser) {
        this.currentUser = currentUser;
        loadTables();
    }
    private void loadTables() {
        motionCBSServiceAsync.getUsers(currentUser.getId(), new AsyncCallback<ArrayList<User>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Could not load users");
            }

            @Override
            public void onSuccess(ArrayList<User> users) {
                // Adding all the users to the DataProvider (ArrayList)
               // motionCBSServiceAsync.getList().addAll(users);
            }
        });

    }

}

