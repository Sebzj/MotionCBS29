package MotionCBS.client.ui.admin.AdminUserChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class AdminUserChangeInfoView {
    interface AdminUserChangeInfoViewUiBinder extends UiBinder<DivElement, AdminUserChangeInfoView> {
    }

    private static AdminUserChangeInfoViewUiBinder ourUiBinder = GWT.create(AdminUserChangeInfoViewUiBinder.class);

    public AdminUserChangeInfoView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}