package ObjectLayer;

public class RefrigiratorItem {

	String itemName;
	int count;
	double weight;
	
	public RefrigiratorItem(String _itemName, int _count) {
		this.itemName = _itemName;
		this.count = _count;
	}
	
	public RefrigiratorItem(String _itemName, double _weight)
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
