package fr.esisar.cs518.library.stateless.local;

import java.util.List;

import javax.ejb.Local;

import fr.esisar.cs518.library.entities.Book;

@Local
public interface IBookLocal {
	
	public Book createBook(Book book);
	
	public Book getBookById(Long bookId);
	
	public List<Book> findBooks();
	
	public Book updateBook(Book book);
	
	public void deleteBook(Book book);
}
