package com.example.mybatis.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class taikhoan {
    private int idtk;
    private String username;
    private String pass;
    private List<chucvu> lstcv;

    public taikhoan(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
}
