package project;

import java.time.LocalDate;


public class DtoMerchandise {
	private int id;
	private String category;
	private String name;
	private int quantity;
	private int price;
	private LocalDate expiration_date;
	
	public DtoMerchandise(int id, String category, String name, int quantity, int price, LocalDate expiration_date) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.expiration_date = expiration_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(LocalDate expiration_date) {
		this.expiration_date = expiration_date;
	}

	@Override
	public String toString() {
		return "DtoMerchandise [id=" + id + ", category=" + category + ", name=" + name + ", quantity=" + quantity
				+ ", price=" + price + ", expiration_date=" + expiration_date + "]";
	}
	
	
	
	

}
