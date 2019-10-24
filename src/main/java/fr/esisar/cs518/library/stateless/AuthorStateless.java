package fr.esisar.cs518.library.stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.esisar.cs518.library.entities.Author;
import fr.esisar.cs518.library.stateless.local.IAuthorLocal;

@Stateless
public class AuthorStateless implements IAuthorLocal {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	public Author createAuthor(Author author) {
		em.persist(author);
		return author;
	}

	public Author getAuthorById(Long id) {
		return em.find(Author.class, id);
	}

	public List<Author> findAuthors() {
		TypedQuery<Author> q = em.createNamedQuery("findAuthors", Author.class);
		return q.getResultList();
	}

	public Author updateAuthor(Author author) {
		return em.merge(author);
	}

	public void deleteAuthor(Author author) {
		em.remove(em.merge(author));
	}

}
