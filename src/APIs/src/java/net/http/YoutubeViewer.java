/*
 * YoutubeViewer class
 * @author Eren, Emre
 * @version 1.0
 * 31/07/2021
 */


package APIs.src.java.net.http;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import java.awt.*;

/**
 * Returns a JPanel that contains the YouTube video from the given URL
 * @author Eren, Emre
 * @date 31.07.2021
 */
public class YoutubeViewer extends JPanel {

    /**
     * Constructs the YoutubeViewer panel
     *
     * @param url URL of the YouTube video
     */
    public  YoutubeViewer( String url ) {
        super( new BorderLayout() );

        JPanel webBrowserPanel = new JPanel( new BorderLayout() );
        webBrowserPanel.setBorder( BorderFactory.createTitledBorder( "" ) );

        final JWebBrowser webBrowser = new JWebBrowser();
        webBrowser.navigate(url );
        webBrowserPanel.add( webBrowser, BorderLayout.CENTER );
        add( webBrowserPanel, BorderLayout.CENTER );
    }

    /**
     * Main method to test YoutubeViewer
     *
     * @param args Command line arguments
     */
    public static void main( String[] args ) {
        NativeInterface.open();
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                JFrame frame = new JFrame( "YouTube Viewer" );
                JPanel panel = new JPanel();
                panel = getBrowserPanel(  "https://www.youtube.com/embed/Cr0EWwaTk?fs=1%22" );

                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize( panel.getSize() );
                frame.add( panel, BorderLayout.CENTER );
                frame.setVisible( true );
            }
        });
        NativeInterface.runEventPump();

        // Don't forget to properly close native components
        Runtime.getRuntime().addShutdownHook( new Thread( new Runnable() {
            @Override
            public void run() {
                NativeInterface.close();
            }
        }));
    }

    /**
     * Initializes a JPanel that contains the YouTube video
     *
     * @param url URL of the YouTube video
     * @return JPanel that contains the browser
     */
    public static JPanel getBrowserPanel( String url ) {
        JPanel webBrowserPanel = new JPanel(new BorderLayout());
        JWebBrowser webBrowser = new JWebBrowser();

        // Set the panel for browser
        webBrowserPanel.add( webBrowser, BorderLayout.CENTER) ;
        webBrowserPanel.setSize( new Dimension( 600, 400 ) );
        webBrowser.setBarsVisible( false );

        // Open URL in browser
        webBrowser.navigate( url );
        return webBrowserPanel;
    }
}
