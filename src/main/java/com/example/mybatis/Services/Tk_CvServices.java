package com.example.mybatis.Services;

import com.example.mybatis.Config.SessionFact;
import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Entity.tk_cv;
import com.example.mybatis.Mapper.ChucVuMapper;
import com.example.mybatis.Mapper.Tk_CvMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Tk_CvServices {

    public List<tk_cv> selectAll() {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        Tk_CvMapper tk_cvMapper = session.getMapper(Tk_CvMapper.class);
        // show list student
        List<tk_cv> lstrole = tk_cvMapper.selectAll();
        session.close();
        return  lstrole;
    }

    public void insert(tk_cv tkcv) {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        Tk_CvMapper tk_cvMapper = session.getMapper(Tk_CvMapper.class);
        // show list student
        tk_cvMapper.insert(tkcv);
        session.commit();
        session.close();
    }

    public void DeleteByIDTK(int idtk) {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        Tk_CvMapper tk_cvMapper = session.getMapper(Tk_CvMapper.class);
        tk_cvMapper.DeleteByIDTK(idtk);
        session.commit();
        session.close();
    }
}
