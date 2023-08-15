package com.example.TestTeacherBot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String classroom;

    public Student(String name, String classroom)
    {
        this.name = name;
        this.classroom = classroom;
    }

    public Student()
    {

    }
}
