package coordinators;

import java.util.ArrayList;
import java.util.List;

import util.Observer;

public class CoordinatorScheduler {
	
	private static CoordinatorScheduler coordinatorScheduler = null;
	
	private CoordinatorType coordinatorType;
	private List<Observer> observers;
	
	private CoordinatorScheduler() {
		coordinatorType = CoordinatorType.MAIN_MENU;
		observers = new ArrayList<Observer>();
	}
	//Singleton method
	public static CoordinatorScheduler getInstance() {
		if(coordinatorScheduler == null) {
			coordinatorScheduler = new CoordinatorScheduler();
		}
		return coordinatorScheduler;
	}
	
	/*
	 * Operations to modify the coordinatorType
	 */
	public void changeCoordinator(CoordinatorType coordinatorType) {
		this.coordinatorType = coordinatorType;
		notifyObservers();
	}
	
	public CoordinatorType getCoordinatorType() {
		return this.coordinatorType;
	}
	
	/*
	 * Operations for modifying observers
	 */
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void unregisterObserver(Observer observer) {
		observers.remove(observer);
	}
	
	public List<Observer> getObservers() {
		return this.observers;
	}
	
	private void notifyObservers() {
		for(Observer o : observers) {
			o.Notify();
		}
	}
}
