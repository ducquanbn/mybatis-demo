package com.example.mybatis.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TaiKhoanDetails implements UserDetails {
    private taikhoan tk;
    private List<chucvu> list ;
    public TaiKhoanDetails(taikhoan tk, List<chucvu> list) {
        this.tk = tk;
        this.list = list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return list.stream()
                .map(authority -> new SimpleGrantedAuthority("ROLE_"+authority.getTencv().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return tk.getPass();
    }

    @Override
    public String getUsername() {
        return tk.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
