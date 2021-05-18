package com.shubh.book.rest.services.impl;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.dao.BookDao;
import com.shubh.book.rest.dao.impl.BookDaoImpl;
import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;
import com.shubh.book.rest.services.BookService;
import com.shubh.book.rest.util.Error;
import com.shubh.book.rest.util.IdGenerator;

public class BookServiceImpl implements BookService {
	
	BookDao dao = new BookDaoImpl();

		public List<Book> getBooksOfAuthor(String authorName) throws SQLException, BookException {
		
		List<Book> list = dao.getBooksOfAuthor(authorName);
		if(list.size()!=0)
			return list;
		else
			throw new BookException(Error.NOT_FOUND_BY_AUTHOR+authorName);
	}

	public List<Book> getBooksInPriceRange(int min, int max) throws SQLException,BookException {
		if(min>max) {
			int tmp = min;
			min =max;
			max = tmp;
		}
		List<Book> list = dao.getBooksInPriceRange(min, max);
		if(list.size()!=0)
			return list;
		else
			throw new BookException(Error.NOT_FOUND_IN_RANGE,min,max);
	}

	@Override
	public Book getBookById(int id) throws BookException, SQLException {
		if(dao.getBookById(id)!=null)
			return dao.getBookById(id);
		else
			throw new BookException(Error.NOT_FOUND_BY_ID,id);
	}

	@Override
	public Book createBook(Book book) throws SQLException, BookException {
		book.setId(IdGenerator.get());
		Book bookResult= dao.createBook(book);
		if(bookResult!=null)
			return bookResult;
		else
			throw new BookException(Error.NOT_CREATED);
	}

}
