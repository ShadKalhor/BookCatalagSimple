package com.example.BookCalalogAPI.service;

import com.example.BookCalalogAPI.entity.Book;
import com.example.BookCalalogAPI.repository.BookRepositoryJPA;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepositoryJPA bookRepo;

    public BookService(BookRepositoryJPA bookRepo){
        this.bookRepo = bookRepo;
    }

    public Page<Book> findAll(Pageable pageable){
        return bookRepo.findAll(pageable);
    }



}
