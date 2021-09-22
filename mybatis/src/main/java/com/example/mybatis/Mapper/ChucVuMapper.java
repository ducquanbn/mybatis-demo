package com.example.mybatis.Mapper;

import com.example.mybatis.Entity.chucvu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChucVuMapper {
    List<chucvu> selectAll();
    chucvu selectById(int id);
    void insert(chucvu cv);
    List<chucvu> showCV(int idtk);
}
