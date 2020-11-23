package com.example.demoWebApp.controlllers;

import com.example.demoWebApp.Student;
import com.example.demoWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/student")
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController() {
    }

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value = "register", method = GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Student student, Errors errors)
    {
        if(errors.hasErrors())
        {
            return "registerForm";
        }
        studentRepository.save(student);
        return "/redirect:/student/" +
                student.getUsername();
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showStudentProfile(@PathVariable String username, Model model) {
        Student student = studentRepository.findByUsername(username);
        model.addAttribute(student);
        return "profile";
    }
}
