package Enviroment;

import java.util.ArrayList;

import ObjectLayer.RefrigeratorItem;

public class RefrigeratorEnvironment {
	
	ArrayList<RefrigeratorItem> items;
	int criticalLevel;
	double criticalWeight;
	
	public RefrigeratorEnvironment()
	{
		this.items = new ArrayList<RefrigeratorItem>();
	}
	
	public void AddItemToRefrigirator(RefrigeratorItem newItem)
	{
		this.items.add(newItem);
	}
	
	public void AddNewConsumption(RefrigeratorItem consumedItem, int consumption)
	{
		for (RefrigeratorItem item : this.items) {
			if(item.getItemName().equals(consumedItem.getItemName()))
			{
				item.setCount(item.getCount() - consumption);
			}
		}
	}
	
	public void AddNewConsumption(RefrigeratorItem consumedItem, double consumption)
	{
		for (RefrigeratorItem item : this.items) {
			if(item.getItemName().equals(consumedItem.getItemName()))
			{
				item.setWeight(item.getWeight() - consumption);
			}
		}
	}
	
	//public String GetCriticalLevel()
	
	
}
