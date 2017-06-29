package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Model implements ModelInter {
	private ArrayList<MoneyObserver> observer;
	private List<Drinks> listDrinks;
	private List<Candy> listCandy;
	private double money, priceBuy = 0;
	private boolean buyOk;
	private PriceStrategy price;

	public Model() {
		observer = new ArrayList<>();
		setup();
	}

	public Model(List<Drinks> listDrinks, List<Candy> listCandy, double money) {
		super();
		this.listDrinks = listDrinks;
		this.listCandy = listCandy;
		this.money = money;
		setup();
	}

	private void setup() {
		Drinks drink1 = new Drinks("DU001", "Coca", new GregorianCalendar(2017, Calendar.NOVEMBER, 16).getTime(),
				new GregorianCalendar(2018, Calendar.NOVEMBER, 16).getTime(), "Cocacola Thu Duc", 12000, 1, false);
		Drinks drink2 = new Drinks("DU002", "Tea", new GregorianCalendar(2017, Calendar.MAY, 26).getTime(),
				new GregorianCalendar(2017, Calendar.OCTOBER, 26).getTime(), "Trà Tâm Châu", 15000, 20, true);
		Drinks drink3 = new Drinks("DU003", "Cafe", new GregorianCalendar(2017, Calendar.NOVEMBER, 16).getTime(),
				new GregorianCalendar(2017, Calendar.NOVEMBER, 16).getTime(), "Cafe Nguyên Anh",
				18000, 25, true);
		listDrinks = new ArrayList<Drinks>();
		listDrinks.add(drink1);
		listDrinks.add(drink2);
		listDrinks.add(drink3);
		//
		Candy candy1 = new Candy("BK001", "Oishi", new GregorianCalendar(2016, Calendar.NOVEMBER, 16).getTime(),
				new GregorianCalendar(2018, Calendar.NOVEMBER, 16).getTime(), "BBCA Binh Duong",
				5000, 50);
		Candy candy2 = new Candy("BK002", "Snack", new GregorianCalendar(2016, Calendar.NOVEMBER, 16).getTime(),
				new GregorianCalendar(2018, Calendar.NOVEMBER, 16).getTime(), "BBCA Bien Hoa",
				7000, 70);
		Candy candy3 = new Candy("BK003", "Bim Bim", new GregorianCalendar(2016, Calendar.NOVEMBER, 16).getTime(),
				new GregorianCalendar(2018, Calendar.NOVEMBER, 16).getTime(), "CS Binh Duong",
				8500, 80);
		listCandy = new ArrayList<Candy>();
		listCandy.add(candy1);
		listCandy.add(candy2);
		listCandy.add(candy3);

	}

	public List<Drinks> getListDrinks() {
		return listDrinks;
	}

	public List<Candy> getListCandy() {
		return listCandy;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double moneyChange) {
		money += moneyChange;
		setChange();
	}

	public double getChangeMoney(double priceChange) {
		return price.getChangeMoney(priceChange);
	}

	public void resetMoney() {
		money = 0;
		setChange();
	}
	
	public void buyProductCool(String nameProductBuy) {
		for (Drinks drink : listDrinks) {
			if (nameProductBuy.equals(drink.nameP) && drink.numberP > 0 && money >= drink.price) {
				money -= PriceStrategy.PRICECOOL.getChangeMoney(drink.price);
				priceBuy = PriceStrategy.PRICECOOL.getChangeMoney(drink.price);
				drink.numberP--;
				buyOk = true;
				break;
			} else {
				buyOk = false;
				continue;
			}

		}
		setChange();
	}

	public void buyProductHot(String nameProductBuy) {
		for (Drinks drink : listDrinks) {
			if (nameProductBuy.equals(drink.nameP) && drink.numberP > 0 && money >= drink.price) {
				money -= PriceStrategy.PRICEHOT.getChangeMoney(drink.price);
				priceBuy = PriceStrategy.PRICEHOT.getChangeMoney(drink.price);
				drink.numberP--;
				buyOk = true;
				break;
			} else {
				buyOk = false;
				continue;
			}

		}
		setChange();
	}

	public void buyProductCandy(String nameProductBuy) {
		for (Candy candy : listCandy) {
			if (nameProductBuy.equals(candy.nameP) && candy.numberP > 0 && money >= candy.price) {
				money -= PriceStrategy.PRICECANDY.getChangeMoney(candy.price);
				priceBuy = PriceStrategy.PRICECANDY.getChangeMoney(candy.price);
				candy.numberP--;
				buyOk = true;
				break;
			} else {
				buyOk = false;
				continue;
			}

		}
		setChange();
	}


	@Override
	public void registerObserver(MoneyObserver o) {
		observer.add(o);

	}

	@Override
	public void deleteObserver(MoneyObserver o) {
		int j = observer.indexOf(o);
		if (j >= 0) {
			observer.remove(j);
		}

	}

	@Override
	public void notifyObserver() {
		for (int i = 0; i < observer.size(); i++) {
			MoneyObserver oserver = (MoneyObserver) observer.get(i);
			oserver.updateMoney(money);
			oserver.updateBuy(buyOk, priceBuy);
			oserver.resetMoney(money);
		}

	}

	@Override
	public void setChange() {
		notifyObserver();
	}

}
