package MotionCBS.client.rpc;

import MotionCBS.client.MotionCBS;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.motionCBS.client.MotionCBS;

public interface MotionCBSServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
