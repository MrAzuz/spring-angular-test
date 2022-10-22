package lu.atozdigital.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ORDERS")

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String reference;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE })
	@JoinTable(name = "ORDER_PRODUCTS", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<Article> articles = new ArrayList<>();

	public Order() {
		super();
	}

	public Order(String reference, Date date, List<Article> articles) {
		super();
		this.reference = reference;
		this.date = date;
		this.articles = articles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", reference=" + reference + ", date=" + date + ", articles=" + articles + "]";
	}
	
	
	
	
	
	

}
