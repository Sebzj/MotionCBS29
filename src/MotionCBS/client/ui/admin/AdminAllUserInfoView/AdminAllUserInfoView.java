package MotionCBS.client.ui.admin.AdminAllUserInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminAllUserInfoView {
    interface AdminAllUserInfoViewUiBinder extends UiBinder<HTMLPanel, AdminAllUserInfoView> {
    }

    private static AdminAllUserInfoViewUiBinder ourUiBinder = GWT.create(AdminAllUserInfoViewUiBinder.class);

    public AdminAllUserInfoView() {
        HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    }
}