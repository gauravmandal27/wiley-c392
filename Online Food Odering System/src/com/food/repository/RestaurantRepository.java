package com.food.repository;

import com.food.exception.RestaurantNotFoundException;
import com.food.model.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class RestaurantRepository implements IRestaurantRepository{
    private static HashSet<Restaurant> restaurants = new HashSet<>();

    public RestaurantRepository() {
        if(restaurants.isEmpty())  init();
    }

    public void init(){
        addRestaurant(new FineDiningRestaurant(201,"Mehfil","Hyderabad",Status.ACTIVE, LocalTime.now(),LocalTime.now().plusHours(10)));
        addRestaurant(new FastFoodRestaurant(420,"Paradise","Mumbai",Status.ACTIVE,LocalTime.now(),LocalTime.now().plusHours(10)));
        addRestaurant(new FastFoodRestaurant(320,"Bawarchi","Delhi",Status.DISABLED, LocalTime.now(),LocalTime.now().plusHours(10)));
        addRestaurant(new FineDiningRestaurant(17,"Taj","Hyderabad",Status.ACTIVE, LocalTime.now(),LocalTime.now().plusHours(10)));

        getRestaurantById(201).getMenu().add(new FoodItem("Veg Biryani",100,true));
        getRestaurantById(201).getMenu().add(new FoodItem("Veg Biryani",100,true));
        getRestaurantById(17).getMenu().add(new FoodItem("Chicken Biryani",200,false));
        getRestaurantById(320).getMenu().add(new FoodItem("Paneer Biryani",190,true));
        getRestaurantById(201).getMenu().add(new FoodItem("Chicken Biryani",190,false));
        getRestaurantById(320).getMenu().add(new FoodItem("Mushroom Biryani",166,true));

    }

    @Override
    public void addRestaurant(Restaurant newRestaurants) {
        restaurants.add(newRestaurants);
        System.out.println(newRestaurants.getName()+" Restaurant Added Successfully");
    }


    @Override
    public void setActivationStatus(int resId,Status status) {
        Restaurant restaurant = getRestaurantById(resId);
        restaurant.setStatus(status);
        System.out.println("Restaurant "+restaurant.getName()+" Status is now "+restaurant.getStatus());
    }



    @Override
    public void updateMenuItem(int resId, FoodItem item, boolean toAdd) {
        if(toAdd){
            getRestaurantById(resId).getMenu().add(item);
            System.out.println("Added Successfully to the Menu!!");
        }
        else{
            if(getRestaurantById(resId).getMenu().contains(item)){
                getRestaurantById(resId).getMenu().remove(item);
                System.out.println("Removed Successfully from the Menu!!");
            }
            else System.out.println("No Such Item in the Menu!!");
        }
    }

    @Override
    public Restaurant getRestaurantById(int id) throws RestaurantNotFoundException{
        Optional<Restaurant> op = restaurants.stream().filter((e)->e.getResId()==id).findFirst();
        Restaurant restaurant;
        if(op.isPresent()){
            restaurant=op.get();
        }
        else{
            throw  new RestaurantNotFoundException("Restaurant Not in the List");
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> findRestaurantByLocation(String location) {
        List<Restaurant> restaurant = restaurants.stream().filter((e)->e.getStatus()==Status.ACTIVE).filter((e)->e.getLocation().contains(location)).toList();
        if(restaurant.isEmpty()) throw new RestaurantNotFoundException("No Restaurant Available");
        return restaurant;
    }

    @Override
    public List<Restaurant> findRestaurantByName(String name) {
        List<Restaurant> restaurant = restaurants.stream().filter((e)->e.getLocation().contains(name)).toList();
        if(restaurant.isEmpty()) throw new RestaurantNotFoundException("No Restaurant Available");
        return restaurant;
    }


    @Override
    public List<Restaurant> findRestaurantByType(CuisineType type) {
        List<Restaurant> restaurant = restaurants.stream().filter((e)->e.getStatus()==Status.ACTIVE).filter((e)->e.getCuisineType()==type).toList();
        if(restaurant.isEmpty()) throw new RestaurantNotFoundException("No Restaurant Available");
        return restaurant;
    }


    @Override
    public List<Restaurant> findAllActiveRestaurant() {
        List<Restaurant> restaurant = restaurants.stream().filter((e)->e.getStatus()==Status.ACTIVE).toList();
        if(restaurant.isEmpty()) throw new RestaurantNotFoundException("No Restaurant are Present");
        return restaurant;
    }

    @Override
    public List<Restaurant> findAllDeactivatedRestaurant() {
        List<Restaurant> restaurant = restaurants.stream().filter((e)->e.getStatus()==Status.DISABLED).toList();
        if(restaurant.isEmpty()) throw new RestaurantNotFoundException("No Restaurant are Disabled");
        return restaurant;
    }

    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurants.stream().toList();
    }

    @Override
    public boolean hasRestaurant(int resId) {
        return restaurants.stream().filter((e)->e.getResId()==resId).toList().isEmpty();
    }
}
