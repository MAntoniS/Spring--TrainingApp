package com.example.demoWebApp.repository;

import com.example.demoWebApp.Student;

public interface StudentRepository {

    Student save(Student student);

    Student findByUsername(String username);
}
