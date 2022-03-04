package com.example.springbook.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    
    // private long id ;
    private String sbn ;
    private String name ;
    private String sumary ;
    private String author ;
    private int inStock ;

}