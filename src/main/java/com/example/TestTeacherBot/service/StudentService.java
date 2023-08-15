package com.example.TestTeacherBot.service;

import com.example.TestTeacherBot.entity.Student;

public interface StudentService
{
    void saveStudent(Student student);

    String seeAllStudent();
}
