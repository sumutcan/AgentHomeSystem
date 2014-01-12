package Enviroment;

import java.util.ArrayList;

import ObjectLayer.RefrigeratorItem;

public class RefrigeratorEnvironment {

	ArrayList<RefrigeratorItem> items;
	private int criticalCount;
	private double criticalWeight;
	private static RefrigeratorEnvironment instance = null;
	
	private RefrigeratorEnvironment()
	{
		this.items = new ArrayList<RefrigeratorItem>();
	}
	
	public synchronized static RefrigeratorEnvironment getInstance()
	{
		if (instance == null)
		{
			instance = new RefrigeratorEnvironment();
		}
		
		return instance;
	}

	public void AddItemToRefrigirator(RefrigeratorItem newItem) {
		this.items.add(newItem);
	}

	public void AddNewConsumption(RefrigeratorItem consumedItem, int consumption) {
		for (RefrigeratorItem item : this.items) {
			if (item.getItemName().equals(consumedItem.getItemName())) {
				if (item.isBasedOnCount()) {
					item.setCount(item.getCount() - consumption);
				} else {
					System.out
							.println("This item cannot be consumed by count.");
				}
			}
		}
	}

	public void AddNewConsumption(RefrigeratorItem consumedItem,
			double consumption) {
		for (RefrigeratorItem item : this.items) {
			if (item.getItemName().equals(consumedItem.getItemName())) {
				if (!item.isBasedOnCount()) {
					item.setWeight(item.getWeight() - consumption);
				} else {
					System.out
							.println("This item cannot be consumed by weight.");
				}
			}
		}
	}

	public ArrayList<RefrigeratorItem> GetCriticalItems() {
		ArrayList<RefrigeratorItem> criticalItems = new ArrayList<RefrigeratorItem>();
		for (RefrigeratorItem item : this.items) {

			if (item.isBasedOnCount()) {
				if (item.isOnCriticalLevel(this.criticalCount))
					criticalItems.add(item);
			} else {
				if (item.isOnCriticalLevel(this.criticalWeight))
					criticalItems.add(item);
			}

		}
		
		return criticalItems;
	}

	
	
	public void BuyItem(RefrigeratorItem item,  int count, double weight) {
		
		if (item.isBasedOnCount())
			item.setCount(item.getCount() + count);
		else
			item.setWeight(item.getWeight() + weight);
	}



	public int getCriticalCount() {
		return criticalCount;
	}

	public void setCriticalCount(int criticalCount) {
		this.criticalCount = criticalCount;
	}

	public double getCriticalWeight() {
		return criticalWeight;
	}

	public void setCriticalWeight(double criticalWeight) {
		this.criticalWeight = criticalWeight;
	}

}
