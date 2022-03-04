package com.example.springbook.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springbook.domain.model.Book;
import com.example.springbook.domain.repository.bookRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;


@Service
public class bookService implements bookRepository{
    private static List<Book> bookList = new ArrayList<Book>();

    static {
        bookList.addAll(List.of(new Book("00000000000","hp","a","b",5) ,new Book("00000000001","lv","a","b",5) ,new Book("00000000002","bb","a","b",5)));

    }
    

    public List<String> listAll(){

        return (bookList.stream().map(b -> b.getName()).collect(Collectors.toList()));
    }

    @ResponseBody
    public Book findBySbn(String sbn){

        return bookList.stream()
        .filter(book -> book.getSbn().equals(sbn)) 
        .findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Book SBN not found."));
    }

    @Override
    public Book save(Book book) {
        // book.setId(ThreadLocalRandom.current().nextLong(3,10000));  
        if(book.getSbn().matches("[0-9]+")){   
        bookList.add(book);

        }
        else{
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST ,"Book SBN invalid.");

        }

        return book;
    }

    @Override
    public Book update(Book book) {

        delete(book.getSbn());
        save(book);

        return book;
    }

    @Override
    public Book delete(String sbn) {

        Book book = findBySbn(sbn);

        try {
            bookList.remove(book);
                
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST ," Invalid book.");
            }

        return book ;
    }

}
