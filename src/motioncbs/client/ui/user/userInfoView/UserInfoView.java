package MotionCBS.client.ui.user.userInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class UserInfoView extends Composite {
    interface userInfoViewUiBinder extends UiBinder<HTMLPanel, UserInfoView> {
    }

    private static userInfoViewUiBinder ourUiBinder = GWT.create(userInfoViewUiBinder.class);

    public UserInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    private void initWidget(Object andBindUi) {
    }
}