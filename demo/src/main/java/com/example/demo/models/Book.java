package com.example.demo.models;

import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    OffsetDateTime createdAt;

    OffsetDateTime updatedAt;

    OffsetDateTime deletedAt;

    String title;

    String Author;

}
