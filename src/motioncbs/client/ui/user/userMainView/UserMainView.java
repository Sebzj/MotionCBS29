
package motioncbs.client.ui.user.userMainView;

import motioncbs.client.ui.user.userChangeInfoView.UserChangeInfoView;
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
    Button settingsBtn, infoBtn, usersBtn, logoutBtn;


    private UserChangeInfoView userChangeInfoView;
    private UserInfoView userInfoView;
    private UserSettingsView userSettingsView;
    private UserMainView userMainView;




    public UserMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));


        userChangeInfoView = new UserChangeInfoView();
        centerPanel.add(userChangeInfoView);

        userInfoView = new UserInfoView();
        centerPanel.add(userInfoView);


        userSettingsView = new UserSettingsView();
        centerPanel.add(userSettingsView);

        //The panel that is shown when the application starts
        centerPanel.showWidget(userInfoView);
    }



    //metode der tilfoejer clickhandlers til alle knapperne i UserMainView
    public void addClickHandlers(ClickHandler clickHandler){
        usersBtn.addClickHandler(clickHandler);
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

    public Button getUsersBtn() {
        return usersBtn;
    }

    public Button getLogoutBtn() {
        return logoutBtn;
    }

    //Getters for de forskellige views en bruger kan tilgaa.
    public UserChangeInfoView getUserChangeInfoView() {
        return userChangeInfoView;
    }

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