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
import model.MuonTra;

/**
 *
 * @author Administrator
 */
public class MuonTraDAO {
    public java.sql.Connection cnn;
     public MuonTraDAO(){  
     } 
    public void ConectSql() throws ClassNotFoundException, SQLException{
      String DB_URL = "jdbc:mysql://localhost/laptrinhmang";
      String USER = "root";
      String PASSWORD = "261098";
      Class.forName("com.mysql.cj.jdbc.Driver");
      cnn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
      Statement state = cnn.createStatement(); 
    }
     public void insertMuonTra(MuonTra mt) throws SQLException, ClassNotFoundException{
        ConectSql();
        String sql = "INSERT INTO `laptrinhmang`.`muontrasach`(`idBD`,`idSach`,`tenBD`,`tenSach`,`loaiSach`,`soluong`,`ngaymuon`,`ngaytra`) VALUES( ?,?,?,?,?,?,?,?);";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, mt.getIdBD());
        ps.setString(2, mt.getIdSach());
        ps.setString(3, mt.getTenBD());
        ps.setString(4, mt.getTenSach());
        ps.setString(5, mt.getLoaiSach());
        ps.setInt(6, mt.getSoluong());
        ps.setString(7, mt.getNgaymuon());
        ps.setString(8, mt.getNgaytra());
        ps.execute();
    }
    
    public void updateMuonTra(MuonTra mt) throws ClassNotFoundException, SQLException{
         ConectSql();
          String sql = "UPDATE `laptrinhmang`.`muontrasach` SET `tenBD`='' WHERE `idBD`='hanh2';";
          PreparedStatement ps = cnn.prepareStatement(sql);
         ps.execute();
    }

    public  ArrayList<MuonTra> getAllMuontra(String ma) throws ClassNotFoundException, SQLException {
       ConectSql();
       ArrayList<MuonTra> list = new ArrayList<>();
       String sql = "SELECT * FROM laptrinhmang.muontrasach WHERE `idBD`=?;";
       PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1,ma);
        ResultSet rs = (ResultSet) ps.executeQuery();
        while(rs.next()){
          MuonTra mt = new MuonTra(rs.getString("idBD"),rs.getString("idSach"),rs.getString("tenBD"),rs.getString("tenSach"),
          rs.getString("loaiSach"),rs.getInt("soluong"),rs.getString("ngaymuon"),rs.getString("ngaytra"));
          list.add(mt);
        }
       return list;
    }
}
