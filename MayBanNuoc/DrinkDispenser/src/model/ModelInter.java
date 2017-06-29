package model;

import java.util.List;

public interface ModelInter {
	public List<Drinks> getListDrinks() ;
	
	public List<Candy> getListCandy();
	
	public void setMoney(double moneyChange);
	
	public void resetMoney() ;
	
	public void buyProductCool(String nameProductBuy);

	public void buyProductHot(String nameProductBuy);

	public void buyProductCandy(String nameProductBuy);

	public void registerObserver(MoneyObserver o);

	public void deleteObserver(MoneyObserver o);

	public void notifyObserver();

	public void setChange();
}
