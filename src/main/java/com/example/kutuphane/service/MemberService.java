package com.example.kutuphane.service;

import com.example.kutuphane.entity.Member;
import com.example.kutuphane.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Tüm üyeleri getir
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // ID ile üye getir
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    // Yeni üye kaydet veya mevcut üyeyi güncelle
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    // ID ile üye sil
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}