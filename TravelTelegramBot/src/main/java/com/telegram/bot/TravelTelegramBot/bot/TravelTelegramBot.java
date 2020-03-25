package com.telegram.bot.TravelTelegramBot.bot;

import com.telegram.bot.TravelTelegramBot.bot.command.BotCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.telegram.bot.TravelTelegramBot.bot.command.BotCommands.*;

@Component
public class TravelTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Autowired
    private BotCommands botCommands;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            switch (message.getText()) {
                case START_COMMAND:
                    sendMessage(botCommands.startCommand(), chatId);
                    sendMessage(botCommands.helpCommand(), chatId);
                    break;
                case ALL_CITIES:
                    sendMessage(botCommands.getAllCities(), chatId);
                    break;
                case HELP_COMMAND:
                    sendMessage(botCommands.helpCommand(), chatId);
                    break;
                default:
                    sendMessage(botCommands.getCity(text), chatId);
                    break;
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

    public void sendMessage(String message, Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
