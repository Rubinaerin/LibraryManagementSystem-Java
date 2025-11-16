package com.example.kutuphane.repository;

import com.example.kutuphane.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Member sınıfı ve anahtar türü (Long) için CRUD metodlarını otomatik sağlar.
public interface MemberRepository extends JpaRepository<Member, Long> {
}