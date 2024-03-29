package fr.esisar.cs518.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBooks", query = "SELECT b FROM Book b"),
	@NamedQuery(name = "findBooksWithAuthors", query = "SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors")
})
public class Book implements Serializable {
	private static final long serialVersionUID = 3073713518399100981L;

	// ------- Attributes ------- 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBook;
	
	private String title;
	
	@ManyToMany(mappedBy="books")
	private List<Author> authors;
	
	// ------- Constructors -------
	public Book() {
		super();
	}

	public Book(Long idBook, String title, List<Author> authors) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.authors = authors;
	}

	public Book(String title, List<Author> authors) {
		super();
		this.title = title;
		this.authors = authors;
	}
	
	// ------- Getters & Setters -------
	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	// ------- Object methods -------
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBook == null) ? 0 : idBook.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (idBook == null) {
			if (other.idBook != null)
				return false;
		} else if (!idBook.equals(other.idBook))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", title=" + title + "]";
	}

}
