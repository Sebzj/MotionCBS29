package motioncbs.client.ui.admin.AdminUserChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import motioncbs.shared.FieldVerifier;
import motioncbs.shared.User;

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

    //reference til DTO
    User user;



    private static AdminUserChangeInfoViewUiBinder ourUiBinder = GWT.create(AdminUserChangeInfoViewUiBinder.class);

    public AdminUserChangeInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));


    }
    // tilføjer clickhandler til changeUserInfBtn button

    public void addClickHandlers(ClickHandler clickHandler){
        changeUserInfBtn.addClickHandler(clickHandler);

    }

    public void setUser(User user){
        this.user = user;

       // saetter vaerdier i input til user objekt
        firstNameBox.setText(user.getFirstName());
        lastNameBox.setText(user.getLastName());


        ageBox.setText(String.valueOf(user.getAge()));

        usernameBox.setText(user.getUsername());
        passwordBox.setText(user.getPassword());


        //saetter user til mand eller kvinde efter hvad personen vaelger
        if (user.getGender() == "Male"){
            maleCheckbox.setChecked(true);
        } else if(user.getGender() == "Female"){
            femaleCheckbox.setChecked(true);
        }

        //saetter users medlemskab til 1, 2 eller 3 alt efter hvilket medlemskab der vaelges
        if (user.getCustomertype() == 1){
            radioButtonA.setChecked(true);
            radioButtonB.setChecked(false);
            radioButtonC.setChecked(false);
        } else if (user.getCustomertype() == 2) {
            radioButtonB.setChecked(true);
            radioButtonC.setChecked(false);
            radioButtonA.setChecked(false);
        } else if(user.getCustomertype() == 3) {
            radioButtonC.setChecked(true);
            radioButtonA.setChecked(false);
            radioButtonB.setChecked(false);
        }

    }


    public Boolean valdateInput() {
// checker at alle krav for oplysningerne er overholdt
        if (FieldVerifier.isValidName(getFirstNameBox().getText())
                && FieldVerifier.isValidName(getLastNameBox().getText())
                && FieldVerifier.isValidAge(getAgeBox().getText())
                && FieldVerifier.isValidBrugernavn(getUsernameBox().getText())
                && FieldVerifier.isValidPass(getPasswordBox().getText())
                && FieldVerifier.isGenderPicked(getFemaleCheckbox().isChecked())
                || FieldVerifier.isGenderPicked(getMaleCheckbox().isChecked())
                && FieldVerifier.isCustomertypePicked(getRadioButtonA().isChecked())
                || FieldVerifier.isCustomertypePicked(getRadioButtonB().isChecked())
                || FieldVerifier.isCustomertypePicked(getRadioButtonC().isChecked())){

            //updatere informationer paa brugeren til de indtastede vaerdier
            user.setFirstName(firstNameBox.getText());
            user.setLastName(lastNameBox.getText());
            user.setAge(Integer.parseInt(ageBox.getText()));
            if (femaleCheckbox.isChecked()){
                user.setGender("Female");
            } else if (maleCheckbox.isChecked()){
                user.setGender("Male");
            }
            user.setUsername(usernameBox.getText());
            user.setPassword(passwordBox.getText());

            if (radioButtonA.isChecked()) {
                user.setCustomertype(1);
            } else if (radioButtonB.isChecked()) {
                user.setCustomertype(2);
            } else if (radioButtonC.isChecked()) {
                user.setCustomertype(3);
            }

            // fjerner det indtastede og udfoere klik
            clearInput();
            return true;


        }
        // kalder Fieldverifier saa brugeren har nogle krav til det indtastede
         else {
            // admin får besked hvis han/hun ikke har udfyldt felterne korrekt.
            if (!FieldVerifier.isValidName(getFirstNameBox().getText()))
                Window.alert("Venligst indtast et fornavn på min. 2 bogstaver! " + "\n");

            if (!FieldVerifier.isValidName(getLastNameBox().getText()))
                Window.alert("Venligst indtast et efternavn på min. 2 bogstaver! " + "\n");

            if (!FieldVerifier.isValidAge(getAgeBox().getText()))
                Window.alert("For at være medlem skal du mindst være 15 år, og højst 99");

            if (!FieldVerifier.isGenderPicked(getFemaleCheckbox().isChecked())
                    && !FieldVerifier.isGenderPicked(getMaleCheckbox().isChecked()))
                Window.alert("Du skal vælge ét køn");

            if (!FieldVerifier.isValidBrugernavn(getUsernameBox().getText()))
                Window.alert("Indast et brugernavn på minimum 3 karakter! (tal og/eller bogstaver)");

            if (!FieldVerifier.isValidPass(getPasswordBox().getText()))
                Window.alert("Dit password skal være på minimum 4 karakterer! (tal og/eller bogstaver)");


            if (!FieldVerifier.isCustomertypePicked(getRadioButtonA().isChecked())
                    && !FieldVerifier.isCustomertypePicked(getRadioButtonB().isChecked())
                    && !FieldVerifier.isCustomertypePicked(getRadioButtonC().isChecked()))
                Window.alert("Du skal vælge et medlemskab A, B eller C");

            return false;
        }

    }

    public void clearInput(){
        firstNameBox.setText("");
        lastNameBox.setText("");
        ageBox.setText("");
        usernameBox.setText("");
        passwordBox.setText("");
        femaleCheckbox.setChecked(false);
        maleCheckbox.setChecked(false);
        radioButtonA.setChecked(false);
        radioButtonB.setChecked(false);
        radioButtonC.setChecked(false);
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

    public User getUser() {
        return user;
    }

}