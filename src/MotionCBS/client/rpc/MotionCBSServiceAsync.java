package MotionCBS.client.rpc;

import MotionCBS.client.MotionCBS;
import com.google.gwt.user.client.rpc.AsyncCallback;
import MotionCBS.client.MotionCBS;

public interface MotionCBSServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
