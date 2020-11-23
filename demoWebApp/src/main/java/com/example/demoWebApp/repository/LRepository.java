package com.example.demoWebApp.repository;


import com.example.demoWebApp.Lecture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LRepository implements ILectureRepository {

    @Override
    public List<Lecture> findLectures(long max, int count) {
        return null;
    }

    @Override
    public List<Lecture> findLastLectures() {
        return null;
    }

    @Override
    public Lecture findOne(long id) {
        return null;
    }

    @Override
    public void save(Lecture lecture) {

    }
}
