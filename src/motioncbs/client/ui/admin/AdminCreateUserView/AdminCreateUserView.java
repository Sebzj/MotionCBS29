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
    TextBox fornavnBox, efternavnBox, brugernavnBox, alderTxt;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button knap, rydBtn;

    private static AdminCreateUserViewUiBinder ourUiBinder = GWT.create(AdminCreateUserViewUiBinder.class);

    public AdminCreateUserView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        addClickHandlers();

        //Tilføjer vores knap til clickhandler
        knap.addClickHandler(new Handler2());

    }
    private void addClickHandlers() {

        visPass.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                passwordBox.getElement().setAttribute("type", "text");
            }
        });

        skjulPass.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                passwordBox.getElement().setAttribute("type", "password");
            }
        });

        //ved klik på knappen der rydder alt text og radiobuttons valg m.m.
        rydBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                fornavnBox.setText("");
                efternavnBox.setText("");
                brugernavnBox.setText("");
                passwordBox.setText("");
                alderTxt.setText("");
                rkvinde.setValue(Boolean.valueOf(""));
                rmand.setValue(Boolean.valueOf(""));
                mdA.setValue(Boolean.valueOf(""));
                mdB.setValue(Boolean.valueOf(""));
                mdC.setValue(Boolean.valueOf(""));
                visPass.setValue(Boolean.valueOf(""));
                skjulPass.setValue(Boolean.valueOf(""));

            }
        });
    }


    class Handler2 implements ClickHandler {

        ///MANGLER at fixe radiobuttons her ved window alerts /////////////////////////////////////


        //Fieldverifier der checker om vores inputs er som ønskede og hvis de er viser window alert vores indtastede input.
        @Override
        public void onClick(ClickEvent event) {
            if (FieldVerifier.isValidName(fornavnBox.getText()) && FieldVerifier.isValidName(efternavnBox.getText()) && FieldVerifier.isValidAge(alderTxt.getText()) && FieldVerifier.isValidBrugernavn(brugernavnBox.getText())
            && FieldVerifier.isValidPass(passwordBox.getText())) {

                //Udskriver de indtastede data bortset fra brugernavn og password
                Window.alert("Følgende bruger er oprettet: " + "\n" + "Fornavn: " +  fornavnBox.getText() + "\n" + "efternavn: " +  efternavnBox.getText() + "\n" + "alder: " + alderTxt.getText() + "\n"
                        + "Køn: " + rkvinde.getName() + rmand.getName() + "\n" + "Medlemstype: " + mdA.getText() + mdB.getText() + mdC.getText());
            }
            // Brugeren får besked hvis han/hun ikke har udfyldt felterne korrekt.
            if (!FieldVerifier.isValidName(fornavnBox.getText()))
                Window.alert("Venligst indtast et fornavn på min. 2 bogstaver! " + "\n");
            if (!FieldVerifier.isValidAge(alderTxt.getText()))
                Window.alert("For at blive medlem skal du mindst være 15 år, og højst 99");
            if (!FieldVerifier.isValidBrugernavn(brugernavnBox.getText()))
                Window.alert("Indast et brugernavn på minimum 3 karakter! (tal og/eller bogstaver)");
            if (!FieldVerifier.isValidPass(passwordBox.getText()))
                Window.alert("Dit password skal være på minimum 4 karakterer! (tal og/eller bogstaver)");

        }







    }}

