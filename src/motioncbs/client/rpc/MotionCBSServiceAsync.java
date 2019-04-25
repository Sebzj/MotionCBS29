package motioncbs.client.rpc;

import motioncbs.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

public interface MotionCBSServiceAsync {



    void authorizeUser(String username, String password, AsyncCallback<User> async);

    void getCurrentUser(int userId, AsyncCallback<User> async);

    void getUsers(int userId, AsyncCallback<ArrayList<User>> async);

    void createUser(User user, AsyncCallback<Boolean> async);

    void deleteUser(int userId, AsyncCallback<Boolean> async);



    void changeUserInfo(User user, AsyncCallback<Void> async);
}
