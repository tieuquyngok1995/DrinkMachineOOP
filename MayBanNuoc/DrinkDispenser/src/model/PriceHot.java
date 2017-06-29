package model;

public class PriceHot implements PriceStrategy{

	@Override
	public double getChangeMoney(double gia) {
		double sotien;
		sotien = gia + (gia *0.2);
		return sotien;
	}

}
