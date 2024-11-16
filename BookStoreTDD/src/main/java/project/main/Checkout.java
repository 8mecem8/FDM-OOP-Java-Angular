package project.main;

import java.util.List;

public class Checkout {
	public double calculatePrice(Basket basket) {
		List<Book> books = basket.getBooksInBasket();

		if (books.isEmpty()) {
			return 0.0;
		}
		int numberOfBooks = books.size();

		double total = books.stream().mapToDouble(Book::getPrice).sum();

		// Apply discounts
		double discount = 0.0;

		if (numberOfBooks >= 10) {
			discount += 10.0;
		}

		discount += (numberOfBooks / 3) * 1.0;

		total -= total * (discount / 100);

		return total;
	}
}
