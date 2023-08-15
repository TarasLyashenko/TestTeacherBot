package com.example.TestTeacherBot.dao;

import com.example.TestTeacherBot.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends CrudRepository<Student, Long>
{
    Student findByName(String name);
    Student findByClassroom(String classroom);
}
