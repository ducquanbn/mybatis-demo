package com.example.mybatis.Controller;

import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Entity.taikhoan;
import com.example.mybatis.Entity.tk_cv;
import com.example.mybatis.Services.ChucVuServices;
import com.example.mybatis.Services.TaiKhoanServices;
import com.example.mybatis.Services.Tk_CvServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    ChucVuServices chucVuServices;
    @Autowired
    TaiKhoanServices taiKhoanServices;
    @Autowired
    Tk_CvServices tk_cvServices;
    @GetMapping
    public String admin(Model md){
        List<chucvu> lstCV = chucVuServices.selectAll();
        List<taikhoan> lst = taiKhoanServices.selectAll();
        md.addAttribute("lst", lst);
        md.addAttribute("lstCV", lstCV);
        return "admin";
    }

    @PostMapping("/insert")
    public @ResponseBody Boolean insertTK(
                                    @RequestParam("user") String user,
                                    @RequestParam("pass") String pass,
                                    @RequestParam("idcv") int idcv ){
        String passEC = BCrypt.hashpw(pass,BCrypt.gensalt(10));
        if(taiKhoanServices.insert(new taikhoan(user,passEC))){
            taikhoan tk = taiKhoanServices.selectByUserName(user);
            tk_cvServices.insert(new tk_cv(tk.getIdtk(), idcv));
        }else
            return false;
        return true;
    }

    @DeleteMapping("/del/{idtk}")
    public @ResponseBody Boolean delTK(@PathVariable("idtk") int idtk){
        tk_cvServices.DeleteByIDTK(idtk);
        taiKhoanServices.deleteTK(idtk);
        return true;
    }

    @GetMapping("/info/{idtk}")
    public String info(@PathVariable("idtk") int idtk, Model md){
        taikhoan tk = taiKhoanServices.selectById(idtk);
        
        md.addAttribute("tk", tk);
        List<chucvu> lstCV = chucVuServices.selectAll();
        md.addAttribute("lstCV", lstCV);
        return "inforTK";
    }
}
