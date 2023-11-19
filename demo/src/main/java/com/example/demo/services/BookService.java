package com.example.demo.services;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.models.request.BookRequest;
import com.example.demo.repositories.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> GetAllBooks(){
        List<Book> books = bookRepository.findAll();
        return books;
    }

    public Book getBook(Long id){
        Book book = bookRepository.getBookById(id);
        return book;
    }

    public Book CreateBook(BookRequest req){
        Book newBook = new Book();
        newBook.setAuthor(req.getAuthor());
        newBook.setTitle(req.getTitle());
        newBook.setCreatedAt(OffsetDateTime.now());
        newBook.setUpdatedAt(OffsetDateTime.now());
        Book res = bookRepository.save(newBook);
        return res;
    }

    public Book UpdateBook(BookRequest book, Long id){
        Book updatedBook = bookRepository.getBookById(id);
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setUpdatedAt(OffsetDateTime.now());
        bookRepository.save(updatedBook);
        return updatedBook;
    }
}
