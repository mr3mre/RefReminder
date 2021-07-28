package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Menu Bar GUI
 * @author H.Emre Tas
 * @date 28.07.2021
 */
public class MenuBar extends JPanel{
	
	public static int WIDTH = 700;
	public final static int NUMBER_OF_PAGES = 7;
	
	private ArrayList<JLabel> labels;
	private Component com;
	private JPanel menuBar;
	
	public final static int REC_HEIGHT = 30;
	public static int REC_WIDTH = WIDTH / NUMBER_OF_PAGES;
	public final static Font FONT = new Font( "Comic Sans MS" , Font.PLAIN, 15);
	public final static String[] menuList = { "Home", "Stock Control", "Reciper", "Restaurants", "Bilkent Menu", "Shopping", "User Page" };
	
	/**
     * Constructor 
     */
	public MenuBar() {
		
		labels = new ArrayList<JLabel>();
		menuBar = new JPanel();
		
		menuBar.setLayout( new BoxLayout( menuBar, BoxLayout.X_AXIS ) );	
		
		for( int i = 0; i < NUMBER_OF_PAGES; i++) {

			JLabel label = new JLabel( menuList[i] );	
			Color col = new Color( 100,150,250 );
//			label.setForeground( col );
			label.setFont( FONT );
		
			label.addMouseListener( new menuBarListener( i ) );
			
			labels.add( label );
			menuBar.setLayout( new BoxLayout( menuBar, BoxLayout.X_AXIS ) ); 
		 
			menuBar.add( label );
			label.setVisible(true);
			com = Box.createRigidArea( new Dimension( WIDTH / 25, 20 ));
			
			menuBar.add( com );
			
		}
		addComponentListener( new windowListener() );
		add( menuBar );
	}
	
	/**
     * overrides paintComponent( Graphics )
     */
	public void paintComponent( Graphics page ) {
		super.paintComponent( page );
		
		page.fillRect( 0, (int)( REC_HEIGHT * 1.2 ) , WIDTH, (int) REC_HEIGHT / 4);
		
	}
	
	/**
     * Menu Bar Windows Listener
     * Inner class
     */
	public class windowListener extends ComponentAdapter{
	
		public void componentResized( ComponentEvent comEvent ) {
	      	
	    	Dimension d = ( ( JComponent ) comEvent.getSource() ).getSize();
	    	WIDTH = d.width;
	    	repaint();		
	    }	
	}

	/**
     * Menu Bar Mouse Listener
     * Inner class
     */
	public class menuBarListener extends MouseAdapter{
		private int index = 0;

		//Constructor
		public menuBarListener( int index ) {
			this.index = index;
		}
		
		public void mouseClicked( MouseEvent event ) {
			System.out.println( "Index: " + index );
			//Code here...
		}
		
		public void mouseEntered( MouseEvent event ) {
			Font font = labels.get(index).getFont();
			labels.get(index).setFont( font.deriveFont( Font.BOLD ) );
	  	  	
		}
		
		public void mouseExited( MouseEvent e ) {  
			labels.get(index).setFont( FONT );
		}
	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Menu Bar");	
		MenuBar test = new MenuBar( );
		frame.add( test );
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    		System.out.println( " Height" + screenSize.width );
    	
    		frame.setMinimumSize( new Dimension( 700 , 600 ) );
    	
    		frame.setLocationRelativeTo(null);
    		frame.setVisible(true);
    		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
}
