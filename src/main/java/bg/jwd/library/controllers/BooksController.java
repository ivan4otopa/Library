package bg.jwd.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.jwd.library.entities.Book;
import bg.jwd.library.services.BookService;

@Controller
public class BooksController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "/bookRegistry", method = RequestMethod.GET)
	public String getBookRegistryPage(Model model) {
		model.addAttribute("books", bookService.getBooks());
		
		return "books/bookRegistry";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String getAddBookPage() {
		return "books/addBook";
	}
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book book) {
		bookService.addBook(book);
		
		return "redirect:/bookRegistry";
	}
	
	@RequestMapping(value = "/editBook", method = RequestMethod.GET)
	public String getEditBookPage() {
		return "books/editBook";
	}
	
	@RequestMapping(value = "/editBook", method = RequestMethod.POST)
	public String editBook(@ModelAttribute("book") Book book) {
		bookService.editBook(book);
		
		return "redirect:/bookRegistry";
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.GET)
	public String getDeleteBookPage() {
		return "books/deleteBook";
	}
	
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(long id) {
		bookService.deleteBook(id);
				
		return "redirect:/bookRegistry";
	}
	
	@RequestMapping(value = "/searchBooks", method = RequestMethod.GET)
	public String getSearchBooksPage() {
		return "books/searchBooks";
	}
	
	@RequestMapping(value = "/searchBooks", method = RequestMethod.POST)
	public String searchBooks(Model model, String criteria, String value) {
		model.addAttribute("books", bookService.searchBooks(criteria, value));
				
		return "books/bookRegistry";
	}
}
