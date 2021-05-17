package com.shubh.book.rest.dao;

import java.util.List;

import com.shubh.book.rest.model.Book;


public interface BookDao {

	Book getBookById(int id);

	Book getBookByName(String bookName);

	List<Book> getBooksOfAuthor(String authorName);

	List<Book> getBooksInPriceRange(int min, int max);
}
