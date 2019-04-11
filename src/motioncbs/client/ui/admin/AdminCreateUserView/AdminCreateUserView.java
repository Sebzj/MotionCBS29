package motioncbs.client.ui.admin.AdminCreateUserView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class AdminCreateUserView extends Composite {
    interface AdminCreateUserViewUiBinder extends UiBinder<HTMLPanel, AdminCreateUserView> {
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
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}