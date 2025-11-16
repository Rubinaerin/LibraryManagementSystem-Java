package com.example.kutuphane.controller;

import com.example.kutuphane.entity.Book;
import com.example.kutuphane.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- BU SATIR ÇOK ÖNEMLİ
import org.springframework.web.bind.annotation.*; // <-- BU SATIR DA ÖNEMLİ

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Tüm kitapları listeleme sayfası (http://localhost:8083/books)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list"; // templates/books/list.html'i arar
    }

    // Yeni kitap ekleme formu sayfası
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/form";
    }

    // Yeni kitap kaydetme veya güncellemeyi işleme
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    // Kitap düzenleme formu sayfası
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        return "books/form";
    }

    // Kitap silme işlemi
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}