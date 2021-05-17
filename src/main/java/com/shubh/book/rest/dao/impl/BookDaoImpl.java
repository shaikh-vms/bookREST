package com.shubh.book.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.shubh.book.rest.dao.BookDao;
import com.shubh.book.rest.model.Book;

public class BookDaoImpl  implements BookDao{

	List<Book> list;
	Book book;
	
	public BookDaoImpl(){
		list = new ArrayList<Book>();
		book = new Book(1, "Few Lines", "Mr. Robert Dweyen", 100);
		list.add(book);
		book = new Book(2, "World of Animals", "Robin Sharma", 10);
		list.add(book);
		book = new Book(3, "Night in jungle", "Mr. Robert Dweyen", 120);
		list.add(book);
		book = new Book(4, "Love birds", "Rajshekhar TN", 530);
		list.add(book);
	}

	public Book getBookById(int id) {
		return list.get(id);
	}

	public Book getBookByName(String bookName) {
		Book result = null;
		for (Book book : list) {
			if(book.getName().equals(bookName))
				result =  book;
		}
		return result;
	}

	public List<Book> getBooksOfAuthor(String authorName) {
		List<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if (book.getAuthor().equalsIgnoreCase(authorName))
				result.add(book);
		}
		return result;
	}

	public List<Book> getBooksInPriceRange(int min, int max) {
		List<Book> result = new ArrayList<Book>();
		for (Book book : list) {
			if ( book.getPrice() >= min && book.getPrice()<=max)
				result.add(book);
		}
		return result;
	}
}
