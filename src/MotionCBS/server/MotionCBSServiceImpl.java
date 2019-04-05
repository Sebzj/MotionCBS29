package MotionCBS.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import MotionCBS.client.rpc.MotionCBSService;

public class MotionCBSServiceImpl extends RemoteServiceServlet implements MotionCBSService {

    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}