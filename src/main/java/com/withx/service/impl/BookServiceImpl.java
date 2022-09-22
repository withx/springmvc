package com.withx.service.impl;

import com.withx.controller.Code;
import com.withx.dao.BookDao;
import com.withx.domain.BookVO;
import com.withx.exception.BusinessException;
import com.withx.exception.SystemException;
import com.withx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public boolean save(BookVO book) {
        System.out.println("book service save ...");
        return bookDao.save(book) > 0;
    }

    public boolean delete(Integer id) {
        System.out.println("book service delete ...");
        return bookDao.delete(id) > 0;
    }

    public boolean update(BookVO book) {
        System.out.println("book service update ...");
        return bookDao.update(book) > 0;
    }

    public List<BookVO> findAll() {
        System.out.println("book service findAll ...");
        return bookDao.findAll();
    }

    public BookVO findById(Integer id) {
        System.out.println("book service findById ...");

        if(id == 1){
            throw new BusinessException(Code.BUSINESS_ERR,"접근이 제한된 ID입니다 !");
        }

        try{
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_TIMEOUT_ERR,"시스템 장애, 운영팀에 문의하세요!",e);
        }
        return bookDao.findById(id);
    }
}
