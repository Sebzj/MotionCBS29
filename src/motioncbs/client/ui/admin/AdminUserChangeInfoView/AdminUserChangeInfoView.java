package motioncbs.client.ui.admin.AdminUserChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class AdminUserChangeInfoView extends Composite {
    interface AdminUserChangeInfoViewUiBinder extends UiBinder<HTMLPanel, AdminUserChangeInfoView> {
    }

    @UiField
    TextBox efternavnBox, fornavnBox;

    private static AdminUserChangeInfoViewUiBinder ourUiBinder = GWT.create(AdminUserChangeInfoViewUiBinder.class);

    public AdminUserChangeInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}