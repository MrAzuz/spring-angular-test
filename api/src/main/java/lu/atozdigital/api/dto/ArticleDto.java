package lu.atozdigital.api.dto;

import java.math.BigDecimal;

public class ArticleDto {
	private String name;
	private BigDecimal price;
	
	//private String picture;

	public ArticleDto() {
		super();
	}

	public ArticleDto(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
		//this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/*
	 * public String getPicture() { return picture; }
	 */

	/*
	 * public void setPicture(String picture) { this.picture = picture; }
	 */

}
