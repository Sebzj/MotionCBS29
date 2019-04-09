package MotionCBS.client.ui.admin.AdminCreateUserView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

public class AdminCreateUserView {
    interface AdminCreateUserViewUiBinder extends UiBinder<DivElement, AdminCreateUserView> {
    }
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
    }
}

