package MotionCBS.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class LoginView extends Composite {
    interface loginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    private static loginViewUiBinder ourUiBinder = GWT.create(loginViewUiBinder.class);

    public LoginView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}