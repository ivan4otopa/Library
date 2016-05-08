package bg.jwd.library.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "lends")
public class Lend {
	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	private long id;
	@Column(name = "book_Id")
	private long bookId;
	@Column(name = "client_id")
	private long clientId;
	private int period;
	@Column(name = "date_of_lending")
	private Date dateOfLending;
	@Column(name = "date_of_return")
	private Date dateOfReturn;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id", insertable = false, updatable = false)
	private Book book;		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", insertable = false, updatable = false)
	private Client client;			

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getBookId() {
		return bookId;
	}
	
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	public long getClientId() {
		return clientId;
	}
	
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	
	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period) {
		this.period = period;
	}
	
	public Date getDateOfLending() {
		return dateOfLending;
	}
	
	public void setDateOfLending(Date dateOfLending) {
		this.dateOfLending = dateOfLending;
	}
	
	public Date getDateOfReturn() {
		return dateOfReturn;
	}
	
	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
