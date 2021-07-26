import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NorthernPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	//constructors
	public NorthernPanel() {
		createComponents();
	}
	
	//methods	
	public void createComponents() {
		JButton menuButton = new JButton("Main Menu");
		menuButton.setBackground(Color.PINK);
		setLayout(new GridLayout(0, 7, 0, 0));
		add(menuButton);
		
		JButton stockButton = new JButton("Stock Control");
		stockButton.setBackground(Color.MAGENTA);
		add(stockButton);
		
		JButton reciperButton = new JButton("Reciper");
		reciperButton.setBackground(Color.GREEN);
		add(reciperButton);
		
		JButton restaurantButton = new JButton("Restaurants");
		restaurantButton.setBackground(Color.RED);
		add(restaurantButton);
		
		JButton bilkentButton = new JButton("Bilkent Menu");
		bilkentButton.setBackground(Color.CYAN);
		add(bilkentButton);
		
		JButton shoppingButton = new JButton("Shopping");
		shoppingButton.setBackground(Color.ORANGE);
		add(shoppingButton);
		
		JButton settingsButton = new JButton("Settings");
		settingsButton.setBackground(Color.BLUE);
		add(settingsButton);
	}
}
