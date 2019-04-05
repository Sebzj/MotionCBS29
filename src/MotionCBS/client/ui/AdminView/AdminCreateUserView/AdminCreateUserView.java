package MotionCBS.client.ui.AdminView.AdminCreateUserView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class AdminCreateUserView {
    interface AdminCreateUserViewUiBinder extends UiBinder<DivElement, AdminCreateUserView> {
    }

    private static AdminCreateUserViewUiBinder ourUiBinder = GWT.create(AdminCreateUserViewUiBinder.class);

    public AdminCreateUserView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}