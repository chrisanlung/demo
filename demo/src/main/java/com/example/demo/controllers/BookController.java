package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.models.request.BookRequest;
import com.example.demo.services.BookService;



// @Api(value = "CRUD Rest APIs for Post resources")
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> GetAllBooks(){
        List<Book> books = bookService.GetAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/get-book")
    public ResponseEntity<Book> GetBook(@RequestParam(value = "id" , required = true ) Long id){
        Book res = bookService.getBook(id);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/create-book")
    public ResponseEntity<Book> CreateBook(@RequestBody BookRequest book){
        Book res = bookService.CreateBook(book);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/update-book")
    public ResponseEntity<Book> UpdateBook(@RequestParam Long id, @RequestBody BookRequest book){
        Book res = bookService.UpdateBook(book, id);
        return ResponseEntity.ok().body(res);
    }
}
