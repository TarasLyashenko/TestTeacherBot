package com.example.TestTeacherBot.bot;

import com.example.TestTeacherBot.entity.Lesson;
import com.example.TestTeacherBot.entity.Student;
import com.example.TestTeacherBot.service.LessonService;
import com.example.TestTeacherBot.service.StudentService;
import jakarta.annotation.Resource;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot
{
    @Resource
    private LessonService lessonService;
    @Resource
    private StudentService studentService;

    public TelegramBot(String token)
    {
        super(token);
    }

    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        long chatId = update.getMessage().getChatId();

        if (message.getText().startsWith("ДобавитьЛекцию"))
        {
            String[] parts = message.getText().split(" ");
            if (parts.length == 3)
            {
                String title = parts[1];
                int numberHours = Integer.parseInt(parts[2]);

                Lesson lesson = new Lesson(title, numberHours);
                lessonService.saveLesson(lesson);
                sendMessage(chatId, "Запись сохранена");
            }
        }
        else if (message.getText().startsWith("ДобавитьУченика"))
        {
            String[] parts = message.getText().split(" ");
            if (parts.length == 3)
            {
                String name = parts[1];
                String classroom = parts[2];

                Student student = new Student(name, classroom);
                studentService.saveStudent(student);
                sendMessage(chatId, "Ученик сохранен");
            }
        }
        else if (message.getText().startsWith("ПоказатьВсехУчеников"))
        {
            sendMessage(chatId, studentService.seeAllStudent());
        }
        else
        {
            sendMessage(chatId, "Команда не распознана");
        }
        sendMessage(chatId, "Обработка завершена");
    }

    private void sendMessage(long chatId, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try
        {
            execute(sendMessage);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка при отправке сообщения: " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername()
    {
        return "TestTelergam_bot";
    }
}
