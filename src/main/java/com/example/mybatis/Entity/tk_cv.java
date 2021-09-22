package com.example.mybatis.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class tk_cv {
    private int id;
    private int idtk;
    private int idcv;

    public tk_cv(int idtk, int idcv) {
        this.idtk = idtk;
        this.idcv = idcv;
    }
}
