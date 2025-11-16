package com.example.kutuphane.repository;

import com.example.kutuphane.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Sadece iade edilmemiş kayıtları bulmak için özel bir metot ekleyelim:
    List<Loan> findByReturnDateIsNull();

    // Bir kitabın iade edilip edilmediğini kontrol etmek için
    boolean existsByBookIdAndReturnDateIsNull(Long bookId);
}