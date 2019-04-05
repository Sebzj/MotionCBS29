package MotionCBS.client.ui.user.userChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class userChangeInfoView extends Composite {
    interface userChangeInfoViewUiBinder extends UiBinder<HTMLPanel, userChangeInfoView> {
    }

    private static userChangeInfoViewUiBinder ourUiBinder = GWT.create(userChangeInfoViewUiBinder.class);

    public userChangeInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}