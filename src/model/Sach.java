/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author nguye_000
 */
public class Sach implements Serializable{
    private String idSach;
    private String tenSach;
    private String nxbSach;
    private String tenTg;
    private String loaiSach;
    private int soluong;
    private float gia;

    public Sach(String idSach, String tenSach, String tenTg , String nxbSach, String loaiSach, int soluong, float gia) {
        this.idSach = idSach;
        this.tenSach = tenSach;
        this.nxbSach = nxbSach;
        this.tenTg = tenTg;
        this.loaiSach = loaiSach;
        this.soluong = soluong;
        this.gia = gia;
    }

    public Sach() {
    }
    

    public String getMaSach() {
        return idSach;
    }

    public void setMaSach(String idSach) {
        this.idSach = idSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return nxbSach;
    }

    public void setNhaXuatBan(String nxbSach) {
        this.nxbSach = nxbSach;
    }

    public String getTacGia() {
        return tenTg;
    }

    public void setTacGia(String tenTg) {
        this.tenTg = tenTg;
    }

    public String getTheLoai() {
        return loaiSach;
    }

    public void setTheLoai(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
    
}
