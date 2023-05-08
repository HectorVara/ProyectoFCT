package com.proyecto.FCT.controllers;

import com.proyecto.FCT.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ViewController {
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
}
