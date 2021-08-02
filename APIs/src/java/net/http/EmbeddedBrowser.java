/*
 * EmbeddedBrowser class
 * @author Eren
 * @version 1.0
 * 02/08/2021
 */


package APIs.src.java.net.http;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;

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
                        .licenseKey( "1BNDHFSC1FZUESGWGCUAM19XMT9T6UG3HOHD0SB57WJNEBCJICZFYGZH2Y9F2H4ZWYIDCO" )
                        .build();
        Engine engine = Engine.newInstance( options );
        Browser browser = engine.newBrowser();

        Object[] browserHelpers = new Object[2];
        browserHelpers[0] = browser;
        browserHelpers[1] = engine;

        return browserHelpers;
    }
}
