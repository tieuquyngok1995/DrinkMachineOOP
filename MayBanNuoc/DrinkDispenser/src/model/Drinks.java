package model;

import java.util.Date;

public class Drinks extends Product {
	private boolean isHot;

	public Drinks() {
		super();
	}

	public Drinks(boolean isHot) {
		super();
		this.isHot = isHot;
	}

	public Drinks(String codeP, String nameP, Date manufactureDate, Date expiryDate, String producer, double price,
			int numberP, boolean isHot) {
		super(codeP, nameP, manufactureDate, expiryDate, producer, price, numberP);
		this.isHot = isHot;
	}
	
	public boolean isHot() {
		return isHot;
	}

	public void setHot(boolean isHot) {
		this.isHot = isHot;
	}
	
}
