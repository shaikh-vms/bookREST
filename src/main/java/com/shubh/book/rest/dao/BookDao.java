package com.shubh.book.rest.dao;

import java.sql.SQLException;
import java.util.List;

import com.shubh.book.rest.model.Book;


public interface BookDao {

	Book getBookById(int id) throws SQLException;

	List<Book> getBooksOfAuthor(String authorName) throws SQLException;

	List<Book> getBooksInPriceRange(int min, int max) throws SQLException;

	Book createBook(Book book) throws SQLException;
}
