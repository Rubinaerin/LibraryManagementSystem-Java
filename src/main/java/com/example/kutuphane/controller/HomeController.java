package com.example.kutuphane.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // URL: http://localhost:8083/ veya http://localhost:8083/home
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "home"; // templates/home.html şablonunu arar
    }
}