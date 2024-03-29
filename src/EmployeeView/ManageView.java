/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeView;

import EmployeeView.QuanLyBanDoc.SuaBanDoc;
import EmployeeView.QuanLyBanDoc.ThemBanDoc;
import EmployeeView.QuanLyBanDoc.XemThongTinBD;
import EmployeeView.QuanLyNhanVien.SuaNhanVien;
import EmployeeView.QuanLyNhanVien.ThemNhanVien;
import EmployeeView.QuanLyNhanVien.XemThongTinNV;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ManageView extends javax.swing.JFrame {

    /**
     * Creates new form FunctionView
     */
  ObjectInputStream ios;
    ObjectOutputStream oos;
    DataInputStream dataIn;
    DataOutputStream dataOut;
    Socket socket;
    public ManageView(Socket socet,ObjectInputStream ios, ObjectOutputStream oos, DataInputStream dataIn, DataOutputStream dataOut) {
       setVisible(true);
        initComponents();
         this.ios = ios;
        this.oos = oos;
        this.socket = socet;
        this.dataIn = dataIn;
        this.dataOut = dataOut;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        QLSmenu = new javax.swing.JMenu();
        InsertBmenu = new javax.swing.JMenuItem();
        UpdateBMenu = new javax.swing.JMenuItem();
        btnXemB = new javax.swing.JMenuItem();
        btnDelete2 = new javax.swing.JMenu();
        InsertCMenu = new javax.swing.JMenuItem();
        UpdateCmenu = new javax.swing.JMenuItem();
        btnXemC = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        ThemNV = new javax.swing.JMenuItem();
        SuaNV = new javax.swing.JMenuItem();
        XemNV = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenu();

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        QLSmenu.setText("Quản lý sách");

        InsertBmenu.setText("Thêm sách");
        InsertBmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertBmenuActionPerformed(evt);
            }
        });
        QLSmenu.add(InsertBmenu);

        UpdateBMenu.setText("Sửa sách");
        UpdateBMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBMenuActionPerformed(evt);
            }
        });
        QLSmenu.add(UpdateBMenu);

        btnXemB.setText("Xem thông tin");
        btnXemB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemBActionPerformed(evt);
            }
        });
        QLSmenu.add(btnXemB);

        jMenuBar1.add(QLSmenu);

        btnDelete2.setText("Quản lý bạn đọc");

        InsertCMenu.setText("Thêm");
        InsertCMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertCMenuActionPerformed(evt);
            }
        });
        btnDelete2.add(InsertCMenu);

        UpdateCmenu.setText("Sửa");
        UpdateCmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateCmenuActionPerformed(evt);
            }
        });
        btnDelete2.add(UpdateCmenu);

        btnXemC.setText("Xem thông tin bạn đọc");
        btnXemC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemCActionPerformed(evt);
            }
        });
        btnDelete2.add(btnXemC);

        jMenuBar1.add(btnDelete2);

        jMenu1.setText("Quản lý nhân viên");

        ThemNV.setText("Thêm nhân viên");
        ThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemNVActionPerformed(evt);
            }
        });
        jMenu1.add(ThemNV);

        SuaNV.setText("Cập nhật nhân viên");
        SuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaNVActionPerformed(evt);
            }
        });
        jMenu1.add(SuaNV);

        XemNV.setText("Xem thông tin ");
        XemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XemNVActionPerformed(evt);
            }
        });
        jMenu1.add(XemNV);

        jMenuBar1.add(jMenu1);

        ExitMenu.setText("Thoát");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(ExitMenu);

        setJMenuBar(jMenuBar1);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateBMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBMenuActionPerformed
        // TODO add your handling code here:
        UpdateBookView updateB = new UpdateBookView (socket,ios, oos,dataIn,dataOut);
        setVisible(false);
        
    }//GEN-LAST:event_UpdateBMenuActionPerformed

    private void InsertBmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertBmenuActionPerformed
        // TODO add your handling code here:
        InsertBookView inserB = new InsertBookView(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_InsertBmenuActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        if(socket!=null){
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ManageView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void btnXemBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemBActionPerformed
        // TODO add your handling code here:
        xemThongTinS XemS = new xemThongTinS(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_btnXemBActionPerformed

    private void UpdateCmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateCmenuActionPerformed
        // TODO add your handling code here:
        SuaBanDoc SuaBd = new SuaBanDoc(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_UpdateCmenuActionPerformed

    private void InsertCMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertCMenuActionPerformed
        // TODO add your handling code here:
        ThemBanDoc ThemBd = new ThemBanDoc(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_InsertCMenuActionPerformed

    private void ThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemNVActionPerformed
        // TODO add your handling code here:
        ThemNhanVien ThemNV = new ThemNhanVien(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_ThemNVActionPerformed

    private void btnXemCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemCActionPerformed
        // TODO add your handling code here:
      // XemThongTinBD xemBd  = new XemThongTinBD(socket,ios, oos,dataIn,dataOut);
        XemMuonTra sm  = new XemMuonTra(socket, ios, oos, dataIn, dataOut);
        setVisible(false);
    }//GEN-LAST:event_btnXemCActionPerformed

    private void SuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaNVActionPerformed
        // TODO add your handling code here:
        SuaNhanVien SuaNv = new SuaNhanVien(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_SuaNVActionPerformed

    private void XemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XemNVActionPerformed
        // TODO add your handling code here:
         XemThongTinNV xemNv  = new XemThongTinNV(socket,ios, oos,dataIn,dataOut);
        setVisible(false);
    }//GEN-LAST:event_XemNVActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JMenuItem InsertBmenu;
    private javax.swing.JMenuItem InsertCMenu;
    private javax.swing.JMenu QLSmenu;
    private javax.swing.JMenuItem SuaNV;
    private javax.swing.JMenuItem ThemNV;
    private javax.swing.JMenuItem UpdateBMenu;
    private javax.swing.JMenuItem UpdateCmenu;
    private javax.swing.JMenuItem XemNV;
    private javax.swing.JMenu btnDelete2;
    private javax.swing.JMenuItem btnXemB;
    private javax.swing.JMenuItem btnXemC;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
