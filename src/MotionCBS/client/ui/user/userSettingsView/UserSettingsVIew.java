package MotionCBS.client.ui.user.userSettingsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class UserSettingsVIew extends Composite {
    interface userSettingsVIewUiBinder extends UiBinder<HTMLPanel, UserSettingsVIew> {
    }

    private static userSettingsVIewUiBinder ourUiBinder = GWT.create(userSettingsVIewUiBinder.class);

    public UserSettingsVIew() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}