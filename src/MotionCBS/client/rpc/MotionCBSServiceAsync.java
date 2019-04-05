package MotionCBS.client.rpc;

import MotionCBS.client.MotionCBS;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface MotionCBSServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
