package motioncbs.client.ui.admin.AdminMainView;

import motioncbs.client.ui.admin.AdminAllUserInfoView.AdminAllUserInfoView;
import motioncbs.client.ui.admin.AdminCreateUserView.AdminCreateUserView;
import motioncbs.client.ui.admin.AdminStatsView.AdminStatsView;
import motioncbs.client.ui.admin.AdminUserChangeInfoView.AdminUserChangeInfoView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminMainView extends Composite {

    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);


    private AdminMainView adminMainView;
    private AdminAllUserInfoView adminAllUserInfoView;
    private AdminCreateUserView adminCreateUserView;
    private AdminStatsView adminStatsView;
    private AdminUserChangeInfoView adminUserChangeInfoView;

    @UiField
    Button logoutBtn, statsViewBtn, userInfoBtn, opretBtn, randomBtn;
    @UiField
    DeckLayoutPanel centerPanel;

    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    //Constructor af klassen der opretter en instans af panelerne og tilføjer dem til Decklayoutpanelet
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
        opretBtn.addClickHandler(clickHandler);
        statsViewBtn.addClickHandler(clickHandler);
        userInfoBtn.addClickHandler(clickHandler);
        logoutBtn.addClickHandler(clickHandler);
        randomBtn.addClickHandler(clickHandler);
    }


    public void changeView(Widget panel){
        centerPanel.showWidget(panel);
    }

    //Gettes for viewss
    public AdminAllUserInfoView getAdminAllUserInfoView() {
        return adminAllUserInfoView;
    }

    public AdminCreateUserView getAdminCreateUserView() {
        return adminCreateUserView;
    }

    public AdminStatsView getAdminStatsView() {
        return adminStatsView;
    }

    public AdminUserChangeInfoView getAdminUserChangeInfoView() {
        return adminUserChangeInfoView;
    }

    //get methods til vores menu button  - til at bruge clickhandlers i vores AdminController
    public Button getOpretBtn() {
        return opretBtn;
    }

    public Button getLogoutBtn() {
        return logoutBtn;
    }

    public Button getStatsViewBtn() {
        return statsViewBtn;
    }

    public Button getUserInfoBtn() {
        return userInfoBtn;

    }

    public Button getRandomBtn() {
        return randomBtn;
    }
}