package motioncbs.client.ui.admin.AdminCreateUserView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import motioncbs.shared.FieldVerifier;



public class AdminCreateUserView extends Composite {
    interface AdminCreateUserViewUiBinder extends UiBinder<HTMLPanel, AdminCreateUserView> {
    }

    //Diverse UiFields
    @UiField
    RadioButton rkvinde, rmand, mdA, mdB, mdC, visPass, skjulPass;

    @UiField
    TextBox fornavnBox, efternavnBox, brugernavnBox, alderBox;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button opretKnap, rydBtn;

    private static AdminCreateUserViewUiBinder ourUiBinder = GWT.create(AdminCreateUserViewUiBinder.class);

    public AdminCreateUserView() {
        initWidget(ourUiBinder.createAndBindUi(this));




    }


    //ved klik på knappen der rydder alt text og radiobuttons valg m.m.

        public void clearInput(){
            fornavnBox.setText("");
            efternavnBox.setText("");
            brugernavnBox.setText("");
            passwordBox.setText("");
            alderBox.setText("");
            rkvinde.setValue(Boolean.valueOf(""));
            rmand.setValue(Boolean.valueOf(""));
            mdA.setValue(Boolean.valueOf(""));
            mdB.setValue(Boolean.valueOf(""));
            mdC.setValue(Boolean.valueOf(""));
            visPass.setValue(Boolean.valueOf(""));
            skjulPass.setValue(Boolean.valueOf(""));

        }




    public RadioButton getRkvinde() {
        return rkvinde;
    }

    public RadioButton getRmand() {
        return rmand;
    }

    public RadioButton getMdA() {
        return mdA;
    }

    public RadioButton getMdB() {
        return mdB;
    }

    public RadioButton getMdC() {
        return mdC;
    }

    public RadioButton getVisPass() {
        return visPass;
    }

    public RadioButton getSkjulPass() {
        return skjulPass;
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

