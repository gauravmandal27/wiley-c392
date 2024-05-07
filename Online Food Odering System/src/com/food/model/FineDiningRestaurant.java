package com.food.model;

import java.time.LocalTime;
import java.util.HashSet;

public class FineDiningRestaurant extends Restaurant{
    public FineDiningRestaurant(int resId, String name, String location, Status status, LocalTime openingTime, LocalTime closingHours) {
        super(resId, name, location, status, openingTime, closingHours, CuisineType.FINE_DINE);
    }
}
