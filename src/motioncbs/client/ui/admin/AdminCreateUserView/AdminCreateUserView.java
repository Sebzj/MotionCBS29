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
    RadioButton rkvinde, rmand, mdA, mdB, mdC;
    @UiField
    TextBox fornavnBox, efternavnBox, brugernavnBox, alderTxt;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button knap;

    private static AdminCreateUserViewUiBinder ourUiBinder = GWT.create(AdminCreateUserViewUiBinder.class);

    public AdminCreateUserView() {
        initWidget(ourUiBinder.createAndBindUi(this));


        //Tilføjer vores knap til clickhandler
        knap.addClickHandler(new Handler2());

    }



    private class Handler2 implements ClickHandler {


        ///MANGLER at fixe radiobuttons her ved window alerts /////////////////////////////////////


        //Fieldverifier der checker om vores inputs er som ønskede og hvis de er viser window alert vores indtastede input.
        @Override
        public void onClick(ClickEvent event) {
            if (FieldVerifier.isValidName(fornavnBox.getText()) && FieldVerifier.isValidName(efternavnBox.getText()) && FieldVerifier.isValidAge(alderTxt.getText())) {
                Window.alert("Følgende bruger er oprettet:" + "\n" + "Fornavn: " +  fornavnBox.getText() + "\n" + "efternavn: " +  efternavnBox.getText() + "\n" + "alder:" + alderTxt.getText() + "\n"
                        + "Køn: " + rkvinde.getText() + rmand.getText() + "\n" + "Medlemstype:" + mdA.getText() + mdB.getText() + mdC.getText());
            }

        }}






}

