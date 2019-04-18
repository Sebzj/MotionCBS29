package motioncbs.client.ui.admin.AdminAllUserInfoView;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.view.client.ListDataProvider;
import motioncbs.shared.User;
import motioncbs.client.ui.user.userInfoView.UserInfoView;

import java.util.Comparator;

public class AdminAllUserInfoView extends Composite {

    interface AdminAllUserInfoViewUiBinder extends UiBinder<HTMLPanel, AdminAllUserInfoView> {
    }




    private static AdminAllUserInfoViewUiBinder ourUiBinder = GWT.create(AdminAllUserInfoViewUiBinder.class);

    public AdminAllUserInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));

      

    }





    }



