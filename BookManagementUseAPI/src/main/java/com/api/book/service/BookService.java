package com.api.book.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService
{
	@Autowired
	private BookRepository bookRepository;

	//Get all the books
	public List<Book> getAllBooks()
	{
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}

	//get single book by id
	public Book getBookById(int id)
	{
		Book book=null;
		try {			
			book = this.bookRepository.findById(id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	//adding the book to list
	public Book addBook(Book b)
	{
		Book result = bookRepository.save(b);
		return result;
	}

	//Delete book
	public void deleteBook(int id)
	{

		bookRepository.deleteById(id);
	}

	//update the Book
	public void updateBook(Book book, int bookId)
	{
		book.setId(bookId);
		bookRepository.save(book);
	}

}
