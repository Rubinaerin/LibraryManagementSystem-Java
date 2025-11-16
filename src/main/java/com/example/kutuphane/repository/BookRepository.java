package com.example.kutuphane.repository;

import com.example.kutuphane.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Kitaplar için CRUD (Oluşturma, Okuma, Güncelleme, Silme) operasyonlarını sağlar.
}