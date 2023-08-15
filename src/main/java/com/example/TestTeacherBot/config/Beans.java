package com.example.TestTeacherBot.config;

import com.example.TestTeacherBot.bot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans
{
    @Bean
    public TelegramBot createTelegramBot()
    {
        return new TelegramBot("6386064861:AAHYitCpAB4JduZYUIBw8_RrPGi6qC_PWEI");
    }
}
