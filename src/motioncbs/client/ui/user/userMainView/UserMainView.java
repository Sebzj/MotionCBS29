
package motioncbs.client.ui.user.userMainView;


import motioncbs.client.ui.user.userInfoView.UserInfoView;
import motioncbs.client.ui.user.userSettingsView.UserSettingsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class UserMainView extends Composite {
    interface userMainViewUiBinder extends UiBinder<HTMLPanel, UserMainView> {
    }

    private static userMainViewUiBinder ourUiBinder = GWT.create(userMainViewUiBinder.class);

    @UiField
    DeckLayoutPanel centerPanel;

    @UiField
    Button settingsBtn, infoBtn, logoutBtn;



    private UserInfoView userInfoView;
    private UserSettingsView userSettingsView;
    private UserMainView userMainView;



    public UserMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        //tilfoejer alle userviews til centerPanel

        userInfoView = new UserInfoView();
        centerPanel.add(userInfoView);


        userSettingsView = new UserSettingsView();
        centerPanel.add(userSettingsView);

        //The panel that is shown when the application starts
        centerPanel.showWidget(userInfoView);
    }



    //metode der tilfoejer clickhandlers til alle knapperne i UserMainView
    public void addClickHandlers(ClickHandler clickHandler){
        settingsBtn.addClickHandler(clickHandler);
        infoBtn.addClickHandler(clickHandler);
        logoutBtn.addClickHandler(clickHandler);
    }

    public void changeView(Widget panel){
        centerPanel.showWidget(panel);
    }


    // getters for alle knapperne i UserMainVIew
    public Button getSettingsBtn() {
        return settingsBtn;
    }

    public Button getInfoBtn() {
        return infoBtn;
    }


    public Button getLogoutBtn() {
        return logoutBtn;
    }


    //Getters for de forskellige views en bruger kan tilgaa.

    public UserInfoView getUserInfoView() {
        return userInfoView;
    }

    public UserSettingsView getUserSettingsView() {
        return userSettingsView;
    }

    public UserMainView getUserMainView() {
        return userMainView;
    }
}