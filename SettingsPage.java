import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SettingsPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingsPage window = new SettingsPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SettingsPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 840, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		
		NorthernPanel panel = new NorthernPanel();
		panel.setBackground(Color.white);
		frame.getContentPane().add(panel, BorderLayout.NORTH);				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.white);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Delete My Account");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 150, 15));
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setBackground(Color.WHITE);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Send Us Feedback");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.white);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1));
		
		JLabel lblNewLabel = new JLabel("Personalization");
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 0, 0));
		
		textField_1 = new JTextField();
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("Update my e-mail address");

		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText("Update my password");
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		textField.setText("Update address");

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.white);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Preferences");
		lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		panel_3.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText("Change Units");

	}

}
