package fr.esisar.cs518.library.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import fr.esisar.cs518.library.entities.Author;
import fr.esisar.cs518.library.entities.Book;
import fr.esisar.cs518.library.stateful.Library;

@Named
@SessionScoped
public class LibraryController implements Serializable {
	private static final long serialVersionUID = 7566038626752931651L;
	
	@Inject
	private Library library;

	@Named
	private List<Book> books;
	
	@Named
	private List<Author> authors;

	public List<Book> getBooks() {
		return library.findBooks();
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Author> getAuthors() {
		return library.findAuthors();
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	

}
