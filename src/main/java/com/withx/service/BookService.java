package com.withx.service;

import com.withx.domain.BookVO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface BookService {
    boolean save(BookVO book);
    boolean delete(Integer id);
    boolean update(BookVO book);
    List<BookVO> findAll();
    BookVO findById(Integer id);
}
