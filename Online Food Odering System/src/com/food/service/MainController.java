package com.food.service;

import com.food.exception.RestaurantNotFoundException;
import com.food.model.*;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        MainController main = new MainController();
        String status = "NONE";
        while(!status.equalsIgnoreCase("Stop")) {
            User userString = main.login();
            if (userString.getTypeOfUser() == UserType.ADMIN) {
                status = main.admin();
            }
            else if(userString.getTypeOfUser() == UserType.CUSTOMER){
                status = main.customer();
            }
            else if(userString.getTypeOfUser() == UserType.DELIVERY_AGENT){
                status = main.customer();
            }
        }

    }

    private String customer() {
        CustomerControls customer = new CustomerControls();
        boolean flag=true;
        while(flag){
            System.out.println("**** Welcome To The FOOOOD App Customer Console ****\n1)View Restaurants & Menu 2)View Cart & Conform Order 3)LogOut\nEnter Your Choice");
            int choice=sc.nextInt();
            if (choice == 1) {
                List<Restaurant> list;
                System.out.println("Want to Apply filter?? y/n");
                char c = sc.next().charAt(0);
                if (c == 'y') {
                    System.out.println("1)Place filter 2)Cuisine Type");
                    int ch = sc.nextInt();
                    if (ch == 1) {
                        System.out.println("Enter Location");
                        String location = sc.next();
                        list = customer.findAllActiveRestaurant(location);
                    } else {
                        System.out.println("Enter Cuisine type");
                        String cusineString = sc.next();
                        if (cusineString.contains("fine")) {
                            list = customer.findAllActiveRestaurant(CuisineType.FINE_DINE);

                        } else {
                            list = customer.findAllActiveRestaurant(CuisineType.FAST_FOOD);
                        }
                    }
                }
                else{
                    list = customer.findAllActiveRestaurant();
                }
                for(var restaurant:list) {
                    customer.printMenu(restaurant);
                    if (!restaurant.getMenu().isEmpty()) {
                        System.out.println("Want to order from this Restaurant (y) or continue browsing(n)?  y/n");
                        char choiceString = sc.next().charAt(0);
                        if (choiceString == 'y') {
                            while (true) {
                                System.out.println("Enter The Position of the Item you want :");
                                int itemIndex = (sc.nextInt()) - 1;
                                System.out.println("Enter The Quantity :");
                                int quantity = sc.nextInt();
                                System.out.println("Mention any Special Instructions:");
                                String notes = sc.nextLine();
                                sc.next();
                                customer.addToCart(restaurant.getMenu().get(itemIndex), quantity, notes);
                                System.out.println("Would you like to add more Items From the Menu y/n :");
                                char str = sc.next().charAt(0);
                                if (str == 'n') {
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else if (choice==2) {
                customer.viewCart();
                System.out.println("Press 1 to confirm order or 2 to return to main menu");
                int ch=sc.nextInt();
                if(ch==1){
                    System.out.println("Enter The Delivery Address: ");
                    String address=sc.next()+sc.nextLine();
                    System.out.println("Enter Your Contact Details: ");
                    long contact = sc.nextLong();
                    System.out.println("Enter Your Payment Details: CASH or CARD or UPI");
                    String payment = sc.next();
                    Order ord = new Order(customer.getCart(),address,payment,customer.getTotalCartValue());
                    Order.addOrder(ord);
                    Order.printOrderInfo(ord.getOrderId());
                    customer.resetCart();
                }

            }
            else if (choice==3) {
                flag=false;
                return "LOG_OUT";
            } else {
                System.out.println("Try again");
                continue;
            }
        }
        return "";
    }

    public String admin(){
        AdminControls admin = new AdminControls();
        boolean flag=true;
        while(flag){
            System.out.println("**** Welcome To The FOOOOD App Admin Console ****\n1)ADD Restaurants 2)Update Restaurant Details 3) Disable Restaurants 4)LogOut\nEnter Your Choice");
            int choice=sc.nextInt();
            if (choice == 2) {
                System.out.println("\n Enter Restaurant ID :");
                int resId= sc.nextInt();
                try{
                    admin.findRestaurantById(resId);
                }
                catch(RestaurantNotFoundException e){
                    System.out.println("Kindly Check Restaurant Id and try again");
                }

                System.out.println("Select detail to be updated 1)Operation Hours 2)Add/Remove Menu items ");
                int detail= sc.nextInt();
                if(detail==1){
                    System.out.println("Enter Opening Hours in HH:mm Format");
                    LocalTime open = LocalTime.parse(sc.next(), DateTimeFormatter.ofPattern("HH:mm"));
                    System.out.println("Enter Closing Hours in HH:mm Format");
                    LocalTime close = LocalTime.parse(sc.next(), DateTimeFormatter.ofPattern("HH:mm"));
                    admin.findRestaurantById(resId).setOpeningTime(open);
                    admin.findRestaurantById(resId).setClosingHours(close);
                }
                else{
                    System.out.println("1)Add Items 2)Remove Items");
                    int ch = sc.nextInt();
                    if(ch==1){
                        System.out.println("Enter Item Name");
                        String name = sc.next().trim();
                        System.out.println("Enter Item Price");
                        int price = sc.nextInt();
                        System.out.println("1");
                        System.out.println("Enter Veg or Non Veg");
                        String isVeg=sc.next();
                        new FoodItem(name,price,(!isVeg.contains("non")));
                    }
                }
            } else if (choice == 1) {
                System.out.println("Enter New Restaurant Id");
                int resId = sc.nextInt();
                if(!admin.hadRestaurantById(resId)){
                    System.out.println("Kindly Check Restaurant Id and try again");
                    continue;
                }
                System.out.println("Enter Restaurant Name: ");
                String name = sc.next().trim();
                System.out.println("Enter location Name: ");
                String location = sc.next().trim();
                System.out.println("Enter Cuisine Type: 1)Fine Dine or 2)Fast");
                int cuisineType = sc.nextInt();
                if(cuisineType==1) {
                    admin.addRestaurant(new FineDiningRestaurant(resId,name,location, Status.ACTIVE, LocalTime.now(),LocalTime.now().plusHours(10)));
                }
                else
                    admin.addRestaurant(new FastFoodRestaurant(resId,name,location, Status.ACTIVE, LocalTime.now(),LocalTime.now().plusHours(10)));
                continue;
            }
            else if (choice == 3) {
                System.out.println("Enter  Restaurant Id");
                int resId=sc.nextInt();
                try{
                    admin.findRestaurantById(resId);
                }
                catch(RestaurantNotFoundException e){
                    System.out.println("Kindly Check Restaurant Id and try again");
                    continue;
                }
                admin.disableRestaurant(resId);
            } else if (choice==4) {
                flag=false;

            } else {
                System.out.println("Try again");
                continue;
            }
        }
        return "LOG_OUT";
    }
    public User login(){
        UserController user = new UserController();
        boolean flag=true;
        while(flag){
            System.out.println("\n**** Welcome To The FOOOOD App ****\n1)Login 2)Sign Up\nEnter Your Choice");
            int choice=sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter User ID :");
                String userId= sc.next().trim();
                System.out.println("Enter User Password :");
                String userPwd= sc.next().trim();
                if(user.hasUser(userId) && user.getUserPassword(userId).equalsIgnoreCase(userPwd)){
                    System.out.println("Welcome User "+userId);
                    return user.getUser(userId);
                }
                else{
                    System.out.println("user not found try Again!!");
                }
            } else if (choice == 2) {
                System.out.println("Enter New User Id");
                String userId = sc.next().trim();
                if(user.hasUser(userId)){
                    System.out.println("User already Exists Try Login Instead or use New User ID");
                    continue;
                }
                System.out.println("Enter New Password");
                String userPwd = sc.next().trim();
                System.out.println("Select User Type 1)Customer 2)Delivery Agent");
                int usertype = sc.nextInt();
                user.newUser(userId, userPwd,(usertype==1)?UserType.CUSTOMER:UserType.DELIVERY_AGENT);
            } else {
                System.out.println("Try again");
                continue;
            }
        }
        return null;
    }
}
