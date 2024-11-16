package project.main;

import java.util.ArrayList;
import java.util.List;

public class Basket 
{

	public List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooksInBasket() {
		return books;
	}

	@Override
	public String toString() {
		return "Basket [books=" + books + "]";
	}
}
