package lu.atozdigital.api.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lu.atozdigital.api.entities.Article;

public class OrderDto {

	private String reference;
	private Date date;
	private List<Article> articles = new ArrayList<>();

	public OrderDto() {
		super();
	}

	public OrderDto(String reference, Date date, List<Article> articles) {
		super();
		this.reference = reference;
		this.date = date;
		this.articles = articles;
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

}
