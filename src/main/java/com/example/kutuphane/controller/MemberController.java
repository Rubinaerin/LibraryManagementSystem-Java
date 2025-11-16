package com.example.kutuphane.controller;

import com.example.kutuphane.entity.Member;
import com.example.kutuphane.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // Tüm üyeleri listeleme sayfası
    // URL: /members
    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members/list"; // templates/members/list.html şablonunu döndürür
    }

    // Yeni üye ekleme formu sayfası
    // URL: /members/new
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("member", new Member());
        return "members/form";
    }

    // Yeni üye kaydetme veya güncellemeyi işleme
    // URL: /members
    @PostMapping
    public String saveMember(@ModelAttribute Member member) {
        memberService.save(member);
        return "redirect:/members";
    }

    // Üye düzenleme formu sayfası
    // URL: /members/edit/{id}
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Member member = memberService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
        model.addAttribute("member", member);
        return "members/form";
    }

    // Üye silme işlemi
    // URL: /members/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return "redirect:/members";
    }
}