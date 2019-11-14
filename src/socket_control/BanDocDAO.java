/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;
import model.BanDoc;
import model.Sach;

/**
 *
 * @author Administrator
 */
public class BanDocDAO {
    public java.sql.Connection cnn;
     public BanDocDAO(){  
     } 
    public void ConectSql() throws ClassNotFoundException, SQLException{
      String DB_URL = "jdbc:mysql://localhost/laptrinhmang";
      String USER = "root";
      String PASSWORD = "261098";
      Class.forName("com.mysql.cj.jdbc.Driver");
      cnn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
      Statement state = cnn.createStatement(); 
    }
      public BanDoc getBanDocID(String id) throws ClassNotFoundException, SQLException{
        ConectSql();
        String sql = "SELECT * FROM laptrinhmang.bandoc WHERE `idBD`=?;";
        BanDoc bandoc = null;
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            bandoc = new BanDoc(rs.getString("idBD"),rs.getString("tenBD"), rs.getString("email"),rs.getString("sdt"),rs.getString("ngaysinh"),new Account(rs.getString("tendangnhapBD"), rs.getString("matkhau")));
        }
        return bandoc;
    }
     public ArrayList<BanDoc> getAllBanDoc() throws SQLException, ClassNotFoundException {
         ConectSql();
        ArrayList<BanDoc> list = new ArrayList();
        String sql = "SELECT * FROM laptrinhmang.bandoc";
        try {
            ConectSql();
            ResultSet rs = (ResultSet) cnn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String idBD = rs.getString("idBD");
                String tenBD = rs.getString("tenBD");
                String emailBD = rs.getString("email");
                String sdt = rs.getString("sdt");
                String ngaysinh = rs.getString("ngaysinh");
                Account account = new Account(rs.getString("tendangnhapBD"), rs.getString("matkhau"));
                BanDoc bd = new BanDoc(idBD, tenBD, emailBD, sdt, ngaysinh, account);
                list.add(bd);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp inSanPhamDAO ");
        }
        cnn.close();
        return list;
    }
     public BanDoc getBanDocFromUserName(String username, String password) throws ClassNotFoundException, SQLException{
         BanDoc bd = null;
         ConectSql();
         String sql = "SELECT * FROM laptrinhmang.bandoc WHERE `tendangnhapBD`=? AND `matkhau`=?;";
          PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1,username );
            ps.setString(2, password);
         ResultSet rs = (ResultSet) ps.executeQuery();
         while(rs.next()){
             String idBD = rs.getString("idBD");
                String tenBD = rs.getString("tenBD");
                String emailBD = rs.getString("email");
                String sdt = rs.getString("sdt");
                String ngaysinh = rs.getString("ngaysinh");
                Account account = new Account(rs.getString("tendangnhapBD"), rs.getString("matkhau"));
                bd = new BanDoc(idBD, tenBD, emailBD, sdt, ngaysinh, account);
         }
         return bd;
     }
     public ArrayList<Account> getAccountBD() throws SQLException {
        ArrayList<Account> list = new ArrayList();
        String sql = "SELECT bandoc.tendangnhapBD,bandoc.matkhau FROM laptrinhmang.bandoc";
        try {
            ConectSql();
           
            ResultSet rs = cnn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String tendangnhapBD = rs.getString("tendangnhapBD");
                String matkhau = rs.getString("matkhau");
                Account acbd = new Account(tendangnhapBD, matkhau);
                list.add(acbd);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp inBandocDAO ");
        }
        cnn.close();
        return list;
    }
     public void insertBanDoc(BanDoc bd) throws SQLException, ClassNotFoundException{
        ConectSql();
        String sql = "INSERT INTO `laptrinhmang`.`bandoc`(`idBD`,`tenBD`,`email`,`sdt`,`tendangnhapBD`,`matkhau`,`ngaysinh`) VALUES( ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getId());
        ps.setString(2, bd.getTen());
        ps.setString(3, bd.getEmail());
        ps.setString(4, bd.getSdt());
        ps.setString(5, bd.getAcount().getUsername());
        ps.setString(6, bd.getAcount().getPassword());
        ps.setString(7, bd.getNgaysinh());
        ps.execute();
    }
    public void updateBanDoc(BanDoc bd) throws ClassNotFoundException, SQLException{
         ConectSql();
          String sql = "UPDATE `laptrinhmang`.`bandoc` SET `tenBD`=?,`email`=?,`sdt`=?,`ngaysinh`=? WHERE `idBD`=?;";
          PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getTen());
        ps.setString(2, bd.getEmail());
        ps.setString(3, bd.getSdt());
        ps.setString(4, bd.getNgaysinh());
        ps.setString(5, bd.getId());
        ps.execute(); 
    }
}
