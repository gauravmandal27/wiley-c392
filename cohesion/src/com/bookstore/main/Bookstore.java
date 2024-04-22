package com.bookstore.main;
import com.bookstore.model.Book;
import com.bookstore.service.*;
// Bookstore class representing the main application
public class Bookstore {
    public static void main(String[] args) {
        // Create instances of Book, Inventory, and ShoppingCart
        Inventory inventory =new Inventory();
        inventory.addBook(new Book("title1","william",250));
        inventory.addBook(new Book("title2","robert",130));
        inventory.addBook(new Book("title4","william",450));
        inventory.addBook(new Book("title7","robert",266));
        inventory.addBook(new Book("title8","johnson",350));
        inventory.addBook(new Book("title3","neil",2660));
        inventory.addBook(new Book("title8","neil",254));
        inventory.addBook(new Book("title5","william",199));
        inventory.displayInventory();

        // Add books to inventory
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(inventory.findBookByTitle("title1"));
        shoppingCart.addItem(inventory.findBookByTitle("title5"));
        shoppingCart.addItem(inventory.findBookByTitle("title7"));
        shoppingCart.addItem(inventory.findBookByTitle("title8"));

        // Add books to shopping cart

        // Display inventory and total price of items in shopping cart
        shoppingCart.displayItems();
        System.out.println(shoppingCart.calculateTotalPrice());

    }
}