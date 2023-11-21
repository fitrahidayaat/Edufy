package com.kelompok7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("")
public class HomeController {
    
    @GetMapping
    public String welcome(Model model){
        String messages = "Welcome to Edufy : LMS";
        // String messages = "Welcome to Edufy : Learning Management System";
        model.addAttribute("msg", messages);
        return "index";
    }
}
