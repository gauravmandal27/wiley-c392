package com.food.model;

public class FoodItem {
    private String name;
    private double Price;
    private boolean isVeg;

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", Price=" + Price +
                ", isVeg=" + isVeg +
                '}'+'\n';
    }

    public FoodItem(String name, double price, boolean isVeg) {
        this.name = name;
        Price = price;
        this.isVeg = isVeg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setVeg(boolean isVeg) {
        this.isVeg = isVeg;
    }
}
