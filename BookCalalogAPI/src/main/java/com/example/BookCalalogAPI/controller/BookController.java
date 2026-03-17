package com.example.BookCalalogAPI.controller;

import com.example.BookCalalogAPI.entity.Book;
import com.example.BookCalalogAPI.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postBook(@RequestBody Book book){

        bookService.save(book);

    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<Book> getAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size,
            @RequestParam(defaultValue = "0") String sortBy,
            @RequestParam(defaultValue = "0") boolean ascending
    ){
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return bookService.findAll(pageable);
    }

}
