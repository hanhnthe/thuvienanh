/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;
import model.Sach;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Administrator
 */
public class SachDAO {
    public java.sql.Connection cnn;
     public SachDAO(){  
     } 
    public void ConectSql() throws ClassNotFoundException, SQLException{
      String DB_URL = "jdbc:mysql://localhost/laptrinhmang";
      String USER = "root";
      String PASSWORD = "261098";
      Class.forName("com.mysql.cj.jdbc.Driver");
      cnn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
      Statement state = cnn.createStatement(); 
    }
    
    public Sach getSachID(String id) throws ClassNotFoundException, SQLException{
        ConectSql();
        String sql = "SELECT * FROM laptrinhmang.sach WHERE `idSach`=?;";
        Sach sach = null;
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            sach = new Sach(rs.getString("idSach"),rs.getString("tenSach"),rs.getString("tenTg"),rs.getString("nxbSach"),rs.getString("loaiSach"),rs.getInt("soluong"),rs.getFloat("gia"));
        }
        return sach;
    }
  
    public ArrayList<Sach> getAllSach() throws ClassNotFoundException, SQLException {
        ConectSql();
        ArrayList<Sach> list = new ArrayList();
        String sql = "SELECT * FROM laptrinhmang.sach";
        try {
            ResultSet rs = (ResultSet) cnn.prepareStatement(sql).executeQuery() ;
            while (rs.next()) {
                String idSach = rs.getString("idSach");
                String tenSach= rs.getString("tenSach");
                String tenTg = rs.getString("tenTg");
                String loaiSach = rs.getString("loaiSach");
                float gia = rs.getFloat("gia");
                int soluong = rs.getInt("soluong");
                String nxbSach = rs.getString("nxbSach");
                Sach s = new Sach(idSach, tenSach, tenTg, nxbSach, loaiSach, soluong, gia);
                list.add(s);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllProduct index.jsp inSanPhamDAO ");
        }
        cnn.close();
        return list;
    }
     public void insertSach(Sach bd) throws SQLException, ClassNotFoundException{
        ConectSql();
        String sql = "INSERT INTO `laptrinhmang`.`sach`(`idSach`,`tenSach`,`tenTg`,`loaiSach`,`gia`,`soluong`,`nxbSach`) VALUES(?,?,?,?,?,?,?);";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getMaSach());
        ps.setString(2, bd.getTenSach());
        ps.setString(3, bd.getTacGia());
        ps.setString(4, bd.getTheLoai());
        ps.setFloat(5, bd.getGia());
        ps.setInt(6, bd.getSoluong());
        ps.setString(7,bd.getNhaXuatBan());
        ps.execute();
    }
    public void updateSach(Sach bd)throws ClassNotFoundException, SQLException{
         ConectSql();
         String sql = "UPDATE `laptrinhmang`.`sach` SET `tenSach`=?,`tenTg`=?,`loaiSach`=?,`gia`=?,`soluong`=?,`nxbSach`=? WHERE `idSach`=?;";
         PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, bd.getTenSach());
        ps.setString(2, bd.getTacGia());
        ps.setString(3, bd.getTheLoai());
        ps.setFloat(4, bd.getGia());
        ps.setInt(5, bd.getSoluong());
        ps.setString(6,bd.getNhaXuatBan());
        ps.setString(7, bd.getMaSach());
        ps.execute();
    }
    public void updateSachSoluong(String id) throws ClassNotFoundException, SQLException{
        ConectSql();
         String sql = "UPDATE `laptrinhmang`.`sach` SET `soluong`=? WHERE `idSach`=?;";
         PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setInt(1,getSoluong(id)-1);
        ps.setString(2, id);
        ps.execute();
    }
    public int getSoluong(String id) throws ClassNotFoundException, SQLException{
        ConectSql();
        int i;
        String sql = "SELECT sach.soluong FROM laptrinhmang.sach WHERE `idSach`=?;";
        PreparedStatement ps = cnn.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet re = ps.executeQuery();
        i= re.getInt("soluong");
        return i;
    }
    
}
