package APIs.src.java.net.http;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class YoutubeViewer extends JPanel {

    public  YoutubeViewer( String url ) {
        super(new BorderLayout());
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        webBrowserPanel.setBorder(BorderFactory.createTitledBorder(""));
        final JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.navigate(url );
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        add(webBrowserPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("YouTube Viewer");
                JPanel panel = new JPanel();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                panel = getBrowserPanel( "https://www.youtube.com/embed/Cr0EWwaTk?fs=1%22" );
                frame.setSize( panel.getSize() );
                frame.add( panel, BorderLayout.CENTER);
                frame.setVisible(true);
            }
        });
        NativeInterface.runEventPump();
        // don't forget to properly close native components
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }

    public static JPanel getBrowserPanel( String url ) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();
        webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
        webBrowserPanel.setSize( new Dimension( 600, 400 ) );
        webBrowser.setBarsVisible(false);
        webBrowser.navigate( url );
        return webBrowserPanel;
    }
}