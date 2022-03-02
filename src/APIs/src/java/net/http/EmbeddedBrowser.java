/*
 * EmbeddedBrowser class
 * @author Eren
 * @version 1.0
 * 31/07/2021
 */


package APIs.src.java.net.http;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;

/**
 * Returns an embedded browser that navigates to given URL
 * @author Eren
 * @date 31.07.2021
 */
public class EmbeddedBrowser {

    /**
     * Opens the URL in a browser
     *
     * @param url URL for the web page
     * @return An Array containing browser and Chromium engine
     */
    public static Object[] openURL(String url) {
        // Creating and running Chromium engine
        EngineOptions options =
                EngineOptions.newBuilder( HARDWARE_ACCELERATED )
                        .licenseKey( "" )
                        .build();
        Engine engine = Engine.newInstance( options );
        Browser browser = engine.newBrowser();

        Object[] browserHelpers = new Object[2];
        browserHelpers[0] = browser;
        browserHelpers[1] = engine;

        return browserHelpers;
    }
}
