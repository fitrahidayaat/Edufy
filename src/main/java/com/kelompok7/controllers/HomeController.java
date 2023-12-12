package com.kelompok7.controllers;

import com.kelompok7.Model.Student;
import com.kelompok7.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class HomeController {

    StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public String welcome(){
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


    @GetMapping("/Add_Teacher")
    public String add_Teacher(){
        return "add_Teacher";
    }

    @GetMapping("/Add_Admin")
    public String add_Admin(){
        return "add_Admin";
    }

    //handlee method to handle list students and return mode and view
    @GetMapping("/Show_Student")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

//    @GetMapping("/students/new")
//    public String createStudentForm(Model model){
//        //create student object to hold student data
//        Student student = new Student();
//        model.addAttribute("student",student);
//        return "create_student";
//    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/Show_Student";
    }

    @GetMapping("/Add_Student")
    public String addStudentForm(Model model){
        //create student object to hold student data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String UpdateStudent(@PathVariable Long id
            ,@ModelAttribute("student") Student student
            ,Model model){
        //get student from db by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setGrade(student.getGrade());

        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/Show_Student";
    }

    //handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/Show_Student";
    }
    //testing testing
    //testing
}
