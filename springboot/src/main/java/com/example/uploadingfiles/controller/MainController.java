package com.example.uploadingfiles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/din")
    public String testDin(){
        return "Pontep Thaweesup";
    }
}
