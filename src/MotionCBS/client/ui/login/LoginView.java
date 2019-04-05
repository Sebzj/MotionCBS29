package MotionCBS.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class LoginView extends Composite {
    interface LoginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    @UiField
    Button loginBtn;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void addClickHandlers(ClickHandler clickHandler) {
        loginBtn.addClickHandler(clickHandler);
    }


}