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
 * @author nguye_000
 */
public class Person implements Serializable {
    private Account acount;
    private String id;
    private String ten;
    private String email;
    private String sdt;
    private String ngaysinh;

    public Person() {
    }

    public Person(String idNV, String tenNV, String emailNV, String sdt, String ngaysinh, Account account) {
        this.id = idNV;
        this.ten = tenNV;
        this.email = emailNV;
        this.sdt = sdt;
        this.ngaysinh = ngaysinh;
        this.acount = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String idNV) {
        this.id = idNV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String tenNV) {
        this.ten = tenNV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailNV) {
        this.email = emailNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }
    
}
