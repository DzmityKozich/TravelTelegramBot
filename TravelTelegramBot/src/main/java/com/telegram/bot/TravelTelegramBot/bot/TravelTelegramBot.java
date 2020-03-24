package com.telegram.bot.TravelTelegramBot.bot;

import com.telegram.bot.TravelTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TravelTelegramBot extends TelegramLongPollingBot {

    /* Hello! */
    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Autowired
    private CityService service;

    @Override
    public void onUpdateReceived(Update update) {
        if(update.getMessage().getText() != null){
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            String message = service.getCityByName(text) == null ? "There is not this city in our database!" : service.getCityByName(text).toString();

            SendMessage sendMessage = new SendMessage();
            sendMessage.enableMarkdown(true);
            sendMessage.setChatId(chatId);
            sendMessage.setText(message);
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
