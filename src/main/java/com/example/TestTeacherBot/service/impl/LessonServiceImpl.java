package com.example.TestTeacherBot.service.impl;

import com.example.TestTeacherBot.dao.LessonDao;
import com.example.TestTeacherBot.entity.Lesson;
import com.example.TestTeacherBot.service.LessonService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LessonServiceImpl implements LessonService
{
    @Resource
    private LessonDao lessonDao;

    @Override
    public void saveLesson(Lesson lesson)
    {
        lessonDao.save(lesson);
    }
}
