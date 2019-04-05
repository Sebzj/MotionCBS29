package MotionCBS.client;

import MotionCBS.client.logic.MainController;
import MotionCBS.client.rpc.MotionCBSService;
import MotionCBS.client.rpc.MotionCBSServiceAsync;
import MotionCBS.client.ui.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MotionCBS implements EntryPoint {

    MotionCBSServiceAsync rpcService = GWT.create(MotionCBSService.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        //intantiere et objekt af ContentPanel som er det der skal vises paa skaermen
        ContentPanel content = new ContentPanel();

        //tilfoejer alt indhold til RootLayoutPanel
        RootLayoutPanel.get().add(content);

        //Instantiate the RPC service laver the magic call
        //MotionCBSServiceAsync rpcService = GWT.create(MotionCBSService.class);

        //Passes the "screen" and the RPC service to the MainController
        new MainController(content, rpcService);


    }
}






        /*
        /** final Button button = new Button("Click me");
        final Label label = new Label();

        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    MotionCBSService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
} */