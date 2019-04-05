package MotionCBS.client.ui.user.userInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class userInfoView extends Composite {
    interface userInfoViewUiBinder extends UiBinder<HTMLPanel, userInfoView> {
    }

    private static userInfoViewUiBinder ourUiBinder = GWT.create(userInfoViewUiBinder.class);

    public userInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}