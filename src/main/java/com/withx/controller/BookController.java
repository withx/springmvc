package com.withx.controller;

import com.withx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("save")
    public String save() {
        System.out.println("book controller called.");
        bookService.save();

        return "{'code':'001','stat':'ok'}";
    }
}
