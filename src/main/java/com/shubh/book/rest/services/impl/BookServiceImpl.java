package com.shubh.book.rest.services.impl;

import java.util.List;

import com.shubh.book.rest.dao.BookDao;
import com.shubh.book.rest.dao.impl.BookDaoImpl;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;

public class BookServiceImpl implements BookService {
	
	BookDao dao = new BookDaoImpl();

	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

	public Book getBookByName(String bookName) {
		return dao.getBookByName(bookName);
	}

	public List<Book> getBooksOfAuthor(String authorName) {
		return dao.getBooksOfAuthor(authorName);
	}

	public List<Book> getBooksInPriceRange(int min, int max) {
		return dao.getBooksInPriceRange(min, max);
	}

}
