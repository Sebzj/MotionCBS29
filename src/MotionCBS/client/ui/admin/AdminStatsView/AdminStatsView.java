package MotionCBS.client.ui.admin.AdminStatsView;

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

public class AdminStatsView {
    interface AdminStatsViewUiBinder extends UiBinder<DivElement, AdminStatsView> {
    }

    private static AdminStatsViewUiBinder ourUiBinder = GWT.create(AdminStatsViewUiBinder.class);

    public AdminStatsView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}