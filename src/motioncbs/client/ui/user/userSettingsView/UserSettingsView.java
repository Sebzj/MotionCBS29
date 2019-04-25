package motioncbs.client.ui.user.userSettingsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class UserSettingsView extends Composite {
    interface userSettingsVIewUiBinder extends UiBinder<HTMLPanel, UserSettingsView> {
    }

    private static userSettingsVIewUiBinder ourUiBinder = GWT.create(userSettingsVIewUiBinder.class);

    @UiField
    TextBox firstNameBox, lastNameBox, ageBox, usernameBox, passwordBox;

    @UiField
    CheckBox maleCheckbox, femaleCheckbox;

    @UiField
    RadioButton radioButtonA, radioButtonB, radioButtonC;

    @UiField
    Button changeProfileBtn;

    public UserSettingsView() {
        initWidget(ourUiBinder.createAndBindUi(this));


    }

 // tilføjer clickhandler til changeProfile button
    public void addClickHandlers(ClickHandler clickHandler){
        changeProfileBtn.addClickHandler(clickHandler);

    }

    public void clearInput(){
        getFirstNameBox().setText("");
        getLastNameBox().setText("");
        getAgeBox().setText("");
        getUsernameBox().setText("");
        getPasswordBox().setText("");
        getFemaleCheckbox().setChecked(false);
        getMaleCheckbox().setChecked(false);
        getRadioButtonA().setChecked(false);
        getRadioButtonB().setChecked(false);
        getRadioButtonC().setChecked(false);
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

    public Button getChangeProfileBtn() {
        return changeProfileBtn;
    }
}