package com.telegram.bot.TravelTelegramBot.service;

import com.telegram.bot.TravelTelegramBot.entity.City;

import java.util.List;

public interface CityService {
    City getCityByName(String name);
    List<City> getAllCities();
    City saveCity(City city);
    City changeCityName(String prevName, String nextName);
    City changeCityDescription(String cityName, String description);
    void deleteCity(String cityName);

}
