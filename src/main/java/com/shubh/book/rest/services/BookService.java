package com.shubh.book.rest.services;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.exception.BookException;
import com.shubh.book.rest.model.Book;

public interface BookService {
	Book getBookById(int id) throws SQLException,BookException;
	List<Book> getBooksOfAuthor(String authorName) throws SQLException, BookException;
	List<Book> getBooksInPriceRange(int min, int max) throws SQLException, BookException;
	Book createBook(Book book) throws SQLException, BookException;
}

