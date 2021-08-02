/*
 * BrowserPanel class
 * @author Eren, Emre
 * @version 1.0
 * 31/07/2021
 */


package GUI;

import APIs.src.java.net.http.EmbeddedBrowser;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

/**
 * Returns an Array that contains the JPanel that contains the browser and the browser
 * @author Eren
 * @date 31.07.2021
 */
public class BrowserPanel {

    /**
     * Returns the embedded browser as a JPanel with the given URL
     *
     * @param url URL to navigate to
     * @return
     */
    public static Object[] makePanel( String url ) {
        Browser browser = (Browser) EmbeddedBrowser.openURL( url )[0];
        JPanel panel = new JPanel();

        SwingUtilities.invokeLater( () -> {
            /*
             * Creating Swing component for rendering web content
             * loaded in the given Browser instance.
             */
            BrowserView view = BrowserView.newInstance( browser );

            // Creating and displaying Swing app panel
            JTextField addressBar = new JTextField( url );
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl( addressBar.getText() ) );
            panel.add( view, BorderLayout.CENTER );
            panel.setSize( 600, 300 );
            panel.setVisible( true );

            browser.navigation().loadUrl( addressBar.getText() );

        });
        Object[] GUIs = new Object[2];
        GUIs[0] = panel;
        GUIs[1] = EmbeddedBrowser.openURL( url )[1];

        return GUIs;
    }
}
