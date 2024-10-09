package com.example

class Book {
    String title
    String author
    String isbn
    Boolean isAvailable = true

    static constraints = {
        title blank: false, size: 1..100
        author blank: false, size: 1..100
        isbn blank: false, unique: true, size: 10..13
    }
}