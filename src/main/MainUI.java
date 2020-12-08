package main;

import java.awt.Font;
import javax.swing.*;

import hanoi_towers.MainFrame;
import tree.DisplaySimpleTree;
import sort2.*;

public class MainUI extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    /**
     * Creates new form MainUI
     */
    
    public MainUI() {
        initComponents();
    }

    private void initComponents() {

        splitJPanel = new javax.swing.JSplitPane();
        buttonJPanel = new javax.swing.JPanel();
        viewJPanel = new javax.swing.JPanel();
        viewButton = new javax.swing.JButton();
        treeButton = new javax.swing.JButton();
        towerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout buttonJPanelLayout = new javax.swing.GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        buttonJPanelLayout.setHorizontalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        buttonJPanelLayout.setVerticalGroup(
            buttonJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );
  
        JLabel textLabel = new JLabel("Data structure and algorithms", JLabel.CENTER);
        JLabel imageLable = new JLabel("", JLabel.CENTER);
        textLabel.setFont(new Font("Verdana",3,18));        
        textLabel.setSize(500, 100);
        imageLable.setIcon(new ImageIcon("download.jpg"));
        imageLable.setSize(500, 350);;
        buttonJPanel.add(textLabel);
        buttonJPanel.add(imageLable);
        splitJPanel.setRightComponent(buttonJPanel);

        viewButton.setText(" Tower of Hanoi ");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towerButtonActionPerformed(evt);
            }
        });

        treeButton.setText(" Binary Tree ");
        treeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treeButtonActionPerformed(evt);
            }
        });

        towerButton.setText(" Sorting ");
        towerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewJPanelLayout = new javax.swing.GroupLayout(viewJPanel);
        viewJPanel.setLayout(viewJPanelLayout);
        viewJPanelLayout.setHorizontalGroup(
            viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewButton)
                    .addComponent(treeButton)
                    .addComponent(towerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewJPanelLayout.setVerticalGroup(
            viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewJPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(viewButton)
                .addGap(21, 21, 21)
                .addComponent(treeButton)
                .addGap(20, 20, 20)
                .addComponent(towerButton)
                .addContainerGap(357, Short.MAX_VALUE))
        );

        splitJPanel.setLeftComponent(viewJPanel);

        //getContentPane().add(splitJPanel, java.awt.BorderLayout.CENTER);
        getContentPane().add(splitJPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // TODO add your handling code here:
        //NewWindow frame = new NewWindow();
        VisualizerFrame frame = new VisualizerFrame();
        SortingVisualizer.resetArray();
        frame.setLocationRelativeTo(null);
        SortingVisualizer.startSort();
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Binary tree");
        //set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_createButtonActionPerformed

    private void treeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        DisplaySimpleTree frame = new DisplaySimpleTree();//get a display panel
        frame.setVisible(true); //show the display
        frame.setTitle("Binary tree");
        //set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_viewButtonActionPerformed

    private void towerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        // TODO add your handling code here:
        MainFrame frame = new MainFrame();
        frame.setTitle("Tower of Hanoi");
        frame.setVisible(true);
        //set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_viewButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonJPanel;
    //private JLabel headerLabel;
    private javax.swing.JButton viewButton;
    private javax.swing.JSplitPane splitJPanel;
    private javax.swing.JButton treeButton;
    private javax.swing.JButton towerButton;
    private javax.swing.JPanel viewJPanel;
    // End of variables declaration//GEN-END:variables
}