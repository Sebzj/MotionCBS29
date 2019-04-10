package MotionCBS.client.ui.admin.AdminMainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckLayoutPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminMainView extends Composite {
    interface AdminMainViewUiBinder extends UiBinder<HTMLPanel, AdminMainView> {
    }

    @UiField
    Button logoutBtn;
    @UiField
    DeckLayoutPanel centerPanel;

    private static AdminMainViewUiBinder ourUiBinder = GWT.create(AdminMainViewUiBinder.class);

    public AdminMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}