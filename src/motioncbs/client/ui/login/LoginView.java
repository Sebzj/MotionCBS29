package motioncbs.client.ui.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;

public class LoginView extends Composite {
    interface LoginViewUiBinder extends UiBinder<HTMLPanel, LoginView> {
    }

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    @UiField
    Button loginBtn, signUpBtn;

    @UiField
    TextBox usernameBox, passwordBox;

    public LoginView() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void addClickHandlers(ClickHandler clickHandler) {
        loginBtn.addClickHandler(clickHandler);
        signUpBtn.addClickHandler(clickHandler);
    }

    //metode der tømmer tekstboksene username og password så andre ikke kan se det når brugeren logger ud.

    public void clearTextBox(){
        usernameBox.setText("");
        passwordBox.setText("");
    }

    //getters for username og password bokse

    public TextBox getUsernameBox() {
        return usernameBox;
    }

    public TextBox getPasswordBox() {
        return passwordBox;
    }

    public Button getSignUpBtn() {
        return signUpBtn;
    }

    public Button getLoginBtn() {
        return loginBtn;
    }
}