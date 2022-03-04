package com.example.springbook.domain.controller;

import java.util.List;

import com.example.springbook.domain.model.Book;
import com.example.springbook.domain.service.bookService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/bookshelfs")
public class bookController {
    private static bookService bookS;

    static {
        bookS = new bookService();
    }

    // localhost:8080/bookshelfs/list
    @GetMapping("/list")
    public ResponseEntity<List<String>> list() {

        return ResponseEntity.ok(bookS.listAll());
    }

    // localhost:8080/bookshelfs/book{sbn}
    @GetMapping("/book{sbn}")
    public ResponseEntity<Book> findById(@RequestParam String sbn) {

        return ResponseEntity.ok(bookS.findBySbn(sbn));
    }

    @PostMapping("/book")
    // @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {

        return bookS.save(book);
    }

    @PutMapping("/book")
    public Book update(@RequestBody Book book) {

        return bookS.update(book);
    }

    @DeleteMapping("/book{sbn}")
    public ResponseEntity<Book> delete(@RequestParam String sbn) {

        return ResponseEntity.ok(bookS.delete(sbn));
    }

}
