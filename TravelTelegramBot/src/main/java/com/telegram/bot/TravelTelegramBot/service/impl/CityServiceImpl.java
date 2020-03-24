package com.telegram.bot.TravelTelegramBot.service.impl;

import com.telegram.bot.TravelTelegramBot.entity.City;
import com.telegram.bot.TravelTelegramBot.repository.CityRepository;
import com.telegram.bot.TravelTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }
}
