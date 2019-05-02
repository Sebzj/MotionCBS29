package motioncbs.client;

import motioncbs.client.logic.MainController;
import motioncbs.client.rpc.MotionCBSService;
import motioncbs.client.rpc.MotionCBSServiceAsync;
import motioncbs.client.ui.ContentPanel;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MotionCBS implements EntryPoint {



    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {


        //intantiere et objekt af ContentPanel som er det der skal vises på skaermen
        ContentPanel content = new ContentPanel();

        //tilføjer alt indhold til RootLayoutPanel
        RootLayoutPanel.get().add(content);

        //Instantiate the RPC service laver the magic call
        MotionCBSServiceAsync motionCBSService = GWT.create(MotionCBSService.class);

        //Passes the "screen" and the RPC service to the MainController
        new MainController(content, motionCBSService);


    }
}



