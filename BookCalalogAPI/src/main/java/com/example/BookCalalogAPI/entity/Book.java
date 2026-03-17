package com.example.BookCalalogAPI.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    private UUID id;

    private String title;
    private String author;
    private BigDecimal price;
    @JoinColumn(name = "published_year")
    private int publishedYear;


    @PrePersist
    public void prePersist() {if (id == null) id = UUID.randomUUID();}

}
