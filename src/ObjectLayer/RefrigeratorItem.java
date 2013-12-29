package ObjectLayer;

public class RefrigeratorItem {

	String itemName;
	int count;
	double weight;
	
	public RefrigeratorItem(String _itemName, int _count) {
		this.itemName = _itemName;
		this.count = _count;
	}
	
	public RefrigeratorItem(String _itemName, double _weight)
	{
		this.itemName = _itemName;
		this.weight = _weight;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	

}
