package com.example.demoWebApp.repository;

import com.example.demoWebApp.Student;
import org.springframework.stereotype.Component;

@Component
public class SRepository implements StudentRepository {
    @Override
    public Student save(Student student) {
        return null;
    }

    @Override
    public Student findByUsername(String username) {
        return null;
    }
}
