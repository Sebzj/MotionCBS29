package MotionCBS.client.ui.AdminView.AdminAllUserInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class AdminAllUserInfoView {
    interface AdminAllUserInfoViewUiBinder extends UiBinder<DivElement, AdminAllUserInfoView> {
    }

    private static AdminAllUserInfoViewUiBinder ourUiBinder = GWT.create(AdminAllUserInfoViewUiBinder.class);

    public AdminAllUserInfoView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}