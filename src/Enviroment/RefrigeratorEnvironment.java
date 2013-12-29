package Enviroment;

import java.util.ArrayList;

import ObjectLayer.RefrigeratorItem;

public class RefrigeratorEnvironment {

	ArrayList<RefrigeratorItem> items;
	int criticalCount;
	double criticalWeight;

	public RefrigeratorEnvironment() {
		this.items = new ArrayList<RefrigeratorItem>();
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

	public void GetCriticalItems() {
		String allItemsString = "";
		for (RefrigeratorItem item : this.items) {

			if (item.isBasedOnCount()) {
				if (item.isOnCriticalLevel(this.criticalCount))
					allItemsString += item.toString();
			} else {
				if (item.isOnCriticalLevel(this.criticalWeight))
					allItemsString += item.toString();
			}

		}
	}

	public void BuyItemByCount(RefrigeratorItem item, int count) {
		item.setCount(item.getCount() + count);
	}

	public void BuyItemByWeight(RefrigeratorItem item, double weight) {
		item.setWeight(item.getWeight() + weight);
	}

}
