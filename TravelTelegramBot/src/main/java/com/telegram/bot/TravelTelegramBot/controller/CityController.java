package com.telegram.bot.TravelTelegramBot.controller;

import com.telegram.bot.TravelTelegramBot.entity.City;
import com.telegram.bot.TravelTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{name}")
    private City getCityByName(@PathVariable String name){
        return cityService.getCityByName(name);
    }

    @GetMapping("")
    private List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @PutMapping("/names/{prevName}")
    private City changeCityName(@PathVariable String prevName, @RequestBody String nextName){
        return cityService.changeCityName(prevName, nextName);
    }

    @PutMapping("/descriptions/{cityName}")
    private City changeCityDescription(@PathVariable String cityName, @RequestBody String description){
        return cityService.changeCityDescription(cityName, description);
    }

    @PostMapping("")
    private City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @DeleteMapping("/{name}")
    private void deleteCityByName(@PathVariable String name){
        cityService.getCityByName(name);
    }
}
