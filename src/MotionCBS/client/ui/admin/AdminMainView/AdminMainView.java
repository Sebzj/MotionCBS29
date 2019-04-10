package MotionCBS.client.ui.admin.AdminMainView;

import MotionCBS.client.ui.admin.AdminAllUserInfoView.AdminAllUserInfoView;
import MotionCBS.client.ui.admin.AdminCreateUserView.AdminCreateUserView;
import MotionCBS.client.ui.admin.AdminCreateUserView.AdminCreateUserView;
import MotionCBS.client.ui.admin.AdminStatsView.AdminStatsView;
import MotionCBS.client.ui.admin.AdminUserChangeInfoView.AdminUserChangeInfoView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminMainView extends Composite {
    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    @UiField
    Button logoutBtn;
    @UiField
    DeckLayoutPanel centerPanel;

    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));


    }


    private AdminCreateUserView adminCreateUserView;
    private AdminAllUserInfoView adminAllUserInfoView;
    private AdminStatsView adminStatsView;
    private AdminUserChangeInfoView adminUserChangeInfoView;


}