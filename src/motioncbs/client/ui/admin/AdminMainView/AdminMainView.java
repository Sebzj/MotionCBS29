package MotionCBS.client.ui.admin.AdminMainView;

import MotionCBS.client.ui.admin.AdminAllUserInfoView.AdminAllUserInfoView;
import MotionCBS.client.ui.admin.AdminCreateUserView.AdminCreateUserView;
import MotionCBS.client.ui.admin.AdminStatsView.AdminStatsView;
import MotionCBS.client.ui.admin.AdminUserChangeInfoView.AdminUserChangeInfoView;
import MotionCBS.client.ui.user.userChangeInfoView.UserChangeInfoView;
import MotionCBS.client.ui.user.userInfoView.UserInfoView;
import MotionCBS.client.ui.user.userSettingsView.UserSettingsVIew;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminMainView extends Composite {
    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }


    @UiField
    Button logoutBtn;
    @UiField
    DeckLayoutPanel centerPanel;

    private AdminMainView adminMainView;
    private AdminAllUserInfoView adminAllUserInfoView;
    private AdminCreateUserView adminCreateUserView;
    private AdminStatsView adminStatsView;
    private AdminUserChangeInfoView adminUserChangeInfoView;

    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));


        adminAllUserInfoView = new AdminAllUserInfoView();
        centerPanel.add((IsWidget) adminAllUserInfoView);

        adminCreateUserView = new AdminCreateUserView();
        centerPanel.add((IsWidget) adminCreateUserView);


        adminStatsView = new AdminStatsView();
        centerPanel.add((IsWidget) adminStatsView);

        adminUserChangeInfoView = new AdminUserChangeInfoView();
        centerPanel.add((IsWidget) adminUserChangeInfoView);

        //The panel that is shown when the application starts
        centerPanel.showWidget(adminMainView);
    }

    //metode der tilfoejer clickhandlers til alle knapperne i UserMainView
    public void addClickHandlers(ClickHandler clickHandler){
        //usersBtn.addClickHandler(clickHandler);
        //settingsBtn.addClickHandler(clickHandler);
        //infoBtn.addClickHandler(clickHandler);
        logoutBtn.addClickHandler(clickHandler);
    }

    public void changeView(Widget panel){
        centerPanel.showWidget(panel);
    }
}