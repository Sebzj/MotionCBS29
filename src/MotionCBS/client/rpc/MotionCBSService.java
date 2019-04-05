package MotionCBS.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import MotionCBS.client.MotionCBS;

@RemoteServiceRelativePath("MotionCBSService")
public interface MotionCBSService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use MotionCBSService.App.getInstance() to access static instance of MotionCBSServiceAsync
     */
    public static class App {
        private static MotionCBSServiceAsync ourInstance = GWT.create(MotionCBSService.class);

        public static synchronized MotionCBSServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
