package fr.esisar.cs518.library.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findBooks", query = "SELECT b FROM Book b")
})
public class Book implements Serializable {
	private static final long serialVersionUID = 3073713518399100981L;

	// ------- Attributes ------- 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idBook;
	
	private String title;
	
	@ManyToOne
	private Author author;
	
	// ------- Constructors -------
	public Book() {
		super();
	}

	public Book(Long idBook, String title, Author author) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.author = author;
	}

	public Book(String title, Author author) {
		super();
		this.title = title;
		this.author = author;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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
