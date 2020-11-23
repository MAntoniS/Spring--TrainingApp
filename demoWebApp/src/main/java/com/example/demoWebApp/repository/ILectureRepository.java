package com.example.demoWebApp.repository;

import com.example.demoWebApp.Lecture;

import java.util.List;

public interface ILectureRepository {
    Lecture findOne(long id);
    List<Lecture> findLastLectures();
    List<Lecture> findLectures(long max, int count);

    void save(Lecture lecture);
}
