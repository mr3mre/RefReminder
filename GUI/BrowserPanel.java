package GUI;

import APIs.src.java.net.http.EmbeddedBrowser;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class BrowserPanel {

    public static JPanel makePanel() {
        Browser browser = EmbeddedBrowser.openURL( "https://www.migros.com.tr/" );
        JPanel panel = new JPanel();

        SwingUtilities.invokeLater( () -> {
            // Creating Swing component for rendering web content
            // loaded in the given Browser instance.
            BrowserView view = BrowserView.newInstance( browser );

            // Creating and displaying Swing app panel.
            // Close Engine and onClose app window
            JTextField addressBar = new JTextField( "https://www.migros.com.tr/" );
            addressBar.addActionListener(e ->
                    browser.navigation().loadUrl(addressBar.getText()));
            panel.add(addressBar, BorderLayout.NORTH);
            panel.add(view, BorderLayout.CENTER);
            panel.setSize(800, 500);
            panel.setVisible(true);

            browser.navigation().loadUrl(addressBar.getText());

        });
        return panel;
    }
}
