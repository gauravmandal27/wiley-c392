package com.food.model;

public class Items {
    private FoodItem item;
    private int resId;
    private int quantity;
    private String specialInstructions;

    public Items(FoodItem item, int quantity, String specialInstructions) {
        this.item = item;
        this.quantity = quantity;
        this.specialInstructions = specialInstructions;
    }

    @Override
    public String toString() {
        return "Items{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", specialInstructions='" + specialInstructions + '\'' +
                '}';
    }

    public FoodItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public void setItem(FoodItem item) {
        this.item = item;
    }
}
