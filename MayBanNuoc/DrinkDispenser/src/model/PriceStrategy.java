package model;

public interface PriceStrategy {
	public static final PriceStrategy PRICEHOT = new PriceHot();
	public static final PriceStrategy PRICECOOL = new PriceCool();
	public static final PriceStrategy PRICECANDY = new PriceCandy();

	abstract public double getChangeMoney(double gia);
	
}
