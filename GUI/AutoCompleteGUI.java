package GUI;
import APIs.src.java.net.http.SpoonacularAPI;
import Logic.Food;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * @author H.Emre
 */
public class AutoCompleteGUI extends javax.swing.JFrame{

    /**
     * Creates new form AutoPanel
     */
    public AutoCompleteGUI(SpoonacularAPI foodApi ) {
        this.foodApi = foodApi;
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        foodList = new String[8];
    	labels = new ArrayList<JLabel>();

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labels.add( jLabel1 );
        labels.add( jLabel2 );
        labels.add( jLabel3 );
        labels.add( jLabel4 );
        
        for ( JLabel label: labels ) {
        	label.setFont( FONT );
			
			label.addMouseListener( new labelsListener( labels.indexOf(label), this ) );
        }
        
        jTextField1 = new javax.swing.JTextField( "" );
        
        jTextField1.setText( "" );
        
//      jPanel1.setVisible( false );
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setCursor( new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR) );

        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {

            }
        });

        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        // this.setName( "ADD TO STORAGE" );
        this.setBackground( new Color( 100,150,250 ) );
        this.setMaximumSize( new Dimension( 200, 200 ));
        this.setMinimumSize( new Dimension( 200, 200 ));

        setSize( 200, 200);
        setLocationRelativeTo( null );


        //JTextField
        jTextField1.addKeyListener( new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel2.setBackground(Color.lightGray );
                updateLabels();
            	String text = "";

                text = ( (JTextField) evt.getSource() ).getText();

                if( ! text.equals( "" ) ) {
                    try {
                        foodList = foodApi.getFoodId( text );

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    updateLabels();
                }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>


    public class labelsListener extends MouseAdapter{
		private int index;
		private AutoCompleteGUI frame;
		//Constructor
		public labelsListener( int index, AutoCompleteGUI frame ) {
		    this.index = index;
		    this.frame = frame;
		}

		public void mouseClicked( MouseEvent event ) {

            foodName = ( (JLabel) event.getSource() ).getText();

			if ( ! foodName.equals("") ) {

                //System.out.println( foodName );
                int index = -1;
                for (int count = 0; count < foodList.length; count++) {
                    if (foodList[count] == foodName)
                        index = count + foodList.length / 2;
                }

                if (index != -1) {
                    try {
                        food = foodApi.getFoodInformation(Integer.parseInt(foodList[index]));
                        //System.out.println( "ID: " + food.getId() + " Name: " + food.toString() + " Main: " + food.getMain() + " Calorie: " + food.getCaloriePerPortion() );
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                JFrame frameAmount = new JFrame("ADD FOOD" );
                frameAmount.setVisible( true );
                frameAmount.setBackground( new Color( 100,150,250 ) );
                frameAmount.setMaximumSize( new Dimension( 300, 50 ));
                frameAmount.setMaximumSize( new Dimension( 300, 50 ));
                frameAmount.setSize( 300, 80);
                frameAmount.setLocationRelativeTo( null );
                frameAmount.setDefaultCloseOperation( EXIT_ON_CLOSE );

                javax.swing.JTextField textField = new JTextField( 5 );
                textField.setText( "Enter the amount of " + foodName + " in grams: " );
                frameAmount.add(textField);

                textField.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if ( textField.getText().equals( "Enter the amount of " + foodName + " in grams: " )) {
                            textField.setText("");
                        }
                    }
                });

                textField.addKeyListener( new java.awt.event.KeyAdapter( ) {
                    public void keyPressed(java.awt.event.KeyEvent evt) {
                        char c = evt.getKeyChar();


                        String str = findJustDigit( ( (JTextField) evt.getSource() ).getText() );

                        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
                            frameAmount.dispose();
                            if( ! str.equals( "" ))
                                 amount = Integer.parseInt( str );

                            //System.out.println( amount );

                            food.setAmount( amount );
                            System.out.println( "Food : " + food.getAmount() );

                            /**
                             *
                             * "Health Foods", "Produce","Dried Fruits" -> Produce
                             * Refrigerated, Frozen -> Freezer
                             * Meat, Seafood, Ethnic Foods -> Main dishes
                             * Tea and Coffee, Beverages, Alcoholic Beverages -> Drink
                             * "Bakery/Bread", "Nut butters, Jams, and Honey", "Bread", "Milk, Eggs, Other Dairy", "Cheese", "Cereal" -> Breakfast
                             * Condiments, Spices and Seasonings, "Oil, Vinegar, Salad Dressing" -> Food addons?
                             */

                            System.out.println( "ID: " + food.getId() + " Name: " + food.toString() + " Main: " + food.getMain() + " Calorie: " + food.getCaloriePerPortion() );
                            System.out.println( "********");
                            if( food.getMain().contains( ";" ) ){
                                System.out.println( "Heyyy");
                                String[] mains = food.getMain().split(";");
                                for ( int index = 0 ; index < mains.length; index++){

                                    System.out.println( "Main: " +mains[index] );
                                    if ( mains[index].equals("Meat") || mains[index].equals( "Seafood")  || mains[index].equals( "Ethnic Foods" ) ){
                                        food.setMain( "Main Dishes" );
                                        food.setExpiryDate( 30 );
                                    }
                                    else if ( mains[index].equals( "Health Foods" ) || mains[index].equals( "Produce" )|| mains[index].equals( "Dried Fruits" ) || mains[index].equals( "Nuts" ) ){
                                        if( food.getMain().equals( "Dried Fruits" ) || mains[index].equals( "Nuts" ) )
                                            food.setExpiryDate( 365 );
                                        else
                                            food.setExpiryDate( 7 );
                                        food.setMain( "Produce" );
                                    }
                                    else if ( mains[index].equals( "Refrigerated" ) || mains[index].equals( "Frozen" ) ){
                                        food.setMain( "Freezer" );
                                        food.setExpiryDate( 365 );
                                    }
                                    else if ( mains[index].equals( "Tea and Coffee" ) || mains[index].equals( "Beverages" ) || mains[index].equals( "Alcoholic Beverages" ) ){
                                        food.setMain( "Drink" );
                                        food.setExpiryDate( 365 );
                                    }
                                    else if ( mains[index].equals( "Bakery/Bread" ) || mains[index].equals( "Nut butters, Jams, and Honey" ) || mains[index].equals( "Bread" ) || mains[index].equals( "Milk, Eggs, Other Dairy" ) || mains[index].equals( "Cheese" ) || mains[index].equals( "Cereal" ) ){
                                        food.setMain( "Breakfast" );
                                        food.setExpiryDate( 14 );
                                    }
                                    else if ( mains[index].equals( "Condiments" ) || mains[index].equals( "Spices and Seasonings" ) || mains[index].equals( "Oil, Vinegar, Salad Dressing" ) ){
                                        food.setMain( "Food Addons" );
                                    }
                                    break;
                                }
                            }
                            else{
                                if ( food.getMain().equals( "Meat" ) || food.getMain().equals( "Seafood" )|| food.getMain().equals( "Ethnic Foods" ) ){
                                    food.setMain( "Main Dishes" );
                                    food.setExpiryDate( 30 );
                                }
                                else if ( food.getMain().equals( "Health Foods" ) || food.getMain().equals( "Produce" ) || food.getMain().equals( "Dried Fruits" ) || food.getMain().equals( "Nuts" )) {
                                    if( food.getMain().equals( "Dried Fruits" ) || food.getMain().equals( "Nuts" ))
                                        food.setExpiryDate( 365 );
                                    else{
                                        food.setExpiryDate( 7 );
                                    }
                                    food.setMain("Produce");
                                }
                                else if ( food.getMain().equals( "Refrigerated" ) || food.getMain().equals( "Frozen" ) ) {
                                    food.setMain("Freezer");
                                    food.setExpiryDate( 365 );
                                }
                                else if ( food.getMain().equals( "Tea and Coffee" ) || food.getMain().equals( "Beverages" )|| food.getMain().equals( "Alcoholic Beverages" ) ) {
                                    food.setMain("Drink");
                                    food.setExpiryDate( 365 );
                                }
                                else if ( food.getMain().equals( "Bakery/Bread" ) || food.getMain().equals( "Nut butters, Jams, and Honey" ) || food.getMain().equals( "Bread" ) || food.getMain().equals( "Milk, Eggs, Other Dairy" ) || food.getMain().equals( "Cheese" ) || food.getMain().equals( "Cereal" )) {
                                    food.setMain("Breakfast");
                                    food.setExpiryDate( 14 );
                                }
                                else if ( food.getMain().equals( "Condiments" ) || food.getMain().equals( "Spices and Seasonings" ) || food.getMain().equals( "Oil, Vinegar, Salad Dressing" ) ) {
                                    food.setMain( "Food Addons" );
                                }
                            }

                            System.out.println( "ID: " + food.getId() + " Name: " + food.toString() + " Main: " + food.getMain() + " Expiry Date: " + food.getExpiryDate() + " Calorie: " + food.getCaloriePerPortion() );


                             ////////
                             ////////
                             //////// Database
                            String name = "testuser";

                            int id1 = food.getId();
                            String foodname1 = food.getFoodName(); //
                            int expirydate1 = food.getExpiryDate(); //
                            String main1 = food.getMain();
                            double quantity1 = food.getAmount();
                            double calorie1 = food.getCaloriePerPortion().doubleValue();


                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                java.sql.Connection connect = DriverManager.getConnection(
                                        "jdbc:mysql://34.141.44.144:3306/" + name, "root", "root");

                                PreparedStatement statement = ((java.sql.Connection) connect).prepareStatement("insert into food  values (?,?,?,?,?,?)");

                                statement.setInt(1, id1);
                                statement.setString(2, foodname1);
                                statement.setInt(3, expirydate1);
                                statement.setString(4, main1);
                                statement.setDouble(5, quantity1);
                                statement.setDouble(6, calorie1);

                                statement.executeUpdate();

                            } catch (Exception e) {
                                System.out.println(e);

                            }


                            int a = JOptionPane.showConfirmDialog( frame,  amount + " grams of " + foodName + " is added to the storage." +
                                    " Do you want to add more?", "Quit", JOptionPane.INFORMATION_MESSAGE);

                            if (a == JOptionPane.YES_OPTION) {
                                jTextField1.setText( "" );
                                foodList = null;
                                updateLabels();

                            } else if (a == JOptionPane.NO_OPTION) {
                                frame.dispose();
                                //System.exit(0);
                            }
                        }

                    }
                });

            }

		}

		public void mouseEntered( MouseEvent event ) {
			Font font = labels.get( index ).getFont();
			labels.get(index).setFont( font.deriveFont( Font.BOLD ) );
		}
		
		public void mouseExited( MouseEvent e ) {  
			labels.get(index).setFont( FONT );
		}

	}

	public static String findJustDigit( String str ){
        String data = "";
        for( int count = 0; count < str.length(); count++ ){
            if ( Character.isDigit( str.charAt( count ) ) )
                data += str.charAt( count );
        }
        return data;
    }

	public void updateLabels(){

        if ( foodList != null && foodList.length != 0 ) {
            jPanel2.setBackground( Color.lightGray );
            if ( foodList[0] != null && Character.isAlphabetic( foodList[0].charAt(0) ) )
                jLabel1.setText(foodList[0]);
            else{
                jLabel1.setText( "" );
                jLabel2.setText( "" );
                jLabel3.setText( "" );
                jLabel4.setText( "" );
            }

            if( foodList.length > 1 ){
                if (foodList[1] != null && Character.isAlphabetic( foodList[1].charAt(0) ) )
                    jLabel2.setText(foodList[1]);
                else{
                    jLabel2.setText( "" );
                    jLabel3.setText( "" );
                    jLabel4.setText( "" );
                }
            }

            if( foodList.length > 2 ){
                if ( foodList[2] != null && Character.isAlphabetic( foodList[2].charAt(0) ) )
                    jLabel3.setText(foodList[2]);
                else{
                    jLabel3.setText( "" );
                    jLabel4.setText( "" );
                }
            }

            if( foodList.length > 3 ){
                if (foodList[3] != null && Character.isAlphabetic( foodList[3].charAt(0) ) )
                    jLabel4.setText(foodList[3]);
                else{
                    jLabel4.setText( "" );
                }
            }

        }
        else{
            jPanel2.setBackground( jPanel1.getBackground() );
            jLabel1.setText( "" );
            jLabel2.setText( "" );
            jLabel3.setText( "" );
            jLabel4.setText( "" );
        }
    }

    // Variables declaration - do not modify   
    public final static Font FONT = new Font( "Comic Sans MS" , Font.PLAIN, 12);

    private Food food ;
    private double amount;
    private SpoonacularAPI foodApi;
    private String[] foodList;
    private String foodName = "";
    private ArrayList<JLabel> labels;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
          
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String apiKey = "2b1ad64154msh266681e9461a336p1bfd1bjsndcdef3e10f2a";
        String apiKey2 = "609871132cmshf0661655cd3fa40p1266fbjsn0a5ce850b254";
        String apiKey3 = "da73587c8emsh6ca56b7d9f2a385p1699dcjsnf6a7ee99f8e3";
        SpoonacularAPI foodApi = new SpoonacularAPI( apiKey2 );

    	//JFrame frame = new JFrame("");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AutoCompleteGUI frame = new AutoCompleteGUI( foodApi );
                frame.setVisible(true);
            }
        });
    	
    }

}
