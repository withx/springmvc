package com.withx.service;

import com.withx.domain.BookVO;

import java.util.List;

public interface BookService {
    void save(BookVO book);
    void delete(Integer id);
    void update(BookVO book);
    List<BookVO> findAll();
    BookVO findById(Integer id);
}
