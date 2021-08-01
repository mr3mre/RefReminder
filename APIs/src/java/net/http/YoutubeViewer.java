package APIs.src.java.net.http;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import java.awt.*;

public class YoutubeViewer {

    public static void main(String[] args) {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("YouTube Viewer");
                JPanel panel = new JPanel();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                panel = getBrowserPanel( "https://www.youtube.com/embed/Cr0EWwaTk?fs=1%22" );
                frame.setSize(800, 600);
                frame.setLocationByPlatform(true);
                frame.add( panel );
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
        webBrowserPanel.setSize( new Dimension( 630, 300 ) );
        webBrowser.setBarsVisible(false);
        webBrowser.navigate( url );
        return webBrowserPanel;
    }
}