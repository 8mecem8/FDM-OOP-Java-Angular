package main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.main.Basket;
import project.main.Book;

class BasketTest {

	@Test
	void test_GetBooksInBasket_ReturnsEmptyBookList_IfNoBooksHaveBeenAdded() 
	{
		// arrange
		Basket basket = new Basket();

		// act

		// assert
		assertEquals(0, basket.getBooksInBasket().size());
	}
	
	@Test
	public void test_GetBooksInBasket_ReturnsArrayOfLengthOne_AfterAddBookMethodIsCalledWithOneBook() 
	{
		// arrange
		Book aBook = new Book("test-title","test-Autor",31.72);
		Basket basket = new Basket();
		
		// act
		basket.addBook(aBook);
		
		// assert
		var bookInBasket = basket.getBooksInBasket();
		assertEquals(1, bookInBasket.size());
	}
	
	@Test
    public void test_GetBooksInBasket_ReturnsArrayOfLengthTwo_AfterAddBookMethodIsCalledWithTwoBooks() 
	{
		// arrange
        Basket basket = new Basket();
        Book book1 = new Book("Title1", "Author1", 10.0);
        Book book2 = new Book("Title2", "Author2", 15.0);
        
        // act
        basket.addBook(book1);
        basket.addBook(book2);
        
        // assert
        assertEquals(2, basket.getBooksInBasket().size());
    }

}
