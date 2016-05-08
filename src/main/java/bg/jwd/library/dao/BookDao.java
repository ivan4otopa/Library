package bg.jwd.library.dao;

import java.util.List;

import bg.jwd.library.entities.Book;

public interface BookDao {
	List<Book> getBooks();
	
	boolean addBook(Book book);
	
	boolean editBook(Book book);
	
	boolean deleteBook(long id);
	
	List<Book> searchBooks(String criteria, String value); 
}
