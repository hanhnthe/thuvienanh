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
public class BanDoc extends Person {

    public BanDoc() {
        super();
    }

    public BanDoc(String idBD, String tenBD, String email, String sdt, String ngaysinh, Account account) {
       super(idBD, tenBD, email, sdt, ngaysinh,account);
    } 
}
