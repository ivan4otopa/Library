package bg.jwd.library.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	private long id;
	private String name;
	private String author;
	@Column(name = "year_of_publishing")
	private int yearOfPublishing;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private Set<Lend> lends = new HashSet<>();
		
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getYearOfPublishing() {
		return yearOfPublishing;
	}
	
	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	
	public Set<Lend> getLends() {
		return lends;
	}

	public void setLends(Set<Lend> lends) {
		this.lends = lends;
	}
}
