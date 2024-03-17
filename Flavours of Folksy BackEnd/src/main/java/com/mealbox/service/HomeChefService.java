package com.mealbox.service;

import com.mealbox.entity.HomeChef;

import java.util.List;

public interface HomeChefService {
    HomeChef saveHomeChef(HomeChef homeChef);
    HomeChef loginHomeChef(HomeChef homeChef);
    HomeChef updateHomeChef(HomeChef homeChef, long homeChefId);
    HomeChef getHomeChefById(long homeChefId);
    List<HomeChef> getAllHomeChefs();
    void deleteHomeChef(long homeChefId);
}
