import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MenuBar extends JPanel{
	private ArrayList<JLabel> labels;
	private ArrayList<Rectangle> recs;
	
	public final static Rectangle REC = new Rectangle( 0, 0, 700, 20 );
	
	public static int WIDTH = 700;
	public final static int NUMBER_OF_PAGES = 7;
	private Component com;
	private JPanel menuBar;
	public final static int  REC_HEIGHT = 30;
	public static int REC_WIDTH = WIDTH/NUMBER_OF_PAGES;
	public final static Font FONT = new Font( "Comic Sans MS" , Font.PLAIN, 15);
	public final static String[] menuList = { "Home", "Stock Control", "Reciper", "Restaurants", "Bilkent Menu", "Shopping", "User Page" };
	
	public MenuBar( JFrame frame ) {
		recs = new ArrayList<Rectangle>();
		labels = new ArrayList<JLabel>();
		menuBar = new JPanel();
		
		menuBar.setLayout( new BoxLayout( menuBar, BoxLayout.X_AXIS ) );	
		
		for( int i = 0; i < NUMBER_OF_PAGES; i++) {

			Rectangle rec = new Rectangle( i * REC_WIDTH , 0, REC_WIDTH , REC_HEIGHT );
			recs.add( rec );
			
			JLabel label = new JLabel( menuList[i] );	
			Color col = new Color( 100,150,250 );
			label.setForeground( col );
			label.setFont( FONT );
		
			label.addMouseListener( new menuBarListener( i ) );
			label.setBounds( rec );
			
			labels.add( label );
//			menuBar.setLayout( new BoxLayout( menuBar, BoxLayout.X_AXIS ) ); 
//			menuBar.setLayout(new FlowLayout(FlowLayout.RIGHT));  
			 
//			menuBar.add( label );
			label.setVisible(true);
			com = Box.createRigidArea( new Dimension( WIDTH / 25 ,20 ));
			
			menuBar.add( com );
			frame.add(label);
			
		}
		
		addComponentListener( new windowListener( this ) );
		
//		add( menuBar );
		
	}
	
	public void updateLabels( MenuBar menu ) {
		menuBar.removeAll();
		for( JLabel label: labels) {
 
    		menuBar.add( label );
    		
    		if ( menu.contains( label.getX() , label.getBounds().y )) {
    			com = Box.createRigidArea( new Dimension( (int) ( WIDTH / 25 ) ,20 ));
				menuBar.add( com );
			
    		}
    			
    	}
		menu.add( menuBar );
	}
	
	public void paintComponent( Graphics page ) {
		super.paintComponent( page );
		
//		page.drawRect( 0, (int)( REC_HEIGHT * 1.2 ) , WIDTH, (int) REC_HEIGHT / 2);
		page.fillRect( 0, (int)( REC_HEIGHT * 1.2 ) , WIDTH, (int) REC_HEIGHT / 4);
		
	}
	
	
	public class windowListener extends ComponentAdapter{
		private MenuBar menu;
		
		public windowListener( MenuBar menu ) {
			this.menu = menu;
		}
	
		public void componentResized( ComponentEvent comEvent ) {
	      	
	    	Dimension d = ( ( JComponent ) comEvent.getSource() ).getSize();
	    	WIDTH = d.width;
 
	    	
//	    	System.out.println( comEvent.getSource().getClass() );
	    	System.out.println( "Window changed." );
	    	repaint();	
//	    	updateLabels( menu );	
	    }	
	}
	
	public class menuBarListener extends MouseAdapter{
		private int index = 0;

		//Constructor
		public menuBarListener(  int index ) {
			this.index = index;
		}

		public void mouseClicked( MouseEvent event ) {
		
			System.out.println( "Index: " + index );

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
		MenuBar test = new MenuBar( frame );

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
    	frame.add( test );
    	
    	System.out.println( " Height" + screenSize.width );
    	
    	frame.setMinimumSize( new Dimension( 700 , 600 ) );
    	frame.setSize( new Dimension( 700 , 600 ) );
    	
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

	}
}
