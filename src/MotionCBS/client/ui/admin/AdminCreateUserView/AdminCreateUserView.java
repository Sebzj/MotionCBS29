package MotionCBS.client.ui.admin.AdminCreateUserView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;


public class AdminCreateUserView {
    interface AdminCreateUserViewUiBinder extends UiBinder<DivElement, AdminCreateUserView> {
    }


    //Diverse UiFields
    @UiField
    RadioButton rkvinde, rmand, mdA, mdB, mdC;
    @UiField
    TextBox fornavnBox, efternavnBox, brugernavnBox;
    @UiField
    PasswordTextBox passwordBox;
    @UiField
    Button knap;

    private static AdminCreateUserViewUiBinder ourUiBinder = GWT.create(AdminCreateUserViewUiBinder.class);


    public AdminCreateUserView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);

        //Laver ny knap og tilføjer den til Clickhandler
        knap.addClickHandler(new knappen());

    }
    public class knappen implements ClickHandler {
        @Override
        public void onClick(ClickEvent event) {
            Window.alert("Tak! Brugeren er nu oprettet");
        }
    }

    //metode der tømmer tekstboksene username og password så andre ikke kan se det når brugeren logger ud.

    public void clearTextBox(){
        brugernavnBox.setText("");
        efternavnBox.setText("");
        passwordBox.setText("");
        fornavnBox.setText("");
    }


}

