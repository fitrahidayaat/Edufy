package com.kelompok7.controllers;

import com.kelompok7.Model.*;
import com.kelompok7.Repository.CourseRepository;
import com.kelompok7.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    StudentService studentService;
    AdminService adminService;

    TeacherService teacherService;

    CourseService courseService;

    MaterialService materialService;

    public HomeController(StudentService studentService, AdminService adminService, TeacherService teacherService, CourseService courseService, MaterialService materialService) {
        this.studentService = studentService;
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.courseService = courseService;
        this.materialService = materialService;
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




    @GetMapping("/login_Student")
    public ModelAndView loginStudentForm() {
        ModelAndView mav = new ModelAndView("loginForm_student");
        mav.addObject("student", new Student());
        return mav;
    }

    @PostMapping("/login_Student")
    public String loginStudent(@ModelAttribute("student") Student student ) {

        Student oauthUser = studentService.login(student.getEmail(), student.getPassword());

        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            System.out.println(oauthUser.getEmail());
            System.out.println(oauthUser.getPassword());
            return "redirect:/Dashboard_Student";


        } else {
            return "redirect:/login_Student";


        }
    }

    @GetMapping("/Dashboard_Student")
    public String ul_student(Model model){
        model.addAttribute("courses", courseService.getAllCourse());
        return "dashboard_student";
    }


    @GetMapping("/login_Teacher")
    public ModelAndView loginTeacherForm() {
        ModelAndView mav = new ModelAndView("loginForm_teacher");
        mav.addObject("teacher", new Teacher());
        return mav;
    }

    @PostMapping("login_Teacher")
    public String loginTeacher(@ModelAttribute("teacher") Teacher teacher ) {

        Teacher oauthUser = teacherService.login(teacher.getEmail(), teacher.getPassword());

        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            System.out.println(oauthUser.getEmail());
            System.out.println(oauthUser.getPassword());
            return "redirect:/Dashboard_Teacher";


        } else {
            return "redirect:/login_Teacher";

        }
    }

    @GetMapping("/Dashboard_Teacher")
    public String ul_teacher(Model model){
        model.addAttribute("courses", courseService.getAllCourse());
        return "dashboard_teacher";
    }


    @GetMapping("/login_Admin")
    public ModelAndView loginAdminForm() {
        ModelAndView mav = new ModelAndView("loginForm_admin");
        mav.addObject("admin", new Admin());
        return mav;
    }

    @PostMapping("/login_Admin")
    public String loginAdmin(@ModelAttribute("admin") Admin admin ) {

        Admin oauthUser = adminService.login(admin.getEmail(), admin.getPassword());

        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            System.out.println(oauthUser.getEmail());
            System.out.println(oauthUser.getPassword());
            return "redirect:/AdminHome";


        } else {
            return "redirect:/login_Admin";

        }
    }


    @GetMapping("/material/view/{id}")
    public ModelAndView materialViewTeacher(@PathVariable Long id, Model model) {
        Course existingCourse = courseService.getCourseById(id);
        String name = existingCourse.getName();
        model.addAttribute("materials", materialService.ShowByCourse(name));
        model.addAttribute("course", courseService.getCourseById(id));
        ModelAndView mav = new ModelAndView("materialView_teacher");
        mav.addObject("course");
        return mav;
    }



    @GetMapping("/material/{id}")
    public ModelAndView addMaterialForm(@PathVariable Long id, Model model){
        Course existingCourse = courseService.getCourseById(id);
        String name = existingCourse.getName();
        Material material = new Material();
        model.addAttribute("material",material);
        material.setCourse(name);
        model.addAttribute("course", courseService.getCourseById(id));
        ModelAndView mav = new ModelAndView("create_material");
        System.out.println(material.getCourse());
        mav.addObject("course");
        return mav;
    }

    @PostMapping("/materials/{id}")
    public String saveMaterial(@PathVariable Long id,@ModelAttribute("material") Material material){
        Course existingCourse = courseService.getCourseById(id);
        String name = existingCourse.getName();
        material.setCourse(name);
        System.out.println(material.getCourse());
        materialService.saveMaterial(material);
        return "redirect:/material/view/{id}";
    }

    @GetMapping("/materials/edit/{id}")
    public String editMaterialForm(@PathVariable Long id, Model model){
      model.addAttribute("material",materialService.getMaterialById(id));
      return "edit_material";
    }

    @PostMapping("/material/edit/{id}")
    public String UpdateMaterial(@PathVariable Long id
            ,@ModelAttribute("material") Material material
            ,Model model){
        //get student from db by id
        Material existingMaterial = materialService.getMaterialById(id);
        existingMaterial.setName(material.getName());
        existingMaterial.setDescription(material.getDescription());

        //save updated student object
        materialService.saveMaterial(existingMaterial);
        return "redirect:/login_Teacher";
    }

    @GetMapping("/materials/delete/{id}")
    public String deleteMaterial(@PathVariable Long id){
        materialService.deleteMaterial(id);
        return "redirect:/login_Teacher";
    }


    @GetMapping("/material/view/student/{id}")
    public ModelAndView materialViewStudent(@PathVariable Long id, Model model) {
        Course existingCourse = courseService.getCourseById(id);
        String name = existingCourse.getName();
        model.addAttribute("materials", materialService.ShowByCourse(name));
        model.addAttribute("course", courseService.getCourseById(id));
        ModelAndView mav = new ModelAndView("materialView_student");
        mav.addObject("course");
        return mav;
    }

    @GetMapping("/material/viewing/student/{id}")
    public String viewingMaterialStudent(@PathVariable Long id, Model model){
        model.addAttribute("material",materialService.getMaterialById(id));
        return "material_student";
    }

    @GetMapping("/material/viewing/teacher/{id}")
    public String viewingMaterialTeacher(@PathVariable Long id, Model model){
        model.addAttribute("material",materialService.getMaterialById(id));
        return "material_teacher";
    }



    @GetMapping("/login_Page")
    public String loginPage(){
        return "login_page";
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
