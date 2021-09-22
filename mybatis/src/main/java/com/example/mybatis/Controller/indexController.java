package com.example.mybatis.Controller;

import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Entity.taikhoan;
import com.example.mybatis.Entity.tk_cv;
import com.example.mybatis.Mapper.TaiKhoanMapper;
import com.example.mybatis.Services.ChucVuServices;
import com.example.mybatis.Services.TaiKhoanServices;
import com.example.mybatis.Services.Tk_CvServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
public class indexController {

    @Autowired
    TaiKhoanServices taiKhoanServices;
    @Autowired
    ChucVuServices chucVuServices;
    @Autowired
    Tk_CvServices tk_cvServices;
    @GetMapping
    public List<taikhoan> index() {
        List<taikhoan> tk = taiKhoanServices.selectTKCVByIdTK(14);
        return tk;
    }

}
