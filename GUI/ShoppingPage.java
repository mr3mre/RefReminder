package GUI;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Eren
 */
public class ShoppingPage extends javax.swing.JFrame {

    /**
     * Creates new form Shopping
     */
    public ShoppingPage() {
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
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        JPanel topPanel = new JPanel();
        JPanel jPanel1 = BrowserPanel.makePanel( "https://www.migros.com.tr/" );
        jPanel1.setPreferredSize( new Dimension( 800, 500 ) );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout());

        jButton1.setBackground(new java.awt.Color(255, 102, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Main Menu");
        jButton1.setToolTipText("");
        jButton1.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        topPanel.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setText("Stock Control");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        topPanel.add(jButton2);

        jButton3.setBackground(new java.awt.Color(0, 153, 0));
        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setText("Reciper");
        jButton3.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton3.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        topPanel.add(jButton3);

        jButton4.setBackground(new java.awt.Color(255, 51, 0));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setText("Restaurants");
        jButton4.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton4.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        topPanel.add(jButton4);

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setText("Bilkent Menu");
        jButton5.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton5.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        topPanel.add(jButton5);

        jButton6.setBackground(new java.awt.Color(102, 255, 102));
        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setText("Shopping");
        jButton6.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 35));
        topPanel.add(jButton6);

        jButton7.setBackground(new java.awt.Color(0, 51, 204));
        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton7.setText("Settings");
        jButton7.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton7.setPreferredSize(new java.awt.Dimension(120, 35));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        topPanel.add(jButton7);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        this.add( jPanel1, BorderLayout.SOUTH );
        this.add( topPanel, BorderLayout.NORTH );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        MainMenu mm = new MainMenu();
        mm.setVisible(true);
        setVisible(false);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        StockControlPage stckcntrl = new StockControlPage();
        stckcntrl.setVisible(true);
        setVisible(false);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        ReciperPage reciper = new ReciperPage();
        reciper.setVisible(true);
        setVisible(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        RestaurantsPage restaurant = new RestaurantsPage();
        restaurant.setVisible(true);
        setVisible(false);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
        Settings1 settings = new Settings1();
        settings.setVisible(true);
        setVisible(false);
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        BilkentMenuPage bilmenu = new BilkentMenuPage();
        bilmenu.setVisible(true);
        setVisible(false);
    }

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    // End of variables declaration
}
