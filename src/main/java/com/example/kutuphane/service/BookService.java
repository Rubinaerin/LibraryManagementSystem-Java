package com.example.kutuphane.service;

import com.example.kutuphane.entity.Book;
import com.example.kutuphane.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Tüm kitapları getir
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    // ID ile kitap getir
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    // Yeni kitap kaydet veya mevcut kitabı güncelle
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // ID ile kitap sil
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}