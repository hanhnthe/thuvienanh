/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class NhanVien extends Person {
    private String Vitri;
    private float Luong;

    public NhanVien(String idNV, String tenNV, String emailNV, String sdt, String ngaysinh, Account account) {
        super(idNV, tenNV, emailNV, sdt, ngaysinh, account);
        
    }
    public NhanVien(){
        super();
    }

    public String getVitri() {
        return Vitri;
    }

    public void setVitri(String Vitri) {
        this.Vitri = Vitri;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }
    
      
}
