package com.example
import com.example.Borrow

class BorrowController {

    def index() {
        def borrows = Borrow.list()
        [borrows: borrows]
    }

    def save() {
        def book = Book.get(params.book.id)
        if (!book?.isAvailable) {
            flash.message = "Buku tidak tersedia untuk dipinjam."
            redirect(action: 'index')
            return
        }

        def borrow = new Borrow(params)
        borrow.dueDate = new Date() + 14 //peminjaman selama 14 hari
        if (borrow.save()) {
            book.isAvailable = false //Tandai buku tidak tersedia
            book.save(flush: true)
            flash.message = "Buku '${book.title}' berhasil dipinjam oleh '${borrow.member.name}"
            redirect(action: 'index')
        } else {
            flash.message = "Gagal meminjam buku."
            render(view: 'create', modal: [borrow: borrow])
        }
    }

    def returnBook(Long id) {
        def borrow = Borrow.get(id)
        if (!borrow) {
            flash.message = "Peminjaman telah ditemukan."
            redirect(action: 'index')
            return
        }

        borrow.returnDate = new Date()
        borrow.book.isAvailable = true
        borrow.book.save(flush: true)
        borrow.save(flush: true)

        flash.message = "Buku '${borrow.book.title}' berhasil dikembalikan oleh '${borrow.member.name}'"
        redirect(action: 'index')
    }
}