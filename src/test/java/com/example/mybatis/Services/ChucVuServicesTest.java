package com.example.mybatis.Services;

import com.example.mybatis.Entity.chucvu;
import com.example.mybatis.Mapper.ChucVuMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ChucVuServicesTest {

    @Autowired
    private ChucVuServices chucVuServices;
    @MockBean
    private ChucVuMapper chucVuMapper;


    @Test
    void selectAll() {
        Mockito.when(chucVuMapper.selectAll()).thenReturn(Stream.of(new chucvu("Quan Tri"), new chucvu("Khach"))
                .collect(Collectors.toList()));
        assertEquals(2,chucVuServices.selectAll().size());
    }

    @Test
    void selectById() {

    }

    @Test
    void insert() {
        chucvu cv = new chucvu("admin");
        
    }

    @Test
    void showCV() {

    }
}