package com.telegram.bot.TravelTelegramBot.service.impl;

import com.telegram.bot.TravelTelegramBot.entity.City;
import com.telegram.bot.TravelTelegramBot.repository.CityRepository;
import com.telegram.bot.TravelTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public void deleteCity(String cityName) {
        cityRepository.delete(getCityByName(cityName));
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City changeCityName(String prevName, String nextName) {
        City city = cityRepository.findByName(prevName);
        city.setName(nextName);
        return cityRepository.save(city);
    }

    @Override
    public City changeCityDescription(String cityName, String description) {
        City city = cityRepository.findByName(cityName);
        city.setDescription(description);
        return cityRepository.save(city);
    }

    @Override
    public List<City> getAllCities() {
       return cityRepository.findAll();
    }
}
