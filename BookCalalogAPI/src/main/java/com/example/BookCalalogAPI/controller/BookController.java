package com.example.BookCalalogAPI.controller;

import com.example.BookCalalogAPI.entity.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(){

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks(){
        return null;
    }

}
