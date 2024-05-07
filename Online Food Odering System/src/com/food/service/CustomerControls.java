package com.food.service;

import com.food.model.*;
import com.food.repository.IRestaurantRepository;
import com.food.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerControls {
    private static IRestaurantRepository repositoryInstance= new RestaurantRepository();
    private static List<Items>  shoppingCart;

    public CustomerControls() {
        shoppingCart = new ArrayList<Items>();
    }

    public void resetCart(){
        shoppingCart = new ArrayList<Items>();
    }
    public List<Restaurant> findAllActiveRestaurant() {
        return repositoryInstance.findAllActiveRestaurant();
    }

    public List<Restaurant> findAllActiveRestaurant(String placeName) {
        return repositoryInstance.findRestaurantByLocation(placeName);
    }

    public List<Restaurant> findAllActiveRestaurant(CuisineType type) {
        return repositoryInstance.findRestaurantByType(type);
    }

    public void addToCart(FoodItem item,int quantity,String notes){
        shoppingCart.add(new Items(item,quantity,notes));
        System.out.println("Added Item to Cart!!");
    }

    public void viewCart(){
        System.out.println("\n Shopping Cart!!\n");
        for(var items:shoppingCart){
            System.out.println(items);
        }
        if(shoppingCart.isEmpty()){
            System.out.println("No Items in the Cart");
        }
    }

    public List<Items> getCart(){
       return shoppingCart;
    }

    public double getTotalCartValue(){
        double totalCartValue=0;
        for(Items item:shoppingCart){
            totalCartValue += item.getQuantity()*item.getItem().getPrice();
        }
        return totalCartValue;
    }

    public void printMenu(Restaurant restaurant){
        int menuSize=restaurant.getMenu().size();
        if(menuSize!=0) {
            System.out.println(restaurant.getName()+" Restaurant Has");
            System.out.println("S.No.    Food Item Price Veg/Non-Veg");
            for (int i = 0; i <menuSize; i++) {
                System.out.println((i+1)+" "+restaurant.getMenu().get(i));
            }
        }
        else{
            System.out.println("\n"+restaurant.getName()+" Has no items listed");
        }
    }

}
