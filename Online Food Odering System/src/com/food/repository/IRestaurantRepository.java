package com.food.repository;

import com.food.model.CuisineType;
import com.food.model.FoodItem;
import com.food.model.Restaurant;
import com.food.model.Status;

import java.util.List;

public interface IRestaurantRepository {
    public void addRestaurant(Restaurant restaurant);

    public void setActivationStatus(int resId,Status status);

    public void updateMenuItem(int resId, FoodItem item, boolean toAdd);

    public Restaurant getRestaurantById(int id);

    public List<Restaurant> findRestaurantByLocation(String location);

    public List<Restaurant> findRestaurantByName(String name);

    List<Restaurant> findRestaurantByType(CuisineType type);

    public List<Restaurant> findAllActiveRestaurant();

    public List<Restaurant> findAllDeactivatedRestaurant();

    public List<Restaurant> findAllRestaurants();

    public boolean hasRestaurant(int resId);
}
