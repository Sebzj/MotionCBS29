package motioncbs.client.ui.user.userSettingsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class UserSettingsView extends Composite {
    interface userSettingsVIewUiBinder extends UiBinder<HTMLPanel, UserSettingsView> {
    }

    private static userSettingsVIewUiBinder ourUiBinder = GWT.create(userSettingsVIewUiBinder.class);

    public UserSettingsView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}