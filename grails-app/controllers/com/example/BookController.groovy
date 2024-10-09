package com.example

import com.example.Book

class BookController {

    def index() {
        def books = Book.list()
        [books: books]
    }

    def save() {
        def book = new Book(params)
        if (book.save()) {
            flash.message = "uku '${book.title}' berhasil ditambahkan."
            redirect(action: 'index')
        } else {
            flash.message = "Gagal menambahkan buku"
            render(view: 'create', model: [book: book])
        }
    }

    def delete (Long id) {
        def book = Book.get(id)
        if (book) {
            book.delete()
            flash.message = "Buku '${book.title}' telah dihapus."
            redirect(action: 'index')
        } else {
            flash.message = "Buku tidak ditemukan"
        }
        redirect(action: 'index')
    }

    def update(Long id) {
        def book = Book.get(id)
        if (!book) {
            flash.message = "Buku tidak ditemukan"
            redirect(action: 'index')
            return
        }
        book.properties = params
        if (book.save()) {
            flash.message = "Buku '${book.title} telah diperbarui"
            redirect(action: 'index')
        } else {
            render(view: 'edit', model: [book: book])
        }
    }
}