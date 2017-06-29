package model;

import java.util.Date;

public class Candy extends Product {

	public Candy(String codeP, String nameP, Date manufactureDate, Date expiryDate, String producer, double price,
			int numberP) {
		super(codeP, nameP, manufactureDate, expiryDate, producer, price, numberP);
	}

	public Candy() {
	}

}
