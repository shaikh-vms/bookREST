package com.shubh.book.rest.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;
import com.shubh.book.rest.services.impl.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class BookController {
	
	BookService bookService = new BookServiceImpl();

	
	@GetMapping("/book/{id}")
	@ResponseBody
	public ResponseEntity<?> getBookById(@PathVariable(value="id") int id) {
		ResponseEntity<?> response;
		try {
			response = ResponseEntity.ok(bookService.getBookById(id));
		} catch (SQLException e) {
			response=ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		} catch (BookException e) {
			response= ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/book")
	public Book getBookByName(@RequestParam(value="name") String bookName) {
		return bookService.getBookByName(bookName);
	}
	
	@GetMapping("/books")
	public List<Book> getBooksOfAuthor(@RequestParam(value="author")String authorName){
		return bookService.getBooksOfAuthor(authorName);
	}
	@GetMapping("/books/in")
	public List<Book> getBooksInPriceRange( @RequestParam(value="min")int min, @RequestParam(value="max")int max){
		return bookService.getBooksInPriceRange(min, max);
	}
}
