package main.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import main.java.Book;
import main.java.Catalogue;
import main.java.ReadItemCommand;
import main.java.WriteItemCommand;

class CatalogueTest {

    Catalogue catalogue;

    @Mock
    ReadItemCommand readItemCommand;

    @Mock
    WriteItemCommand writeItemCommand;

    @BeforeEach
    void setUp() 
    {
        MockitoAnnotations.openMocks(this);
        catalogue = new Catalogue(readItemCommand, writeItemCommand);
    }

    @Test
    void getAllBooks_ReturnsEmptyBookList_IfNoBooksAreInTheCatalogue() 
    {
        when(readItemCommand.readAll()).thenReturn(Collections.emptyList());
        List<Book> books = catalogue.getAllBooks();
        assertEquals(0, books.size());
    }

    @Test
    void getAllBooks_CallsReadAllMethodOfReadItemCommand_WhenCalled() 
    {
        catalogue.getAllBooks();
        verify(readItemCommand).readAll();
    }

    @Test
    void getAllBooks_ReturnsListOfBooksItReceivesFromReadAllMethodOfReadItemCommand_WhenCalled() 
    {
        List<Book> mockBooks = Arrays.asList(new Book("Title1", "Author1", "ISBN1", 10.0, 100));
        when(readItemCommand.readAll()).thenReturn(mockBooks);
        List<Book> books = catalogue.getAllBooks();
        assertEquals(mockBooks, books);
    }
    
    @Test
    void addBook_PassesBookToInsertItemMethodOfWriteItemCommand() 
    {
        Book book = new Book("Title", "Author", "ISBN", 10.0, 100);
        catalogue.addBook(book);
        verify(writeItemCommand).insertItem(book);
    }
    
    
    @Test
    void addBooks_CallsInsertItemMethodOfWriteItemCommand_ForEachBook() 
    {
    		List<Book> multiBooks = Arrays.asList(new Book("Title1", "Author1", "ISBN1", 10.0, 100), new Book("Title2", "Author2", "ISBN2", 20.0, 200));
    		catalogue.addBooks(multiBooks);
    		
    		for(var arg : multiBooks){verify(writeItemCommand).insertItem(arg);}
    }
    
    @Test
    public void getBook_ReturnsBookWithGivenISBN_FromReadItemCommand() 
    {
    		List<Book> multiBooks = Arrays.asList(new Book("Title1", "Author1", "ISBN1", 10.0, 100), new Book("Title2", "Author2", "ISBN2", 20.0, 200));
    		Book filteredBook = multiBooks.stream().filter(book -> book.isbn.equals("ISBN2")).findFirst().orElse(null);
    		String requestedBook = "ISBN2";   		
    		
    		when(readItemCommand.getItem(requestedBook)).thenReturn(filteredBook);
    		var requestedItemBook = catalogue.getBook(requestedBook);
    		
    		System.out.println(requestedItemBook.isbn);
    		verify(readItemCommand).getItem(requestedBook);
    		assertEquals(requestedItemBook.isbn, filteredBook.isbn);
    }

    
}
