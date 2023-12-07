package com.kelompok7.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kelompok7.Model.Student;
import com.kelompok7.Service.StudentService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String welcome(Model model){
        //String messages = "Welcome to Edufy : LMS";
        // String messages = "Welcome to Edufy : Learning Management System";
        //model.addAttribute("msg", messages);
        return "index";
    }

    @GetMapping("/Course")
    public String Course() {
        return "course_Admin";
    }
    
    @GetMapping("/News")
    public String News() {
        return "news_Admin";
    }
    

    @GetMapping("/Users")
    public String Users() {
        return "users_Admin";
    }
    
    @GetMapping("/Register")
    public String Register(){
        return "register_Admin";
    }

    @GetMapping("/AdminHome")
    public String Admin_Home(){
        return "adminHome";
    }

    @GetMapping("/Add_Student")
    public String add_Student(){
        return "add_Student";
    }

    @GetMapping("/Add_Teacher")
    public String add_Teacher(){
        return "add_Teacher";
    }

    @GetMapping("/Add_Admin")
    public String add_Admin(){
        return "add_Admin";
    }

    @GetMapping("/List_Student")
	public ModelAndView showStudent() {
		List<Student>listS=studentService.showStudents();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book",list);
		return new ModelAndView("List_Student","student",listS);
	}

    @PostMapping("/save")
    public String addStudent(@ModelAttribute Student s){
        studentService.saveStudent(s);
        return "redirect:/List_Student";
    }

    @GetMapping("/getTest")
    public List<Student> getS(){
        return studentService.showStudents();
    }
}
