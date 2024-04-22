package com.bookstore.service;
import com.bookstore.model.Book;
import java.util.ArrayList;
import java.util.List;

public class Inventory implements {
    private static List<Book> books = new ArrayList<>();

// Methods related to inventory management

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void displayInventory() {
        System.out.println("The Book inventory has the following Books");
        System.out.println(books.toString());
    }

    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return(book);
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> authorBooks= new ArrayList<>();
        for (Book book : books) {
            if(book.getTitle().equals(author)){
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public List<Book> findBooksByPriceRange(double minPrice, double maxPrice) {
        List<Book> booksByPrice= new ArrayList<>();
        for (Book book : books) {
            if (book.getPrice() <= maxPrice && book.getPrice() >= minPrice) {
                booksByPrice.add(book);
            }
        }
        return booksByPrice;
    }
}

