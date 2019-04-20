package motioncbs.client.ui.user.userInfoView;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
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
import motioncbs.client.ui.user.userSettingsView.UserSettingsView;
import motioncbs.shared.User;

import java.util.Comparator;

public class UserInfoView extends Composite {
    interface userInfoViewUiBinder extends UiBinder<HTMLPanel, UserInfoView> {
    }

    private static userInfoViewUiBinder ourUiBinder = GWT.create(userInfoViewUiBinder.class);

    @UiField
    DataGrid<User> dataGrid;

    @UiField
    SimplePager pager;

    @UiField
    Button changeInfoBtn;

    private UserSettingsView userSettingsView;


    public UserInfoView() {
        initWidget(ourUiBinder.createAndBindUi(this));

        // Setting the page size of the table
        dataGrid.setPageSize(25);


        // Adding the pager to the datagrid
        pager.setDisplay(dataGrid);
        // Ensures the headers doesn't get refreshed every time the data is
        // updated
        dataGrid.setAutoHeaderRefreshDisabled(true);

        userSettingsView = new UserSettingsView();

    }


    public void initUsersTable(ListDataProvider<User> dataProvider) {
        // Attach a column sort handler to the ListDataProvider to sort the list
        ColumnSortEvent.ListHandler<User> sortHandler = new ColumnSortEvent.ListHandler<User>(dataProvider.getList());
        dataGrid.addColumnSortHandler(sortHandler);

        // Creating all the necessary columns to the table


        /*
         * Adding the data grid to the DataProvider The DataPrivider is
         * containing a List with all the data
         */
        dataProvider.addDataDisplay(dataGrid);
        initTableColumns(sortHandler);
    }


    // metoden initTableColumns laver alle kolonnerne
    public void initTableColumns(ColumnSortEvent.ListHandler<User> sortHandler) {



        // user id kolonnen bliver lavet
        Column<User, Number> idColumn = new Column<User, Number>(new NumberCell()) {
            @Override
            public Number getValue(User user) {
                return user.getId();
            }
        };

        //goer saa id kolonnen kan sorteres
        idColumn.setSortable(true);
        sortHandler.setComparator(idColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getId() - u2.getId();
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Id
        dataGrid.addColumn(idColumn, "Id");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(idColumn, 7, Style.Unit.PX);



        //opretter fornavn kolonnen
        Column<User, String> firstNameColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getFirstName();
            }
        };

        //goer saa username kolonnen kan sorteres
        firstNameColumn.setSortable(true);
        sortHandler.setComparator(firstNameColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getFirstName().compareTo(u2.getFirstName());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Firstname
        dataGrid.addColumn(firstNameColumn, "Firstname");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(firstNameColumn, 7, Style.Unit.PX);


        //opretter efternavns kolonnen
        Column<User, String> lastNameColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getLastName();
            }
        };

        //goer saa username kolonnen kan sorteres
        lastNameColumn.setSortable(true);
        sortHandler.setComparator(lastNameColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getLastName().compareTo(u2.getLastName());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Lastname
        dataGrid.addColumn(lastNameColumn, "Lastname");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(lastNameColumn, 7, Style.Unit.PX);



        //opretter alder kolonnen
        Column<User, Number> ageColumn = new Column<User, Number>(new NumberCell()) {
            @Override
            public Integer getValue(User user) {
                return user.getAge();
            }
        };

        //goer saa alder kolonnen kan sorteres
        ageColumn.setSortable(true);
        sortHandler.setComparator(ageColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getAge() - (u2.getAge());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Age
        dataGrid.addColumn(ageColumn, "Age");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(ageColumn, 7, Style.Unit.PX);




        //opretter username kolonnen
        Column<User, String> usernameColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getUsername();
            }
        };

        //goer saa username kolonnen kan sorteres
        usernameColumn.setSortable(true);
        sortHandler.setComparator(usernameColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getUsername().compareTo(u2.getUsername());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen username
        dataGrid.addColumn(usernameColumn, "Username");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(usernameColumn, 7, Style.Unit.PX);



        //opretter password kolonnen
        Column<User, String> passwordColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getPassword();
            }
        };

        //goer saa password kolonnen kan sorteres
        passwordColumn.setSortable(true);
        sortHandler.setComparator(passwordColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getPassword().compareTo(u2.getPassword());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Password
        dataGrid.addColumn(passwordColumn, "Password");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(passwordColumn, 7, Style.Unit.PX);



        //opretter gender kolonnen
        Column<User, String> genderColumn = new Column<User, String>(new TextCell()) {
            @Override
            public String getValue(User user) {
                return user.getGender();
            }
        };

        //goer saa username kolonnen kan sorteres
        genderColumn.setSortable(true);
        sortHandler.setComparator(genderColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getGender().compareTo(u2.getGender());
            }
        });
        //tilfoejer kolonnen til datagrid (tabellen) med titlen Gender
        dataGrid.addColumn(genderColumn, "Gender");
        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(genderColumn, 7, Style.Unit.PX);



        //opretter customertype kolonnen
        Column<User, Number> customertypeColumn = new Column<User, Number>(new NumberCell()) {
            @Override
            public Integer getValue(User user) {
                return user.getCustomertype();
            }
        };

        //goer saa customertype kolonnen kan sorteres
        customertypeColumn.setSortable(true);
        sortHandler.setComparator(customertypeColumn, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getCustomertype() - (u2.getCustomertype());
            }
        });


        //tilfoejer kolonnen til datagrid (tabellen) med titlen Customertype
        dataGrid.addColumn(customertypeColumn, "Customertype");

        //saetter stoerelsen paa kolonnen
        dataGrid.setColumnWidth(customertypeColumn, 7, Style.Unit.PX);

    }


}

