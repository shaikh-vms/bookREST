package com.shubh.book.rest.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.dao.BookDao;
import com.shubh.book.rest.dao.impl.BookDaoImpl;
import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;
import com.shubh.book.rest.util.Error;

public class BookServiceImpl implements BookService {
	
	BookDao dao = new BookDaoImpl();

	public Book getBookByName(String bookName) {
		return dao.getBookByName(bookName);
	}

	public List<Book> getBooksOfAuthor(String authorName) {
		return dao.getBooksOfAuthor(authorName);
	}

	public List<Book> getBooksInPriceRange(int min, int max) {
		return dao.getBooksInPriceRange(min, max);
	}

	@Override
	public Book getBookById(int id) throws BookException, SQLException {
		if(dao.getBookById(id)!=null)
			return dao.getBookById(id);
		else
			throw new BookException(Error.NOT_FOUND_BY_ID,id);
	}

}
