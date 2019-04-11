package motioncbs.client.logic;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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

    public AdminController (ContentPanel contentPanel, MotionCBSServiceAsync motionCBSServiceAsync) {

        this.contentPanel = contentPanel;
        this.motionCBSServiceAsync = motionCBSServiceAsync;
        this.adminMainView = contentPanel.getAdminMainView();

    }

    public void loadUser(User currentUser) {
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

