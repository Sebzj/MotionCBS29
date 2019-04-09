package MotionCBS.client.logic;

import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;
import MotionCBS.client.ui.user.userMainView.UserMainView;
import MotionCBS.shared.User;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class UserController {

private ContentPanel contentPanel;
private UserMainView userMainView;
private MotionCBSServiceAsync motionCBSServiceAsync;
//private User currentUser;

    //opretter constructor

    public UserController (ContentPanel contentPanel, MotionCBSServiceAsync motionCBSServiceAsync) {
    this.contentPanel = contentPanel;
    this.motionCBSServiceAsync = motionCBSServiceAsync;
    this.userMainView = contentPanel.getUserMainView();

    bindHandlers();


    }

    private void bindHandlers(){
        userMainView.addClickHandlers(new MenuClickHandler());

    }
//metode der fortaeller hvad der sker naar der bliver trykket paa de forskellige buttons.
    class MenuClickHandler implements ClickHandler{


        @Override
        public void onClick(ClickEvent event) {
            if(event.getSource()== userMainView.getInfoBtn()){
                userMainView.changeView(userMainView.getUserInfoView());

            } else if(event.getSource()== userMainView.getSettingsBtn()){
                userMainView.changeView(userMainView.getUserSettingsView());

            }  else if(event.getSource()== userMainView.getUsersBtn()) {
                userMainView.changeView(userMainView.getUserMainView());
            }
            else if(event.getSource()== userMainView.getLogoutBtn()){
                contentPanel.changeView(contentPanel.getLoginView());
                //currentUser=null;

            }
        }
    }

    //public void loadUser(User currentUser) {
      //  this.currentUser = currentUser;
        //loadTables();
 //   }
}
