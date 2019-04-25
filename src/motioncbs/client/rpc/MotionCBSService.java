package motioncbs.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import motioncbs.shared.User;

import java.util.ArrayList;

@RemoteServiceRelativePath("motionCBSService")
public interface MotionCBSService extends RemoteService {


    User authorizeUser(String username, String password) throws IllegalArgumentException;


    void changeUserInfo(User user) throws IllegalArgumentException;

    User getCurrentUser(int userId) throws IllegalArgumentException;

    ArrayList<User> getUsers(int userId) throws IllegalArgumentException;

    boolean createUser(User user) throws IllegalArgumentException;

    boolean deleteUser(int userId) throws IllegalArgumentException;


}

