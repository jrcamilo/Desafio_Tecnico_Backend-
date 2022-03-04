package com.example.springbook.domain.repository;

import java.util.List;
import com.example.springbook.domain.model.Book;

public interface bookRepository {

    List<Book> listAll();
    Book findBySbn(String sbn);
    Book save(Book book) ;
    Book update(Book book) ;
    Book delete(String sbn);
    
}
