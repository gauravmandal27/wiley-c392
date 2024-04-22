package com.bookstore.service;
import com.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

// ShoppingCart class representing the shopping cart component
public class ShoppingCart {
    private List<Book> items = new ArrayList<Book>();
    static double totalPrice;
    // Methods related to shopping cart

    public double calculateTotalPrice() {
        return totalPrice;
    }

    public void addItem(Book book) {
        items.add(book);
        totalPrice+=book.getPrice();
    }

    public void removeItem(Book book) {
        items.remove(book);
        totalPrice-=book.getPrice();
    }

    public void displayItems() {
        System.out.println("The Shopping Cart has the following Items");
        System.out.println(items);
    }

}
