package com.example.mybatis.Services;

import com.example.mybatis.Entity.TaiKhoanDetails;
import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Entity.taikhoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userDetailsService")
public class TaiKhoanDetailsServices implements UserDetailsService {
    @Autowired
    TaiKhoanServices taiKhoanServices;
    @Autowired
    ChucVuServices chucVuServices;
    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        taikhoan tk = taiKhoanServices.selectByUserName(username);
        if (tk == null){
            throw new UsernameNotFoundException("User not found");
        }
        List<chucvu> lstCV = chucVuServices.showCV(tk.getIdtk());
        return new TaiKhoanDetails(tk, lstCV);
    }
}
