package motioncbs.client.ui.admin.AdminAllUserInfoView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class AdminAllUserInfoView extends Composite {

    interface AdminAllUserInfoViewUiBinder extends UiBinder<HTMLPanel, AdminAllUserInfoView> {
    }

    @UiField
    Button redigerBtn;
    private static AdminAllUserInfoViewUiBinder ourUiBinder = GWT.create(AdminAllUserInfoViewUiBinder.class);

    public AdminAllUserInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));


    }



    }



