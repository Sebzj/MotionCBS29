package MotionCBS.client.ui.AdminView.AdminStatsView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;

public class AdminStatsView {
    interface AdminStatsViewUiBinder extends UiBinder<DivElement, AdminStatsView> {
    }

    private static AdminStatsViewUiBinder ourUiBinder = GWT.create(AdminStatsViewUiBinder.class);

    public AdminStatsView() {
        DivElement rootElement = ourUiBinder.createAndBindUi(this);
    }
}