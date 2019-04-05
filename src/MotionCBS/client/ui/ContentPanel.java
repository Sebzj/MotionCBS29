package MotionCBS.client.ui;

import MotionCBS.client.ui.AdminView.AdminMainView;
import MotionCBS.client.ui.login.LoginView;
import MotionCBS.client.ui.user.userMainView.UserMainView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;

public class ContentPanel extends Composite {

    // The main panel in this class
    private DeckLayoutPanel contentPanel;

    // The three main panels of the applikation
    private LoginView loginView;
    private UserMainView userMainView;
    private AdminMainView adminMainView;

    /**
     * The constructor of this class which is creating an instance of the panels and
     * adding them to the DeckLayoutPanel
     */
    public ContentPanel() {
        contentPanel = new DeckLayoutPanel();

        loginView = new LoginView();
        contentPanel.add(loginView);

        userMainView = new UserMainView();
        contentPanel.add(userMainView);

        adminMainView = new AdminMainView();
        contentPanel.add(adminMainView);

        //The panel that is shown when the application starts
        contentPanel.showWidget(loginView);

        //Init the main widget in this class
        initWidget(contentPanel);
    }

    //getters for alle MainView

    public LoginView getLoginView() {
        return loginView;
    }

    public UserMainView getUserMainView() {
        return userMainView;
    }

    public AdminMainView getAdminMainView() {
        return adminMainView;
    }
}
