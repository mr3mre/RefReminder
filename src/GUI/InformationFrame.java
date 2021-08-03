package GUI;

import APIs.src.java.net.http.SpoonacularAPI;
import APIs.src.java.net.http.YoutubeViewer;
import Logic.Recipe;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Emre, Eren, Amir
 */
public class InformationFrame extends javax.swing.JFrame {

    /**
     * Creates new form frame
     */
    public InformationFrame() throws IOException, InterruptedException {
        setSize(1200,800);
        setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() throws IOException, InterruptedException {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane  = new javax.swing.JEditorPane();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabelName = new javax.swing.JLabel();
        jLabelNameIngredients = new javax.swing.JLabel();
        recipe = RecipePage.getRecipe();
        jPanelVideo = new JPanel();
        api = new SpoonacularAPI();
        liss = new DefaultListModel();

        ArrayList<String> foodDetails = api.getRecipeInformation( recipe.getID() );

        NativeInterface.open();
        System.out.println( recipe.getRecipeName() );
        String url =  api.searchFoodVideos( recipe.getRecipeName() );
        jPanelVideo = YoutubeViewer.getBrowserPanel( url );

        // Checks if the recipe has instructions
        try {
            instructions = foodDetails.get( 0 );
        }
        catch ( Exception e ) {
            instructions = "There were no instructions for the selected recipe.";
        }

        // Checks if the recipe has health score
        try {
            healthBar = foodDetails.get( 1 );
        }
        catch ( Exception e ) {
            healthBar = "0";
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 248, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14));
        jLabel1.setText("Health Score");

        // Clear the text from HTML formatting
        editorPane.setContentType( "text/html" );
        editorPane.setText( instructions );
        editorPane.setEditable( false );
        jScrollPane1.setViewportView( editorPane );

        // Calculates the percentage with the health bar
        jProgressBar1.setBackground( new java.awt.Color(240, 248, 255 ) );
        jProgressBar1.setMaximum( 0 );
        jProgressBar1.setMaximum( 100 );
        jProgressBar1.setValue(Integer.parseInt( healthBar ) );
        jProgressBar1.setStringPainted( true );
        jProgressBar1.setForeground( Color.black );
        double percentage = ( Integer.parseInt( healthBar ) / ( double ) 100 ) * 100;
        int percentageNum = ( int ) percentage;
        String percentageString = Double.toString( percentageNum );;
        jProgressBar1.setString( "% "+ percentageString);

        jList1.setFont( new java.awt.Font( "Lucida Grande", 0, 14 ) );
        jList1.setModel( new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = new ArrayList<>();
            public int getSize() { return strings.size(); }
            public String getElementAt( int i ) { return strings.get( i ); }
        });

        // Checks if there are ingredients, adds them
        for( int count = 2; count< foodDetails.size(); count++ ){
            try {
                liss.addElement( foodDetails.get( count ) );
            }
            catch ( Exception e ) {
                System.out.println( "Could not add the ingredient." );
            }
        }

        jList1.setModel(liss);
        jScrollPane2.setViewportView(jList1);

        jLabelName.setFont(new java.awt.Font("Tahoma", 1, 14 ) );
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText( recipe.getRecipeName() );

        jLabelNameIngredients.setFont(new java.awt.Font( "Tahoma", 1, 12 ) );
        jLabelNameIngredients.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNameIngredients.setText("Ingredients");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jScrollPane2)
                                                .addComponent(jLabelNameIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanelVideo)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                                .addGap(31, 31, 31))
                        .addComponent(jLabelName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanelVideo)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelNameIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    /**
     * Main method to test the class
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException | InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                try {
                    new InformationFrame().setVisible( true );
                }
                catch ( IOException | InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNameIngredients;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelVideo;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane editorPane ;
    private Recipe recipe;
    private SpoonacularAPI api;
    private DefaultListModel liss;
    private String instructions;
    private String healthBar;
    // End of variables declaration
}
