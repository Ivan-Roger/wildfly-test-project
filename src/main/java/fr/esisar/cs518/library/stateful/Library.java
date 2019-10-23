package fr.esisar.cs518.library.stateful;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.esisar.cs518.library.entities.Book;
import fr.esisar.cs518.library.stateless.local.IBookLocal;

@Stateful
public class Library {
	
	@EJB
	private IBookLocal bookInterface;
	
	public List<Book> findBooks() {
		return bookInterface.findBooks();
	}
	
}
