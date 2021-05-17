package com.shubh.book.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;
import com.shubh.book.rest.services.impl.BookServiceImpl;

@RestController
@RequestMapping("/api")
public class BookController {
	
	BookService bookService = new BookServiceImpl();

	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable(value="id") int id) {
		return bookService.getBookById(id);
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
