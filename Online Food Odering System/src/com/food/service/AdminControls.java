package com.food.service;


import com.food.exception.RestaurantNotFoundException;
import com.food.model.FoodItem;
import com.food.model.Restaurant;
import com.food.model.Status;
import com.food.repository.IRestaurantRepository;
import com.food.repository.RestaurantRepository;

import java.time.LocalTime;
import java.util.List;

public class AdminControls {
    private static IRestaurantRepository repositoryInstance= new RestaurantRepository();
    public static List<Restaurant> getRestaurants() {
        return repositoryInstance.findAllRestaurants();
    }
    public void addRestaurant(Restaurant newRestaurant){
        repositoryInstance.addRestaurant(newRestaurant);
        System.out.println(newRestaurant.getName()+" Restaurant Added Successfully");
    }

    public void updateHoursByRestaurantId(int resId, LocalTime openingHours, LocalTime closingHours){
        Restaurant restaurant = repositoryInstance.getRestaurantById(resId);
        restaurant.setOpeningTime(openingHours);
        restaurant.setClosingHours(closingHours);
        System.out.println("Operating Hours are updated as : "+restaurant.getOpeningTime()+" to "+restaurant.getClosingHours());
    }

    public void addMenuItemByRestaurantId(int resId, FoodItem food){
        repositoryInstance.getRestaurantById(resId).getMenu().add(food);
        System.out.println(food+" Added successfully to the menu"+repositoryInstance.getRestaurantById(resId).getMenu());
    }

    public void removeMenuItemByRestaurantId(int resId, FoodItem food){
        repositoryInstance.getRestaurantById(resId).getMenu().remove(food);
        System.out.println(food+" Removed successfully to the menu "+repositoryInstance.getRestaurantById(resId).getMenu());
    }

    public void disableRestaurant(int resId){
        repositoryInstance.setActivationStatus(resId, Status.DISABLED);
        System.out.println("Restaurant "+repositoryInstance.getRestaurantById(resId).getName()+" Status is now "+repositoryInstance.getRestaurantById(resId).getStatus());
    }

    public List<Restaurant> findAllActiveRestaurant() {
        return repositoryInstance.findAllActiveRestaurant();
    }

    public Restaurant findRestaurantById(int resId) throws RestaurantNotFoundException {
        return  repositoryInstance.getRestaurantById(resId);
    }
    public boolean hadRestaurantById(int resId){
        return  repositoryInstance.hasRestaurant(resId);
    }

}
