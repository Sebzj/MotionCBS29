package MotionCBS.client.ui.user.userChangeInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class UserChangeInfoView extends Composite {
    interface userChangeInfoViewUiBinder extends UiBinder<HTMLPanel, UserChangeInfoView> {
    }

    private static userChangeInfoViewUiBinder ourUiBinder = GWT.create(userChangeInfoViewUiBinder.class);

    public UserChangeInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}