package controller;

import java.util.List;

import model.Candy;
import model.Drinks;

public interface ControllerInter {
	public void clickAddMoney(int addMoney);
	
	public void clickResetMoney();

	public void clickBuyProductHot(String nameProductBuy);

	public void clickBuyProductCool(String nameProductBuy);

	public void clickBuyProductCandy(String nameProductBuy);


	public List<Drinks> displayDrinks();
	
	public List<Candy> displayCandy();
}
