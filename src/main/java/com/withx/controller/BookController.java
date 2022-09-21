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
    public String save(@RequestBody BookVO book) {
        System.out.println("book controller called.");
        bookService.save(book);

        return "{'code':'001','stat':'save ok'}";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("book controller delete ...");
        bookService.delete(id);
        return "{'code':'001','stat':'delete ok'}";
    }

    @PutMapping
    public String update(@RequestBody BookVO book) {
        System.out.println("book controller update ...");
        bookService.update(book);
        return "{'code':'001','stat':'update ok'}";
    }

    @GetMapping
    public List<BookVO> findAll() {
        System.out.println("book controller findAll ...");
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookVO findById(@PathVariable Integer id) {
        System.out.println("book controller findById ...");
        return bookService.findById(id);
    }
}
