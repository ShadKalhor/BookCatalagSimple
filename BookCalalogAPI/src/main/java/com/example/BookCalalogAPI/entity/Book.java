package com.example.BookCalalogAPI.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    private UUID id;

    private String title;
    private String author;
    private BigDecimal price;
    private String publishedYear;

}
