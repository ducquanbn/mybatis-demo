package com.example.mybatis.Entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class chucvu {
    private int idcv;
    private String tencv;
    public chucvu( String tencv) {
        this.tencv = tencv;
    }
}
