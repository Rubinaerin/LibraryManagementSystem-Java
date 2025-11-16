package com.example.kutuphane.service;

import com.example.kutuphane.entity.Book;
import com.example.kutuphane.entity.Loan;
import com.example.kutuphane.entity.Member;
import com.example.kutuphane.repository.BookRepository;
import com.example.kutuphane.repository.LoanRepository;
import com.example.kutuphane.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    // Sadece iade edilmemiş (aktif) ödünç alma kayıtlarını getirir.
    public List<Loan> findActiveLoans() {
        return loanRepository.findByReturnDateIsNull();
    }

    // Yeni ödünç alma işlemi
    public Loan loanBook(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Kitap bulunamadı: " + bookId));
        
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Üye bulunamadı: " + memberId));

        // 1. İş Kuralı: Stok Kontrolü
        if (book.getStockCount() <= 0) {
            throw new IllegalStateException("Stokta yeterli kitap yok: " + book.getTitle());
        }

        // 2. İşlemi Kaydetme
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setLoanDate(LocalDate.now());

        // 3. Stok Güncelleme
        book.setStockCount(book.getStockCount() - 1);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }

    // Kitap iade işlemi
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Ödünç kaydı bulunamadı: " + loanId));

        if (loan.getReturnDate() != null) {
            throw new IllegalStateException("Bu kitap zaten iade edilmiş.");
        }

        // 1. İade Tarihini Güncelleme
        loan.setReturnDate(LocalDate.now());
        Loan updatedLoan = loanRepository.save(loan);

        // 2. Stok Güncelleme
        Book book = updatedLoan.getBook();
        book.setStockCount(book.getStockCount() + 1);
        bookRepository.save(book);

        return updatedLoan;
    }
}