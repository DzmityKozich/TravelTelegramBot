package com.telegram.bot.TravelTelegramBot.repository;

import com.telegram.bot.TravelTelegramBot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
