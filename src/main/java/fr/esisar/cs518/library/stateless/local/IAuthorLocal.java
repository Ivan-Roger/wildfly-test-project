package fr.esisar.cs518.library.stateless.local;

import java.util.List;

import javax.ejb.Local;

import fr.esisar.cs518.library.entities.Author;

@Local
public interface IAuthorLocal {
	
	public Author createAuthor(Author author);
	
	public Author getAuthorById(Long id);

	public List<Author> findAuthors();
	
	public List<Author> findAuthorsAndBooks();
	
	public Author updateAuthor(Author author);
	
	public void deleteAuthor(Author author);
}
