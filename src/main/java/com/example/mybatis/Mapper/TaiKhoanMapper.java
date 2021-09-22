package com.example.mybatis.Mapper;

import com.example.mybatis.Config.SessionFact;
import com.example.mybatis.Entity.taikhoan;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiKhoanMapper {
    List<taikhoan> selectAll();
    taikhoan selectById(int id);
    void insert(taikhoan tk);
    taikhoan selectByUserName(String username);
    void deleteById(int idtk);
    List<taikhoan> selectTKCVByIdTK(int idtk);
}
