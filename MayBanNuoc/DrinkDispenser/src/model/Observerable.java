package model;


public interface Observerable {

	public void registerObserver(MoneyObserver o);

	public void deleteObserver(MoneyObserver o);

	public void notifyObserver();

	public void setChange();
	
	
}
