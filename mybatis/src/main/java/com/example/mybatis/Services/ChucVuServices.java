package com.example.mybatis.Services;

import com.example.mybatis.Config.SessionFact;
import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Entity.taikhoan;
import com.example.mybatis.Mapper.ChucVuMapper;
import com.example.mybatis.Mapper.TaiKhoanMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServices  {

    public List<chucvu> selectAll() {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        ChucVuMapper chucVuMapper = session.getMapper(ChucVuMapper.class);
        // show list student
        List<chucvu> lstCV = chucVuMapper.selectAll();
        session.close();
        return  lstCV;
    }

    public chucvu selectById(int id) {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        ChucVuMapper chucVuMapper = session.getMapper(ChucVuMapper.class);
        // show list student
        chucvu CV = chucVuMapper.selectById(id);
        session.close();
        return  CV;
    }

    public void insert(chucvu cv) {
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        ChucVuMapper chucVuMapper = session.getMapper(ChucVuMapper.class);
        // show list student
        chucVuMapper.insert(cv);
        session.commit();
        session.close();
    }

    public List<chucvu> showCV (int idtk){
        SqlSession session = SessionFact.getSessionFactory().openSession();
        // create student mapper
        ChucVuMapper chucVuMapper = session.getMapper(ChucVuMapper.class);
        // show list student
        List<chucvu> lstCV = chucVuMapper.showCV(idtk);
        session.close();
        return  lstCV;
    }
}
