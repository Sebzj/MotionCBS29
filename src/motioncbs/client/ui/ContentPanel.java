package motioncbs.client.ui;


import motioncbs.client.ui.admin.AdminMainView.AdminMainView;
import motioncbs.client.ui.login.LoginView;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import motioncbs.client.ui.login.SignUpView;
import motioncbs.client.ui.user.userMainView.UserMainView;

public class ContentPanel extends Composite {

    // The main panel in this class
    private DeckLayoutPanel contentPanel;

    // The three main panels of the applikation
    private LoginView loginView;
    private UserMainView userMainView;
    private AdminMainView adminMainView;
    private SignUpView signUpView;


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

        signUpView = new SignUpView();
        contentPanel.add(signUpView);

        //The panel that is shown when the application starts
        contentPanel.showWidget(loginView);

        //Init the main widget in this class
        initWidget(contentPanel);
    }

    //opretter metode til at aendre views
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

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
