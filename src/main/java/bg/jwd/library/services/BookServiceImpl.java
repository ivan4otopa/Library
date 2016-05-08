package bg.jwd.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.BookDao;
import bg.jwd.library.entities.Book;

@Service
public class BookServiceImpl implements BookService {	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public List<Book> getBooks() {
		return bookDao.getBooks();
	}

	@Override
	public boolean addBook(Book book) {
		return bookDao.addBook(book);		
	}

	@Override
	public boolean editBook(Book book) {
		return bookDao.editBook(book);
	}

	@Override
	public boolean deleteBook(long id) {
		return bookDao.deleteBook(id);
	}

	@Override
	public List<Book> searchBooks(String criteria, String value) {
		return bookDao.searchBooks(criteria, value);
	}
}
