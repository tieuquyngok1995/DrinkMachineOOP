package model;

public class PriceCandy implements PriceStrategy {

	@Override
	public double getChangeMoney(double gia) {
		
		return gia;
	}

}
