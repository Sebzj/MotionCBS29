package motioncbs.client.rpc;

import motioncbs.shared.User;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;

public interface MotionCBSServiceAsync {


    void test(AsyncCallback<Void> asyncCallback) throws IllegalArgumentException;

    void authorizeUser(String username, String password, AsyncCallback<User> async);

    void changeUserInfo(User user, AsyncCallback<Boolean> async);

    void getUsers(int userId, AsyncCallback<ArrayList<User>> async);

    void createUser(User user, AsyncCallback<Boolean> async);

    void deleteUser(int userId, AsyncCallback<Boolean> async);

}
