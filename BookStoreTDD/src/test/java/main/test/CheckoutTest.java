package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.main.Basket;
import project.main.Book;
import project.main.Checkout;

class CheckoutTest {

	@Test
	public void test_CalculatePrice_ReturnsDoubleZeroPointZeroWhenPassedAnEmptyBasket()
	{
		// arrange
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		
		// act
		var total = checkout.calculatePrice(basket);
		
		// assert
		assertEquals(0.0, total);
	}
	
	@Test
	public void test_CalculatePrice_ReturnsPriceOfBookInBasket_WhenPassedBasketWithOneBook() 
	{
		// arrange
		Book aBook = new Book("test-title","test-Autor",17.47);
		Basket basket = new Basket();
		Checkout checkout = new Checkout();
		
		// act
		basket.addBook(aBook);
		basket.getBooksInBasket();
		var expectedResult = aBook.getPrice();
		var total = checkout.calculatePrice(basket);
		
		// assert
		assertEquals(expectedResult, total);
	}
	
	@Test
    public void test_CalculatePrice_ReturnsSumMinus1Percent_WhenPassedBasketWithThreeBooks() 
	{
		// arrange
        Basket basket = new Basket();
        Book book1 = new Book("Title1", "Author1", 25.99);
        Book book2 = new Book("Title2", "Author2", 25.99);
        Book book3 = new Book("Title3", "Author3", 25.99);
        
    		// act
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        Checkout checkout = new Checkout();
        
        // assert
        assertEquals(77.19, checkout.calculatePrice(basket), 0.01);
    }

    @Test
    public void test_CalculatePrice_ReturnsSumMinus2Percent_WhenPassedBasketWithSixBooks()
{
    		// arrange
        Basket basket = new Basket();
        
        // act
        for (int i = 0; i < 6; i++) {
            basket.addBook(new Book("Title" + i, "Author" + i, 25.99));
        }
        Checkout checkout = new Checkout();
        
        // assert
        assertEquals(152.8212, checkout.calculatePrice(basket), 0.01);
    }
    
    @Test
    public void test_CalculatePrice_ReturnsSumMinus10PercentPlusOtherDiscounts_WhenPassedBasketWithTenBooks() 
    {
        Basket basket = new Basket();
        for (int i = 0; i < 10; i++) {
            basket.addBook(new Book("Title" + i, "Author" + i, 25.99));
        }
        Checkout checkout = new Checkout();
        assertEquals(226.11299999999997, checkout.calculatePrice(basket), 0.01);
    }

}
