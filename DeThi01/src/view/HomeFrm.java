/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerImp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import model.Manager;
import model.Driver;
import model.Pair;
import model.Bus;

/**
 *
 * @author ADMIN
 */
public class HomeFrm extends javax.swing.JFrame implements View {

    /**
     * Creates new form HomeFrm
     */
    private List<Driver> listLX;
    private DefaultTableModel modelLX;
    private ControllerImp controller;
    private DefaultTableModel modelBuses;
    private List<Bus> listBuses;
    private List<Manager> listManager;
    private DefaultTableModel modelManager;
    
    public HomeFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        listLX = new ArrayList<>();
        modelLX = (DefaultTableModel) tblLaiXe.getModel();
        controller = new ControllerImp();
        listBuses = new ArrayList<>();
        modelBuses = (DefaultTableModel) tblBuses.getModel();
        listManager = new ArrayList<>();
        modelManager = (DefaultTableModel) tblManager.getModel();
        showLX();
        showBuses();
        showManager();
    }

    public List<Driver> getListLX() {
        return listLX;
    }

    public List<Bus> getListBuses() {
        return listBuses;
    }
    
    boolean addManager(Driver driver, Pair<Bus, Integer> pair) {
        boolean isAccepted = controller.isAccepted(listManager, driver, pair);
        if(!isAccepted) {
            return false;
        }
        controller.addOrUpdate(listManager, driver, pair);
        this.showData(listManager, modelManager);
        controller.writeToFile(listManager, "PHANCONG.TXT");
        return true;
    }

    public void addLaiXe(Driver l) {
        listLX.add(l);
        this.showData(listLX, modelLX);
        controller.writeToFile(listLX, "LX.TXT");
    }
    
    public void addBuses(Bus t) {
        listBuses.add(t);
        this.showData(listBuses, modelBuses);
        controller.writeToFile(listBuses, "TUYEN.TXT");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaiXe = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuses = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblManager = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboSortOption = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblLaiXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã LX", "Họ tên", "Địa chỉ", "Trình độ"
            }
        ));
        jScrollPane1.setViewportView(tblLaiXe);
        if (tblLaiXe.getColumnModel().getColumnCount() > 0) {
            tblLaiXe.getColumnModel().getColumn(3).setHeaderValue("Trình độ");
        }

        jButton1.setText("Thêm LX");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sửa LX");

        jButton3.setText("Xóa LX");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jButton1)
                .addGap(95, 95, 95)
                .addComponent(jButton2)
                .addGap(95, 95, 95)
                .addComponent(jButton3)
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(0, 117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("QL Lai Xe", jPanel1);

        tblBuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tuyến", "Khoảng cách", "Số điểm dừng"
            }
        ));
        jScrollPane2.setViewportView(tblBuses);

        jButton4.setText("Thêm Tuyến");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sửa Tuyến");

        jButton6.setText("Xóa Tuyến");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jButton4)
                .addGap(103, 103, 103)
                .addComponent(jButton5)
                .addGap(98, 98, 98)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(0, 117, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("QL Tuyen", jPanel2);

        tblManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã LX", "Tên LX", "Mã tuyến", "Số lượt", "Tổng Số lượt", "Tổng Số Tuyến"
            }
        ));
        jScrollPane3.setViewportView(tblManager);

        jButton7.setText("Thêm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Sửa");

        jButton9.setText("Xóa");

        jLabel1.setText("Sắp xếp theo:");

        comboSortOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp  xếp theo tên lái xe", "Sắp xếp theo số lượng tuyến đảm nhận", " " }));
        comboSortOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSortOptionActionPerformed(evt);
            }
        });

        jButton10.setText("refesh");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton7)
                        .addGap(92, 92, 92)
                        .addComponent(jButton8)
                        .addGap(94, 94, 94)
                        .addComponent(jButton9))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(comboSortOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jButton10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboSortOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(13, 13, 13))
        );

        jTabbedPane2.addTab("QL Phan Cong", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AddDriver(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new AddBusFrm(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new AddManagerFrm(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void comboSortOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSortOptionActionPerformed
        // TODO add your handling code here:
        int index = comboSortOption.getSelectedIndex();
        if(index == 0){
            controller.sortByName(listManager);
        } else if(index == 1){
            controller.sortByBuses(listManager);
        }
        this.showData(listManager, modelManager);
    }//GEN-LAST:event_comboSortOptionActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Collections.shuffle(listManager);
        
    }//GEN-LAST:event_jButton10ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboSortOption;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tblBuses;
    private javax.swing.JTable tblLaiXe;
    private javax.swing.JTable tblManager;
    // End of variables declaration//GEN-END:variables

    @Override
    public <T> void showData(List<T> list, DefaultTableModel model) {
        model.setRowCount(0);
        for (T t : list) {
            if (t instanceof Driver) {
                Driver l = (Driver) t;
                model.addRow(new Object[]{
                    l.getId(), l.getName(), l.getAddress(), l.getLevel()
                });
            }
            if(t instanceof Bus) {
                Bus tu = (Bus) t;
                model.addRow(new Object[]{
                    tu.getId(), tu.getDistance(), tu.getStation()
                });
            }
            if(t instanceof Manager) {
                Manager b = (Manager) t;
                for (Pair<Bus, Integer> pair : b.getPairs()) {
                    model.addRow(new Object[]{
                        b.getDriver().getId(), b.getDriver().getName(), 
                        pair.getTuyen().getId(), pair.getSoLuot(), b.getTongSoLuot()
                            ,b.getPairs().size()
                    });
                }
            }
        }
    }

    private void showLX() {
        listLX = controller.readDataFromFile("LX.TXT");
        if(listLX.size() > 0) {
            int mId = listLX.get(listLX.size() - 1).getId();
            Driver.setsId(mId + 1);
        }
        this.showData(listLX, modelLX);
    }

    private void showBuses() {
        listBuses = controller.readDataFromFile("TUYEN.TXT");
        if(listBuses.size() > 0) {
            int mId = listBuses.get(listBuses.size() - 1).getId();
            Bus.setsId(mId + 1);
        }
        this.showData(listBuses, modelBuses);     
    }

    private void showManager() {
        listManager = controller.readDataFromFile("PHANCONG.TXT");
        this.showData(listManager, modelManager);
    }

}
