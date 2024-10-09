package com.example

import com.example.Book
import com.example.Member

class Borrow {
    Book book
    Member member
    Date dateBorrowed = new Date()
    Date dueDate
    Date returnDate

    static constraints = {
        returnDate nullable: true
        dueDate nullable: false
    }

    static belongsTo = [member: Member, book: Book]
}