package com.withx.service.impl;

import com.withx.dao.BookDao;
import com.withx.domain.BookVO;
import com.withx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    public void save(BookVO book) {
        System.out.println("book service save ...");
        bookDao.save(book);
    }

    public void delete(Integer id) {
        System.out.println("book service delete ...");
        bookDao.delete(id);
    }

    public void update(BookVO book) {
        System.out.println("book service update ...");
        bookDao.update(book);
    }

    public List<BookVO> findAll() {
        System.out.println("book service findAll ...");
        return bookDao.findAll();
    }

    public BookVO findById(Integer id) {
        System.out.println("book service findById ...");
        return bookDao.findById(id);
    }
}
