package main.java;

public class Book {
    private String title;
    private String author;
    public String isbn;
    private double price;
    private int pages;

    public Book(String title, String author, String isbn, double price, int pages) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.pages = pages;
    }

    // Getters and setters...

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                '}';
    }
}