package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField str_name;
	private JTextField str_pass;
	static String name;
	static String pass;
	
	public static void main (String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
						
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lb1 = new JLabel("UserName");
		lb1.setBounds(44, 55, 70, 16);
		contentPane.add(lb1);
		
		JLabel lb2 = new JLabel("Password");
		lb2.setBounds(44, 90, 65, 16);
		contentPane.add(lb2);
		
		str_name = new JTextField();
		str_name.setBounds(124, 52, 116, 22);
		contentPane.add(str_name);
		str_name.setColumns(10);
		
		str_pass = new JTextField();
		str_pass.setBounds(124, 87, 116, 22);
		contentPane.add(str_pass);
		str_pass.setColumns(10);
		
		JButton button = new JButton("GUI.Login");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				name = str_name.getText();
				pass = str_pass.getText();
				
				String text = "select count(idUser) from new_table where usr_name=' " + name + " ' and usr_pass= '" + pass + "'";
				ResultSet res1 = Connection.doIt();
				res1 = Connection.check(text);
				
				//DO 
				//where (res1.next()){
				//	if(res1.getInt("login") == 1) {
						//DO check database if the user in or not
				//	}
				//}
				
				
			}
		});
		button.setBounds(134, 122, 97, 25);
		contentPane.add(button);
		
	}
	
	
}

class Connection {
	
	static Connection con;
	static Statement state;
	
	static ResultSet doIt() {
		ResultSet result = null;
		try {
			java.sql.Connection con = DriverManager.getConnection(  
		            "jdbc:mysql://localhost:3306/users" , "root", "root");  
			
			state = ((java.sql.Connection) con).createStatement();  
            
            result = state.executeQuery("select * from new_table"); 
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	static void add(String text ) {
		try {
			state.executeUpdate(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void update(String text ) {
		try {
			state.executeUpdate(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void delete(String text ) {
		try {
			state.executeUpdate(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static ResultSet check(String text ) {
		ResultSet res = null;
		try {
			res = state.executeQuery(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//DO 
	
}
