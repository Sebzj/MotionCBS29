package motioncbs.client.ui.signup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class SignUpView extends Composite {
    interface SignUpUiBinder extends UiBinder<HTMLPanel, SignUpView> {
    }

    private static SignUpUiBinder ourUiBinder = GWT.create(SignUpUiBinder.class);

    public SignUpView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    //Diverse UiFields
    @UiField
    RadioButton femaleCheckbox, maleCheckbox, radioButtonC, radioButtonA, radioButtonB, hidePass, showPass;

    @UiField
    TextBox fornavnBox, efternavnBox, brugernavnBox, alderBox;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button opretKnap, rydBtn;


    public void addClickHandlers(ClickHandler clickHandler){
        getOpretKnap().addClickHandler(clickHandler);
    }

    public void clearInput(){
        fornavnBox.setText("");
        efternavnBox.setText("");
        brugernavnBox.setText("");
        passwordBox.setText("");
        alderBox.setText("");
        femaleCheckbox.setValue(Boolean.valueOf(""));
        maleCheckbox.setValue(Boolean.valueOf(""));
        radioButtonA.setValue(Boolean.valueOf(""));
        getRadioButtonB().setValue(Boolean.valueOf(""));
        getRadioButtonC().setValue(Boolean.valueOf(""));
        showPass.setValue(Boolean.valueOf(""));
        hidePass.setValue(Boolean.valueOf(""));

    }

    public RadioButton getFemaleCheckbox() {
        return femaleCheckbox;
    }

    public RadioButton getMaleCheckbox() {
        return maleCheckbox;
    }

    public RadioButton getRadioButtonC() {
        return radioButtonC;
    }

    public RadioButton getRadioButtonA() {
        return radioButtonA;
    }

    public RadioButton getRadioButtonB() {
        return radioButtonB;
    }

    public RadioButton getHidePass() {
        return hidePass;
    }

    public RadioButton getShowPass() {
        return showPass;
    }

    public TextBox getFornavnBox() {
        return fornavnBox;
    }

    public TextBox getEfternavnBox() {
        return efternavnBox;
    }

    public TextBox getBrugernavnBox() {
        return brugernavnBox;
    }

    public TextBox getAlderBox() {
        return alderBox;
    }

    public PasswordTextBox getPasswordBox() {
        return passwordBox;
    }

    public Button getOpretKnap() {
        return opretKnap;
    }

    public Button getRydBtn() {
        return rydBtn;
    }
}