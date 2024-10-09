package com.example
import com.example.Member

class MemberController {

    def index() {
        def members = Member.list()
        [members: members]
    }

    def save() {
        def member = new Member(params)
        if (member.save()) {
            flash.message = "Anggota '${member.name} berhasil ditambahkan"
            redirect(action: 'index')
        } else {
            flash.message = "Gagal menambahkan anggota."
            render(view: 'create', model: [member: member])
        }
    }

    def delete(Long id) {
        def member = Member.get(id)
        if (member) {
            member.delete()
            flash.message = "Anggota '${member.name}' telah dihapus."
        } else {
            flash.message = "Anggota tidak ditemukan."
        } redirect(action: 'index')
    }
}