package com.example.mybatis.Services;

import com.example.mybatis.Config.SessionFact;
import com.example.mybatis.Entity.taikhoan;
import com.example.mybatis.Mapper.TaiKhoanMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaiKhoanServices {

    public List<taikhoan> selectAll(){
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);

        List<taikhoan> lstTK = taiKhoanMapper.selectAll();
        session.close();
        return  lstTK;
    }

    public taikhoan selectById(int id) {
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);

        taikhoan TK = taiKhoanMapper.selectById(id);
        session.close();
        return  TK;
    }

    public boolean insert(taikhoan tk) {
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);
        taikhoan newTK = new taikhoan(tk.getUsername(), tk.getPass());
        try{
            taiKhoanMapper.insert(newTK);
            session.commit();
        }catch (Exception e){
            System.out.println("Can't insert : "+ e);
            return false;
        }
        session.close();
        return true;
    }

    public taikhoan selectByUserName(String username) {
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);

        taikhoan TK = taiKhoanMapper.selectByUserName(username);
        session.close();
        return  TK;
    }
    public void deleteTK(int idtk){
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);
        taiKhoanMapper.deleteById(idtk);
        session.commit();
        session.close();
    }

    public List<taikhoan> selectTKCVByIdTK(int idtk){
        SqlSession session = SessionFact.getSessionFactory().openSession();

        TaiKhoanMapper taiKhoanMapper = session.getMapper(TaiKhoanMapper.class);

        List<taikhoan> lstTK = taiKhoanMapper.selectTKCVByIdTK(idtk);
        session.close();
        return  lstTK;
    }
}
