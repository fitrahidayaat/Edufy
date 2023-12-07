package com.kelompok7.controllers;

import java.util.*;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kelompok7.Model.Student;
import com.kelompok7.Service.StudentService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RestController
@RequestMapping("")
public class HomeController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/Student")
    public String saveStudent(@RequestBody Student student) throws InterruptedException, ExecutionException{
        return studentService.saveStudent(student);
    }

    @PutMapping("/Student")
    public String updateStudent(@RequestBody Student student) throws InterruptedException, ExecutionException{
        return studentService.updateStudent(student);
    }

    @GetMapping("/Student/{name}")
    public Student getStudent(@PathVariable String name) throws InterruptedException, ExecutionException{
        return studentService.getStudent(name);
    }

    @DeleteMapping("/Student/{name}")
    public String deleteStudent(@PathVariable String name) throws InterruptedException, ExecutionException{
        return studentService.deleteStudent(name);
    }

    @GetMapping("/Student")
    public List<Student> getStudentall() throws InterruptedException, ExecutionException{
        return studentService.getStudentall();
    }


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

}
