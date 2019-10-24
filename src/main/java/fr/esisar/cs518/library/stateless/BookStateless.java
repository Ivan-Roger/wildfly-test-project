package fr.esisar.cs518.library.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.esisar.cs518.library.entities.Book;
import fr.esisar.cs518.library.stateless.local.IBookLocal;

@Stateless
public class BookStateless implements IBookLocal {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public Book getBookById(Long bookId) {
		return em.find(Book.class, bookId);
	}

	public List<Book> findBooks() {
		TypedQuery<Book> q = em.createNamedQuery("findBooks", Book.class);
		return q.getResultList();
	}

	public List<Book> findBooksWithAuthors() {
		TypedQuery<Book> q = em.createNamedQuery("findBooksWithAuthors", Book.class);
		return q.getResultList();
	}

	public Book updateBook(Book book) {
		return em.merge(book);
	}

	public void deleteBook(Book book) {
		em.remove(em.merge(book));
	}

}
