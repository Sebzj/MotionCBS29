package MotionCBS.client.ui.user.userMainView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class userMainView extends Composite {
    interface userMainViewUiBinder extends UiBinder<HTMLPanel, userMainView> {
    }

    private static userMainViewUiBinder ourUiBinder = GWT.create(userMainViewUiBinder.class);

    public userMainView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}