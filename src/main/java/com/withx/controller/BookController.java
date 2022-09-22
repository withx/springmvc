package com.withx.controller;

import com.withx.domain.BookVO;
import com.withx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody BookVO book) {
        System.out.println("book controller called.");

        boolean flag = bookService.save(book);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        System.out.println("book controller delete ...");
        boolean flag = bookService.delete(id);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @PutMapping
    public Result update(@RequestBody BookVO book) {
        System.out.println("book controller update ...");
        boolean flag = bookService.update(book);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @GetMapping
    public List<BookVO> findAll() {
        System.out.println("book controller findAll ...");
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        BookVO book = bookService.findById(id);
        System.out.println("book controller findById ...");
        String code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "" : "검색된 데이터가 없습니다！";
        return new Result(code,book,msg);
    }
}
