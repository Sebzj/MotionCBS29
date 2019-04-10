package MotionCBS.client.ui;

import MotionCBS.client.ui.admin.AdminCreateUserView.AdminCreateUserView.AdminCreateUserView;
import MotionCBS.client.ui.admin.AdminMainView.AdminMainView;
import MotionCBS.client.ui.login.LoginView;
import MotionCBS.client.ui.user.userMainView.UserMainView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

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
        contentPanel.showWidget(adminMainView);

        //Init the main widget in this class
        initWidget(contentPanel);
    }

    //opretter metode til at aendrer views
    public void changeView(Widget panel) {
        contentPanel.showWidget(panel);
    }

    //getters for alle MainView saa vi kan skifte view

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
