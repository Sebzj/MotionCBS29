package motioncbs.client.ui.admin.AdminUserChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminUserChangeInfoView extends Composite {
    interface AdminUserChangeInfoViewUiBinder extends UiBinder<HTMLPanel, AdminUserChangeInfoView> {
    }

    @UiField
    TextBox firstNameBox, lastNameBox, ageBox, usernameBox, passwordBox;

    @UiField
    CheckBox maleCheckbox, femaleCheckbox;

    @UiField
    RadioButton radioButtonA, radioButtonB, radioButtonC;

    @UiField
    Button changeUserInfBtn;

    private static AdminUserChangeInfoViewUiBinder ourUiBinder = GWT.create(AdminUserChangeInfoViewUiBinder.class);

    public AdminUserChangeInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
    // tilføjer clickhandler til changeUserInfBtn button

    public void addClickHandlers(ClickHandler clickHandler){
        changeUserInfBtn.addClickHandler(clickHandler);

    }


    public TextBox getFirstNameBox() {
        return firstNameBox;
    }

    public TextBox getLastNameBox() {
        return lastNameBox;
    }

    public TextBox getAgeBox() {
        return ageBox;
    }

    public TextBox getUsernameBox() {
        return usernameBox;
    }

    public TextBox getPasswordBox() {
        return passwordBox;
    }

    public CheckBox getMaleCheckbox() {
        return maleCheckbox;
    }

    public CheckBox getFemaleCheckbox() {
        return femaleCheckbox;
    }

    public RadioButton getRadioButtonA() {
        return radioButtonA;
    }

    public RadioButton getRadioButtonB() {
        return radioButtonB;
    }

    public RadioButton getRadioButtonC() {
        return radioButtonC;
    }

    public Button getChangeUserInfBtn() {
        return changeUserInfBtn;
    }
}