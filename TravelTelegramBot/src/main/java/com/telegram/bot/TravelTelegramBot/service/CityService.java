package com.telegram.bot.TravelTelegramBot.service;

import com.telegram.bot.TravelTelegramBot.entity.City;

public interface CityService {
    City getCityByName(String name);
}
