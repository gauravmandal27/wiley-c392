package com.food.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Restaurant {
    private int resId;
    private static int resCount;
    private String name;
    private String location;
    private Status status;
    private LocalTime openingTime;
    private LocalTime closingHours;
    private CuisineType cuisineType;
    private ArrayList<FoodItem> menu;

    @Override
    public String toString() {
        return "Restaurant{" +
                "resId=" + resId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", status=" + status +
                ", openingTime=" + openingTime.format(DateTimeFormatter.ofPattern("HH:mm")) +
                ", closingHours=" + closingHours.format(DateTimeFormatter.ofPattern("HH:mm")) +
                ", cuisineType=" + cuisineType +
                ", menu=" + menu +
                '}'+'\n';
    }

    public Restaurant(int resId, String name, String location, Status status, LocalTime openingTime, LocalTime closingHours, CuisineType cuisineType) {
        this.resId = resId;
        this.name = name;
        this.location = location;
        this.status = status;
        this.openingTime = openingTime;
        this.closingHours = closingHours;
        this.cuisineType = cuisineType;
        this.menu = new ArrayList<>();
        resCount+=1;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public static long getResCount() {
        return resCount;
    }

    public static void setResCount(int resCount) {
        Restaurant.resCount = resCount;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingHours() {
        return closingHours;
    }

    public void setClosingHours(LocalTime closingHours) {
        this.closingHours = closingHours;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CuisineType getTypeOfRestaurant() {
        return cuisineType;
    }

    public ArrayList<FoodItem> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<FoodItem> menu) {
        this.menu = menu;
    }
}
