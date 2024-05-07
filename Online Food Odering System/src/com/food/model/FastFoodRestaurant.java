package com.food.model;

import java.time.LocalTime;

public class FastFoodRestaurant extends Restaurant{
    public FastFoodRestaurant(int resId, String name, String location, Status status, LocalTime openingTime, LocalTime closingHours) {
        super(resId, name, location, status, openingTime, closingHours, CuisineType.FAST_FOOD);
    }
}
