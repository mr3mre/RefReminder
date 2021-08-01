package GUI;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import APIs.src.java.net.http.SpoonacularAPI;
import Logic.Food;
import Logic.FoodSelect;

import javax.imageio.ImageIO;
import javax.swing.*;

import Logic.Recipe;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author goksu
 */
public class RecipePage extends javax.swing.JFrame {
    private static Recipe recipe;

    /**
     * Creates new form RecipeGui
     */
    public RecipePage() {
        sd = new FoodSelect();
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

        jPanel1 = new JPanel();
        jComboBox1 = new JComboBox<>();
        jButton1 = new JButton();
        jButton8 = new JButton();
        jButton10 = new JButton();
        jButton9 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jButton13 = new JButton();
        jLabel1 = new JLabel();
        jPanel2 = new JPanel();
        jLabelImage = new JLabel();
        jLabelName = new JLabel();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jButtonAdd = new JButton();
        jButtonSearch = new JButton();
        jButtonNext = new JButton();
        jButtonDetails = new JButton();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        AutoCompleteDecorator.decorate(jComboBox1);
        api = new SpoonacularAPI();
        order = 0;
        recipes = new ArrayList<>();
        ingredients = new ArrayList<>();
        liss = new DefaultListModel();
        foodList2 = new ArrayList<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 255, 255));
        String[] strArray = new String[sd.getFood().size()];

        for(int i = 0; i < sd.getFood().size(); i++) {
            strArray[i] = sd.getFood().get(i).getFoodName();

        }
        System.out.println(Arrays.toString(strArray));

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "yemek1", "yemek2" }));
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new Color(255, 102, 255));
        jButton1.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setText("Main Menu");
        jButton1.setPreferredSize(new Dimension(120, 35));
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new Color(255, 51, 51));
        jButton8.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton8.setText("Stock Control");
        jButton8.setPreferredSize(new Dimension(120, 35));
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new Color(0, 153, 0));
        jButton10.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton10.setText("Reciper");
        jButton10.setPreferredSize(new Dimension(120, 35));
        jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new Color(255, 51, 0));
        jButton9.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton9.setText("Restaurants");
        jButton9.setPreferredSize(new Dimension(120, 35));
        jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new Color(51, 153, 255));
        jButton11.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton11.setText("Bilkent Menu");
        jButton11.setPreferredSize(new Dimension(120, 35));
        jButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new Color(102, 255, 102));
        jButton12.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton12.setText("Shopping");
        jButton12.setPreferredSize(new Dimension(120, 35));
        jButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new Color(0, 51, 204));
        jButton13.setFont(new Font("Times New Roman", 0, 12)); // NOI18N
        jButton13.setText("Settings");
        jButton13.setPreferredSize(new Dimension(120, 35));
        jButton13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Select a Food From Your Storage");

        jPanel2.setBackground(new Color(255, 255, 255));
        jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jLabelName.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelName.setText("jLabel4");
        jLabelName.setFont(new Font("Lucida Grande", 1, 13));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelImage)
                                .addGap(86, 86, 86))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelImage)
                                .addGap(36, 36, 36))
        );

        jButton2.setText("New Random");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        jLabel2.setFont(new Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Get Random Recipe!");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButtonSearchActionPerformed(evt);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonDetails.setText("Details");
        jButtonDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButtonDetailsActionPerformed(evt);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        jList1.setModel(new AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }

            public String[] getElements() {
                return strings;
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(569, 569, 569)
                                                .addComponent(jButtonDetails)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(90, 90, 90))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(25, 25, 25)
                                                                                .addComponent(jLabel1))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(65, 65, 65)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jButton2)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(19, 19, 19)
                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(18, 18, 18))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(29, 29, 29)))
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonNext)
                                                        .addComponent(jButtonDetails))
                                                .addGap(24, 24, 24))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(17, 17, 17)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonAdd))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonSearch)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
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

    private void jButtonAddActionPerformed(ActionEvent evt) {
        foodList2 = new ArrayList<String>();

        String foodName = (String) jComboBox1.getSelectedItem();

        liss.addElement(foodName);
        foodList2.add(foodName);

        jList1.setModel(liss);


        for(int h = 0; h < liss.size(); h++){
            if(liss.getElementAt(h).equals(foodName)){
                jComboBox1.addItem( jComboBox1.getItemAt( jComboBox1.getSelectedIndex() ) );
            }

        }

        jScrollPane1.setViewportView(jList1);
    }

    private void jButtonDetailsActionPerformed(ActionEvent evt) throws IOException, InterruptedException {
        InformationFrame info = new InformationFrame();
        info.setVisible(true);
    }

    private void jButtonNextActionPerformed(ActionEvent evt) {
        order++;

    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        recipe = api.getRandomRecipe();
        getRecipe( recipe );
    }

    private void getRecipe( Recipe recipe ) throws IOException, InterruptedException {
        jLabelName.setText( recipe.getRecipeName() );
        URL url = new URL( recipe.getImageURL() );
        BufferedImage image = ImageIO.read( url );
        Image resizedImage = image.getScaledInstance( 320, 240, Image.SCALE_SMOOTH);
        jLabelImage.setIcon( new ImageIcon( resizedImage ) );
    }

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) throws IOException, InterruptedException {
        if ( order == 0 ) {
            ingredients = new ArrayList<>();
            for (int i = 0; i < jList1.getModel().getSize(); i++) {
                ingredients.add(jList1.getModel().getElementAt(i));
            }
        }

        recipes = api.searchRecipesByIngredients( ingredients );
        recipe = recipes.get( order );
        getRecipe( recipe );
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
            java.util.logging.Logger.getLogger( RecipePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecipePage().setVisible(true);
            }
        });
    }

    public static Recipe getRecipe() {
        return recipe;
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    SpoonacularAPI api;
    int order;
    FoodSelect sd;
    ArrayList<Recipe> recipes;
    ArrayList<String> ingredients;
    DefaultListModel liss;
    ArrayList<String> foodList2;
    // End of variables declaration
}
