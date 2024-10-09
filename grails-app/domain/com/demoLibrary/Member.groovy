package com.example

import com.example.Borrow

class Member {
    String name
    String email
    Date dateJoined = new Date()

    static hasMany = [borrowedBooks: Borrow]

    static constraints = {
        name blank: false, size: 1..50
        email email: true, blank: false
    }
}