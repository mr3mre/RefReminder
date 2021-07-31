package GUI;

import APIs.src.java.net.http.EmbeddedBrowser;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class BrowserPanel {

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
            panel.setSize( 800, 500 );
            panel.setVisible( true );

            browser.navigation().loadUrl( addressBar.getText() );

        });
        Object[] GUIs = new Object[2];
        GUIs[0] = panel;
        GUIs[1] = EmbeddedBrowser.openURL( url )[1];

        return GUIs;
    }
}
