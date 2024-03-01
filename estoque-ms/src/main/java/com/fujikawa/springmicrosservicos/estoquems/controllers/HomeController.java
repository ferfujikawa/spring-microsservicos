package com.fujikawa.springmicrosservicos.estoquems.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok().body("Bem vindo ao microsserviço estoque-ms");
    }
    
}
