package controller;

import java.util.List;

import model.Model;
import model.ModelInter;
import model.Candy;
import model.Drinks;

public class Controller implements ControllerInter {
	ModelInter model;

	public Controller(ModelInter model) {
		super();
		this.model = model;
	}

	public void clickAddMoney(int addMoney) {
		model.setMoney(addMoney);
	}

	public void clickBuyProductHot(String nameProductBuy) {
		model.buyProductHot(nameProductBuy);

	}

	public void clickBuyProductCool(String nameProductBuy) {
		model.buyProductCool(nameProductBuy);

	}

	public void clickBuyProductCandy(String nameProductBuy) {
		model.buyProductCandy(nameProductBuy);

	}

	public void clickResetMoney() {
		model.resetMoney();
	}

	@Override
	public List<Drinks> displayDrinks() {
		return model.getListDrinks();
	}
	
	@Override
	public List<Candy> displayCandy() {
		return model.getListCandy();
	}


	

}
