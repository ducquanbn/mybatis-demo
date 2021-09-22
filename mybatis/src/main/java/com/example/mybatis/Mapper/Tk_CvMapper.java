package com.example.mybatis.Mapper;

import com.example.mybatis.Entity.tk_cv;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Tk_CvMapper {
    List<tk_cv> selectAll();
    void insert(tk_cv tkcv);
    void DeleteByIDTK(int idtk);
}
