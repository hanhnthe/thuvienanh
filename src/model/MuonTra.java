/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class MuonTra implements Serializable{
    private String idBD,idSach,tenBD,tenSach;
    private String loaiSach,ngaymuon,ngaytra;
    private int soluong;

    public MuonTra(String idBD, String idSach, String tenBD, String tenSach, String loaiSach, int soluong, String ngaymuon, String ngaytra) {
        this.idBD = idBD;
        this.idSach = idSach;
        this.tenBD = tenBD;
        this.tenSach = tenSach;
        this.loaiSach = loaiSach;
        this.soluong = soluong;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
    }

    public String getIdBD() {
        return idBD;
    }

    public void setIdBD(String idBD) {
        this.idBD = idBD;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public String getTenBD() {
        return tenBD;
    }

    public void setTenBD(String tenBD) {
        this.tenBD = tenBD;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getLoaiSach() {
        return loaiSach;
    }

    public void setLoaiSach(String loaiSach) {
        this.loaiSach = loaiSach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    
    
}
