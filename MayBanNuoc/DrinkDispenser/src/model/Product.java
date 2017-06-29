package model;

import java.util.Date;

public abstract class Product {
	protected String codeP;
	protected String nameP;
	protected Date manufactureDate;
	protected Date expiryDate;
	protected String producer;
	protected double price;
	protected int numberP;

	public Product() {
		super();
	}

	public Product(String codeP, String nameP, Date manufactureDate, Date expiryDate, String producer, double price,
			int numberP) {
		super();
		this.codeP = codeP;
		this.nameP = nameP;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.producer = producer;
		this.price = price;
		this.numberP = numberP;
	}

	public String getNameP() {
		return nameP;
	}

	public double getPrice() {
		return price;
	}

	public int getNumberP() {
		return numberP;
	}

	
}
