package fr.esisar.cs518.library.stateful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.esisar.cs518.library.entities.Author;
import fr.esisar.cs518.library.entities.Book;
import fr.esisar.cs518.library.stateless.local.IAuthorLocal;
import fr.esisar.cs518.library.stateless.local.IBookLocal;

@Stateful
public class Library {

	@EJB
	private IBookLocal bookInterface;
	
	@EJB
	private IAuthorLocal authorInterface;
	
	public List<Book> findBooks() {
		return bookInterface.findBooks();
	}
	
	public List<Author> findAuthors() {
		return authorInterface.findAuthors();
	}
	
	public List<Author> findAuthorsAndBooks() {
		return authorInterface.findAuthorsAndBooks();
	}
	
}
