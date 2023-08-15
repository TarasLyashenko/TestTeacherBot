package com.example.TestTeacherBot.dao;

import com.example.TestTeacherBot.entity.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonDao extends CrudRepository<Lesson, Long>
{
    Lesson findByTitle(String title);
    Lesson findByNumberHours(int numberHours);
}
