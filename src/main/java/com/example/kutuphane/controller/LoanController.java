package com.example.kutuphane.controller;

import com.example.kutuphane.entity.Loan;
import com.example.kutuphane.service.BookService;
import com.example.kutuphane.service.LoanService;
import com.example.kutuphane.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loans")
public class LoanController {

    // Servisleri enjekte edin
    @Autowired
    private LoanService loanService;
    
    @Autowired
    private BookService bookService; 

    @Autowired
    private MemberService memberService; 

    // Aktif (iade edilmemiş) ödünç kayıtlarını gösteren sayfa
    @GetMapping
    public String listActiveLoans(Model model) {
        model.addAttribute("loans", loanService.findActiveLoans());
        return "loans/list";
    }

    // Yeni ödünç alma formu sayfası
    @GetMapping("/new")
    public String showLoanForm(Model model) {
        // Form için gerekli tüm verileri yüklüyoruz
        model.addAttribute("loan", new Loan());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("members", memberService.findAll());
        return "loans/form"; // <--- Bu şablonu arar
    }

    // Yeni ödünç alma işlemini kaydetme
    @PostMapping
    public String saveLoan(@RequestParam("bookId") Long bookId, 
                           @RequestParam("memberId") Long memberId) {
        
        loanService.loanBook(bookId, memberId);
        return "redirect:/loans";
    }

    // İade işlemi
    @GetMapping("/return/{loanId}")
    public String returnBook(@PathVariable Long loanId) {
        loanService.returnBook(loanId);
        return "redirect:/loans";
    }
}