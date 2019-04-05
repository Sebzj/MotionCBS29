package MotionCBS.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class loginView extends Composite {
    interface loginViewUiBinder extends UiBinder<HTMLPanel, loginView> {
    }

    private static loginViewUiBinder ourUiBinder = GWT.create(loginViewUiBinder.class);

    public loginView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}