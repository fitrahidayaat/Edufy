package com.kelompok7.controllers;

import com.kelompok7.Model.Admin;
import com.kelompok7.Model.Course;
import com.kelompok7.Model.Student;
import com.kelompok7.Model.Teacher;
import com.kelompok7.Repository.CourseRepository;
import com.kelompok7.Service.AdminService;
import com.kelompok7.Service.CourseService;
import com.kelompok7.Service.StudentService;
import com.kelompok7.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    StudentService studentService;
    AdminService adminService;

    TeacherService teacherService;

    CourseService courseService;

    public HomeController(StudentService studentService, AdminService adminService, TeacherService teacherService, CourseService courseService) {
        this.studentService = studentService;
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.courseService = courseService;
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





    //handlee method to handle list students and return mode and view


    List<Long> ids = new ArrayList<Long>();



    @GetMapping("/Add_course")
    public String addCourseForm(Model model){
        //create student object to hold student data
        Course course = new Course();
        model.addAttribute("course",course);
        return "create_course";
    }

    @PostMapping("/courses")
    public String saveCourse(@ModelAttribute("course") Course course){
        courseService.saveCourse(course);
        return "redirect:/Show_Course";
    }

    @GetMapping("/Show_Course")
    public String listCourse(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "courses";
    }


    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable Long id, Model model){
        model.addAttribute("course",courseService.getCourseById(id));
        return "edit_course";
    }

    @PostMapping("/courses/{id}")
    public String UpdateCourse(@PathVariable Long id
            ,@ModelAttribute("course") Course course
            ,Model model){
        //get student from db by id
        Course existingCourse = courseService.getCourseById(id);
        existingCourse.setId(id);
        existingCourse.setName(course.getName());

        //save updated student object
        courseService.updateCourse(existingCourse);
        return "redirect:/Show_Course";
    }

    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return "redirect:/Show_Course";
    }


























    @GetMapping("/Show_Student")
    public String listStudent(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/Show_Admin")
    public String listAdmin(Model model){
        model.addAttribute("admins", adminService.getAllAdmin());
        return "admins";
    }

    @GetMapping("/Show_Teacher")
    public String listTeacher(Model model){
        model.addAttribute("teachers", teacherService.getAllTeacher());
        return "teachers";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/Show_Student";
    }

    @PostMapping("/admins")
    public  String saveAdmin(@ModelAttribute("admin") Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/Show_Admin";
    }

    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/Show_Teacher";
    }

    @GetMapping("/Add_Student")
    public String addStudentForm(Model model){
        //create student object to hold student data
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @GetMapping("/Add_Admin")
    public  String addAdminForm(Model model){
        //create admin onject to hold admin data
        Admin admin = new Admin();
        model.addAttribute("admin",admin);
        return "create_admin";
    }

    @GetMapping("/Add_Teacher")
    public String addTeacherForm(Model model){
        //create teacher object to hold teacher data
        Teacher teacher = new Teacher();
        model.addAttribute("teacher",teacher);
        return "create_teacher";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @GetMapping("/admins/edit/{id}")
    public String editAdminForm(@PathVariable Long id, Model model){
        model.addAttribute("admin",adminService.getAdminById(id));
        return "edit_admin";
    }

    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id, Model model){
        model.addAttribute("teacher",teacherService.getTeacherById(id));
        return "edit_teacher";
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

    @PostMapping("/admins/{id}")
    public String updateStudent(@PathVariable Long id
            ,@ModelAttribute("admin") Admin admin
            ,Model model){
        //get admin from db by id
        Admin existingAdmin = adminService.getAdminById(id);
        existingAdmin.setId(admin.getId());
        existingAdmin.setName(admin.getName());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPassword(admin.getPassword());
        existingAdmin.setContact(admin.getContact());

        //save updated admin object
        adminService.updateAdmin(existingAdmin);
        return "redirect:/Show_Admin";
    }

    @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id
            ,@ModelAttribute("teacher") Teacher teacher
            ,Model model){
        //get teacher
        Teacher existingTeacher = teacherService.getTeacherById(id);
        existingTeacher.setId(teacher.getId());
        existingTeacher.setName(teacher.getName());
        existingTeacher.setEmail(teacher.getEmail());
        existingTeacher.setPassword(teacher.getPassword());
        existingTeacher.setContact(teacher.getContact());

        //save updated teacher object
        teacherService.updateTeacher(existingTeacher);
        return "redirect:/Show_Teacher";
    }

    //handler method to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/Show_Student";
    }

    @GetMapping("/admins/{id}")
    public  String deleteAdmin(@PathVariable Long id){
        adminService.deleteAdminById(id);
        return "redirect:/Show_Admin";
    }

    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "redirect:/Show_Teacher";
    }

}
