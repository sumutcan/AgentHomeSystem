package ObjectLayer;

public class Contact {

	String name;
	String telNumber;
	
	public Contact ()
	{
		
	}
	
	public Contact (String name, String telNumber)
	{
		this.name = name;
		this.telNumber = telNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String toString()
	{
		return name;
	}
	
}
