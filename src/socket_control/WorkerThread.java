/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_control;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.BanDoc;
import model.MuonTra;
import model.NhanVien;
import model.Sach;

/**
 *
 * @author nguye_000
 */
class WorkerThread extends Thread {
    
    private ObjectInputStream is;
    private ObjectOutputStream os;
    private  DataInputStream dataInput;
    private   DataOutputStream dataOut; 


    private Socket socket;
    private SachDAO sachDAO;
    private BanDocDAO bandocDAO;
    private NhanVienDAO nhanvienDAO;
    private MuonTraDAO muontraDAO;
    WorkerThread(Socket socket) {
        this.socket = socket;
        sachDAO = new SachDAO();
        bandocDAO = new BanDocDAO();
        nhanvienDAO = new NhanVienDAO();
        muontraDAO = new MuonTraDAO();
    }

    public void run(){
        System.out.println("processing:"+socket);
        try{
             is = new ObjectInputStream(socket.getInputStream());
            os = new ObjectOutputStream(socket.getOutputStream());
              dataInput = new DataInputStream(socket.getInputStream());
             dataOut = new DataOutputStream(socket.getOutputStream());
            Account acc = (Account) is.readObject();
            String userName = acc.getUsername();
            String password = acc.getPassword();
            System.out.println("1"+userName+password);
            ArrayList<Account> bdacc = bandocDAO.getAccountBD();
            int j=0;
            for (int i = 0; i < bdacc.size(); i++) {
                Account bd = bdacc.get(i);
                System.out.println("" + bd.getPassword());
                if (userName.equalsIgnoreCase(bd.getUsername()) && password.equalsIgnoreCase(bd.getPassword())) {
                    dataOut.writeInt(0);
                    BanDoc bdMuon = bandocDAO.getBanDocFromUserName(userName, password);
                    os.writeObject(bdMuon);
                    j=1;
                    break;
                    
                }
            }
            if(j!=1){
                 ArrayList<Account> nhanvien = nhanvienDAO.getAccountNV();
                for (int i = 0; i < nhanvien.size(); i++) {
                    Account bd = nhanvien.get(i);
                    System.out.println("" + bd.getPassword());
                    if (userName.equalsIgnoreCase(bd.getUsername()) && password.equalsIgnoreCase(bd.getPassword())) {
                        dataOut.writeInt(1);
                        j = 2;
                        break;
                    }
                }
            }
            if(j==0){
                dataOut.writeInt(2);
            }
           
           
            int choose = dataInput.readInt();
            switch(choose){
                case 1:{
                    xulyBandoc();
                    break;
                }
                case 2:{
                    xulyNhanVien();
                    break;
                }
                
            }
            
             is.close();
              os.close();
        }catch(IOException e){
            System.out.println("loi exception");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void xulyBandoc() throws IOException, ClassNotFoundException, SQLException {
       String tensach = dataInput.readUTF();
       String[] tachTen = tachXau(tensach);
       ArrayList<Sach> sach = sachDAO.getAllSach();
       ArrayList<Sach> sachGui = new ArrayList<>();
       for(int i=0; i< sach.size(); i++){
           Sach s1 = sach.get(i);
           String name = s1.getTenSach();
           for(int j=0; j< tachTen.length; j++){
              if(name.indexOf(tachTen[j])!=-1){
                  sachGui.add(s1);
              } 
           }
       }
       os.writeObject(sachGui);
       BanDoc bdMuon = (BanDoc) is.readObject();
       ArrayList<Sach> listSachMuon = (ArrayList<Sach>) is.readObject();
       String ngaybatdau = dataInput.readUTF();
       String ngaytra = dataInput.readUTF();
       if(bdMuon!=null && listSachMuon!=null && ngaybatdau!=null && ngaytra!=null){
       for(int i =0; i<listSachMuon.size(); i++){
           Sach sa = listSachMuon.get(i);
           MuonTra muonTra = new MuonTra(bdMuon.getId(), sa.getMaSach(), 
                   bdMuon.getTen(),sa.getTenSach(),sa.getTheLoai(),1, ngaybatdau, ngaytra);
           muontraDAO.insertMuonTra(muonTra);
           //sachDAO.updateSachSoluong(sa.getMaSach());
       } 
       dataOut.writeInt(1);
       }else{
           dataOut.writeInt(0);
       }   
       
    }
    private String[] tachXau(String xau){
        String[] chuoi = xau.split(" ");
        return chuoi;
    }
    private void xulyNhanVien() throws IOException, ClassNotFoundException, SQLException {
        String choose = dataInput.readUTF();
        while(choose!=null){
        switch(choose){
            case "insertsach":{
                Sach sach = (Sach) is.readObject();
                if(sach != null){
                   sachDAO.insertSach(sach);
                   dataOut.writeInt(1);
                }else dataOut.writeInt(0);   
            }
            case "updatesach":{
                String ma = dataInput.readUTF();
                Sach sach = sachDAO.getSachID(ma);
                if(sach!=null){
                    os.writeObject(sach);
                }
                else os.writeObject(null);
                Sach sachUpdate = (Sach) is.readObject();
                if(sachUpdate != null){
                    sachDAO.updateSach(sachUpdate);
                    dataOut.writeInt(1);
                }else dataOut.writeInt(0);
            }
            case "updatebandoc":{
                 String ma = dataInput.readUTF();
                BanDoc sach = bandocDAO.getBanDocID(ma);
                if(sach!=null){
                    os.writeObject(sach);
                }
                else os.writeObject(null);
                BanDoc sachUpdate = (BanDoc) is.readObject();
                if(sachUpdate != null){
                    bandocDAO.updateBanDoc(sachUpdate);
                    dataOut.writeInt(1);
                }else dataOut.writeInt(0);
            }
            case "insertbandoc":{
                 BanDoc sach = (BanDoc) is.readObject();
                if(sach != null){
                   bandocDAO.insertBanDoc(sach);
                   dataOut.writeInt(1);
                }else dataOut.writeInt(0);  
            }
            case "insertnhanvien":{
                 NhanVien sach = (NhanVien) is.readObject();
                if(sach != null){
                   nhanvienDAO.insertNhanVien(sach);
                   dataOut.writeInt(1);
                }else dataOut.writeInt(0); 
            }
            case "updatenhanvien":{
                  String ma = dataInput.readUTF();
                NhanVien sach = nhanvienDAO.getNhanVienID(ma);
                if(sach!=null){
                    os.writeObject(sach);
                }
                else os.writeObject(null);
                
                NhanVien sachUpdate = (NhanVien) is.readObject();
                if(sachUpdate != null){
                    nhanvienDAO.updateNhanVien(sachUpdate);
                    dataOut.writeInt(1);
                }else dataOut.writeInt(0);
            }
            case "xemnhanvien":{
                String tenNhanvien = dataInput.readUTF();
                String[] tachTen = tachXau(tenNhanvien);
                ArrayList<NhanVien> nv = nhanvienDAO.getAllNhanVien();
                ArrayList<NhanVien> nvGui = new ArrayList<>();
                for (int i = 0; i < nv.size(); i++) {
                    NhanVien s1 = nv.get(i);
                    String name = s1.getTen();
                    for (int j = 0; j < tachTen.length; j++) {
                        if (name.indexOf(tachTen[j]) != -1) {
                            nvGui.add(s1);
                        }
                    }
                }
                os.writeObject(nvGui);
            }
            case "xembandoc":{
                String tenBandoc = dataInput.readUTF();
                String[] tachTen = tachXau(tenBandoc);
                ArrayList<BanDoc> bd = bandocDAO.getAllBanDoc();
                ArrayList<BanDoc> bdGui = new ArrayList<>();
                for (int i = 0; i < bd.size(); i++) {
                    BanDoc s1 = bd.get(i);
                    String name = s1.getTen();
                    for (int j = 0; j < tachTen.length; j++) {
                        if (name.indexOf(tachTen[j]) != -1) {
                            bdGui.add(s1);
                        }
                    }
                }
                os.writeObject(bdGui);
            }
            case "xemsach":{
                String tenSach = dataInput.readUTF();
                String[] tachTen = tachXau(tenSach);
                ArrayList<Sach> bd = sachDAO.getAllSach();
                ArrayList<Sach> bdGui = new ArrayList<>();
                for (int i = 0; i < bd.size(); i++) {
                    Sach s1 = bd.get(i);
                    String name = s1.getTenSach();
                    for (int j = 0; j < tachTen.length; j++) {
                        if (name.indexOf(tachTen[j]) != -1) {
                            bdGui.add(s1);
                        }
                    }
                }
                os.writeObject(bdGui);
           
            }
            case "xemmuontra":{
                 String ma = dataInput.readUTF();
                 ArrayList<MuonTra>  bd = muontraDAO.getAllMuontra(ma);
                if(bd!=null){
                    os.writeObject(bd);
                }
                
            }
    }
    }
    }
 }

    

