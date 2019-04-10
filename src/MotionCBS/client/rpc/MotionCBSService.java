package MotionCBS.client.rpc;

import MotionCBS.shared.User;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("MotionCBSService")
public interface MotionCBSService extends RemoteService {


    boolean changeUserInfo(User user) throws IllegalArgumentException;

    void test() throws IllegalArgumentException;

    User authorizeUser(String username, String password) throws IllegalArgumentException;

    boolean sendMessage(Message message) throws IllegalArgumentException;

    ArrayList<Message> getMessages(int userId) throws IllegalArgumentException;

    void updateMessageStatus(int messageId, boolean messageRead) throws IllegalArgumentException;

    ArrayList<User> getUsers(int userId) throws IllegalArgumentException;

    boolean createUser(User user) throws IllegalArgumentException;

    boolean deleteUser(int userId) throws IllegalArgumentException;
}

