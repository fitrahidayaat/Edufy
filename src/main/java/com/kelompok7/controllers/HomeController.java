package com.kelompok7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelompok7.Model.Student;
import com.kelompok7.Service.StudentService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String welcome(Model model){
        String messages = "Welcome to Edufy : LMS";
        // String messages = "Welcome to Edufy : Learning Management System";
        model.addAttribute("msg", messages);
        return "index";
    }

    @GetMapping("/adminHome")
    public String Admin_Home(){
        return "adminHome";
    }

    @GetMapping("/add_Student")
    public String add_Student(){
        return "add_Student";
    }

    @GetMapping("/add_Teacher")
    public String add_Teacher(){
        return "add_Teacher";
    }

    @GetMapping("/add_Admin")
    public String add_Admin(){
        return "add_Admin";
    }

    @GetMapping("/list_Student")
    public String list_Student(){
        return "list_Student";
    }

    @PostMapping("/save")
    public String addStudent(@ModelAttribute Student s){
        studentService.save(s);
        return "redirect:/list_Student";
    }
}
