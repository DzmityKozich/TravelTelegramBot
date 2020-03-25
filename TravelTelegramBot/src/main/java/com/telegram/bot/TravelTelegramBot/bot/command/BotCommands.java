package com.telegram.bot.TravelTelegramBot.bot.command;

import com.telegram.bot.TravelTelegramBot.entity.City;
import com.telegram.bot.TravelTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotCommands {

    public static final String START_COMMAND = "/start";
    public static final String ALL_CITIES = "/getall";
    public static final String HELP_COMMAND = "/help";

    @Autowired
    private CityService service;

    public String startCommand() {
        return "Hello, my new Friend!";
    }

    public String helpCommand(){
        return "You can control me by sending these commands:\n" +
                "/help - for help you\n" +
                "/getall - list of all cities in my database";
    }

    public String getCity(String text){
        return service.getCityByName(text) == null ? "There is not this city in my database(" : service.getCityByName(text).toString();
    }

    public String getAllCities(){
        StringBuilder cities = new StringBuilder();
        for(City city : service.getAllCities()){
            cities.append(city.getName()).append("\n");
        }
        return cities.toString();
    }
}
