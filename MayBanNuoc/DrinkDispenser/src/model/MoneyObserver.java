package model;


public interface MoneyObserver{


	public void updateMoney (double money);

	public void updateBuy(boolean buyOk,double priceBuy);
	
	public void resetMoney (double money);


}
