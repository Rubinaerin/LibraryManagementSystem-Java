package com.example.kutuphane; // Artık sadece tek 'kutuphane' olmalı

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class KutuphaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KutuphaneApplication.class, args);
	}

}
