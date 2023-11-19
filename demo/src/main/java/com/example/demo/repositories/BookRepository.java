package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    public List<Book> findAll();
    public Book getBookById(Long id);
}
