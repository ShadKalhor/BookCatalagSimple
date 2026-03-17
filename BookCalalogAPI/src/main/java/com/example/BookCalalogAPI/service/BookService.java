package com.example.BookCalalogAPI.service;

import com.example.BookCalalogAPI.entity.Book;
import com.example.BookCalalogAPI.exception.ErrorType;
import com.example.BookCalalogAPI.exception.StructuredError;
import com.example.BookCalalogAPI.repository.BookRepositoryJPA;
import io.vavr.control.Either;
import io.vavr.control.Try;
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


    public Either<StructuredError, Void> save(Book book) {
        return Try.run(() -> bookRepo.save(book)).toEither()
                .mapLeft(throwable ->
                        new StructuredError("Could not Save Entity Book",
                                ErrorType.SERVER_ERROR));
    }
}
