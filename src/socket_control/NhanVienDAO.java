/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Account;
import model.BanDoc;
import model.NhanVien;

/**
 *
 * @author Administrator
 */
public class NhanVienDAO {
    public java.sql.Connection cnn;
     public NhanVienDAO(){  
     } 
    public void ConectSql() throws ClassNotFoundException, SQLException{
      String DB_URL = "jdbc:mysql://localhost/laptrinhmang";
      String USER = "root";
      String PASSWORD = "261098";
      Class.forName("com.mysql.cj.jdbc.Driver");
      cnn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
      Statement state = cnn.createStatement(); 
    }
     public NhanVien getNhanVienID(String id) throws ClassNotFoundException, SQLException{
        ConectSql();
        String sql = "SELECT * FROM laptrinhmang.nhanvien WHERE `idNV`=?;";
        NhanVien nhanvien = null;
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
           nhanvien = new NhanVien();
           nhanvien.setId(rs.getString("idNV"));
           nhanvien.setTen(rs.getString("tenNV"));
           nhanvien.setEmail(rs.getString("emailNV"));
           nhanvien.setSdt(rs.getString("sdt"));
           nhanvien.setAcount(new Account(rs.getString("tendangnhapNV"), rs.getString("matkhau")));
           nhanvien.setNgaysinh(rs.getString("ngaysinhNV"));
           nhanvien.setVitri(rs.getString("vitri"));
           nhanvien.setLuong(rs.getFloat("luong"));
        }
        return nhanvien;
    }
     public ArrayList<NhanVien> getAllNhanVien() throws SQLException, ClassNotFoundException {
         ConectSql();
        ArrayList<NhanVien> list = new ArrayList();
        String sql = "SELECT * FROM laptrinhmang.nhanvien";
        try {
            ResultSet rs = (ResultSet) cnn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
               NhanVien  nhanvien = new NhanVien();
                nhanvien.setId(rs.getString("idNV"));
                nhanvien.setTen(rs.getString("tenNV"));
                nhanvien.setEmail(rs.getString("emailNV"));
                nhanvien.setSdt(rs.getString("sdt"));
                nhanvien.setAcount(new Account(rs.getString("tendangnhapNV"), rs.getString("matkhau")));
                nhanvien.setNgaysinh(rs.getString("ngaysinhNV"));
                nhanvien.setVitri(rs.getString("vitri"));
                nhanvien.setLuong(rs.getFloat("luong"));
                list.add(nhanvien);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp inSanPhamDAO ");
        }
        cnn.close();
        return list;
    }
      public ArrayList<Account> getAccountNV() throws SQLException, ClassNotFoundException {
          ConectSql();
        ArrayList<Account> list = new ArrayList();
        String sql = "SELECT nhanvien.tendangnhapNV,nhanvien.matkhau FROM laptrinhmang.nhanvien";
        try {
            ConectSql();
            ResultSet rs = cnn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String tendangnhapBD = rs.getString("tendangnhapNV");
                String matkhau = rs.getString("matkhau");
                Account acbd = new Account(tendangnhapBD, matkhau);
                list.add(acbd);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp inSanPhamDAO ");
        }
        cnn.close();
        return list;
    }
     public void insertNhanVien(NhanVien bd) throws SQLException, ClassNotFoundException{
        ConectSql();
        String sql = "INSERT INTO `laptrinhmang`.`nhanvien`(`idNV`,`tenNV`,`emailNV`,`sdt`,`tendangnhapNV`,`matkhau`,`ngaysinhNV`,`vitri`,`luong`) VALUES(?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getId());
        ps.setString(2, bd.getTen());
        ps.setString(3, bd.getEmail());
        ps.setString(4, bd.getSdt());
        ps.setString(5, bd.getAcount().getUsername());
        ps.setString(6, bd.getAcount().getPassword());
        ps.setString(7, bd.getNgaysinh());
        ps.setString(8, bd.getVitri());
        ps.setFloat(9, bd.getLuong());
        ps.execute();
    }
    public void updateNhanVien(NhanVien bd) throws ClassNotFoundException, SQLException{
         ConectSql();
          String sql = "UPDATE `laptrinhmang`.`nhanvien` SET `tenNV`=?,`emailNV`=?,`sdt`=?,`ngaysinhNV`=?,`vitri`=?,`luong`=? WHERE `idNV`=?;";
          PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getTen());
        ps.setString(2, bd.getEmail());
        ps.setString(3, bd.getSdt());
        ps.setString(4, bd.getNgaysinh()); 
        ps.setString(5, bd.getVitri());
        ps.setFloat(6, bd.getLuong());
        ps.setString(7, bd.getId());
         ps.execute();
    }
}
