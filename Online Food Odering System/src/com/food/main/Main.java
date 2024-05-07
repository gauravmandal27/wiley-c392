package com.food.main;

import com.food.model.FoodItem;
import com.food.service.AdminControls;
import com.food.service.CustomerControls;

public class Main {
    public static void main(String[] args) {

        AdminControls admin = new AdminControls();
//        System.out.println(admin.findAllActiveRestaurant());
        admin.addMenuItemByRestaurantId(201, new FoodItem("Veg Biryani", 100, true));
//        System.out.println(admin.findAllActiveRestaurant());

        CustomerControls customer = new CustomerControls();
        System.out.println(customer.findAllActiveRestaurant("Hyderabad"));


//        AdminControls manager = new AdminControls();
//        manager.addRestaurant(new FineDiningRestaurant("Mehfil","Hyderabad", LocalTime.now(),LocalTime.now().plusHours(10)));
//        manager.addRestaurant(new FastFoodRestaurant("Paradise","Mumbai", LocalTime.now(),LocalTime.now().plusHours(10)));
//        manager.addRestaurant(new FastFoodRestaurant("Bawarchi","Delhi", LocalTime.now(),LocalTime.now().plusHours(10)));
//        manager.addRestaurant(new FineDiningRestaurant("Taj","Hyderabad", LocalTime.now(),LocalTime.now().plusHours(10)));
//
//        System.out.println(AdminControls.getRestaurants());
//


//        System.out.println(AdminControls.getRestaurants());
    }
}