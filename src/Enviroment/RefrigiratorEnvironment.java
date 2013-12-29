package Enviroment;

import java.util.ArrayList;

import ObjectLayer.RefrigiratorItem;

public class RefrigiratorEnvironment {
	
	ArrayList<RefrigiratorItem> items;
	int criticalLevel;
	double criticalWeight;
	
	public RefrigiratorEnvironment()
	{
		this.items = new ArrayList<RefrigiratorItem>();
	}
	
	public void AddItemToRefrigirator(RefrigiratorItem newItem)
	{
		this.items.add(newItem);
	}
	
	public void AddNewConsumption(RefrigiratorItem consumedItem, int consumption)
	{
		for (RefrigiratorItem item : this.items) {
			if(item.getItemName().equals(consumedItem.getItemName()))
			{
				item.setCount(item.getCount() - consumption);
			}
		}
	}
	
	public void AddNewConsumption(RefrigiratorItem consumedItem, double consumption)
	{
		for (RefrigiratorItem item : this.items) {
			if(item.getItemName().equals(consumedItem.getItemName()))
			{
				item.setWeight(item.getWeight() - consumption);
			}
		}
	}
	
	//public String GetCriticalLevel()
	
	
}
