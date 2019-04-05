package MotionCBS.client.ui.user.userSettingsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class userSettingsVIew extends Composite {
    interface userSettingsVIewUiBinder extends UiBinder<HTMLPanel, userSettingsVIew> {
    }

    private static userSettingsVIewUiBinder ourUiBinder = GWT.create(userSettingsVIewUiBinder.class);

    public userSettingsVIew() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}