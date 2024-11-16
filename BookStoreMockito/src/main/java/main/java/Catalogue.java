package main.java;

import java.util.List;

public class Catalogue 
{
    private ReadItemCommand readItemCommand;
    private WriteItemCommand writeItemCommand;

    public Catalogue(ReadItemCommand readItemCommand, WriteItemCommand writeItemCommand) {
        this.readItemCommand = readItemCommand;
        this.writeItemCommand = writeItemCommand;
    }

    public List<Book> getAllBooks(){return readItemCommand.readAll();}
    public void addBook(Book book){writeItemCommand.insertItem(book);}
    public void addBooks(List<Book> books){for (Book book : books) {writeItemCommand.insertItem(book);}}
    public Book getBook(String isbn){return readItemCommand.getItem(isbn);}
    public void deleteBook(Book book){writeItemCommand.deleteItem(book);}

    public void deleteAllBooks() {
        List<Book> books = readItemCommand.readAll();
        for (Book book : books) {
            writeItemCommand.deleteItem(book);
        }
    }
}
