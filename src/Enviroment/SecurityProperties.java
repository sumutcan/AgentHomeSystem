package Enviroment;

import java.util.ArrayList;

public class SecurityProperties {

	private String[] namesOfCheckPoints = new String[] { "Front Door",
			"Back Door", "Window 1", "Window 2", "Window 3", "Window 4",
			"Public Network", "Private Network" };

	private boolean[] isSecure = new boolean[] { true, true, true, true, true,
			true, true, true };

	private static volatile SecurityProperties instance = null;

	private SecurityProperties() {

	}

	public static synchronized SecurityProperties getInstance() {
		if (instance == null)
			instance = new SecurityProperties();

		return instance;
	}

	public ArrayList<String> getListOfInsecureCheckPoints() {
		ArrayList<String> msgList = new ArrayList<String>();
		for (int i = 0; i < this.isSecure.length; i++) {
			boolean checkPoint = this.isSecure[i];
			if (!checkPoint) {
				msgList.add(this.namesOfCheckPoints[i]);
			}
		}

		return msgList;
	}

	public String getNamesOfInsecureCheckPoints() {
		ArrayList<String> msgList = getListOfInsecureCheckPoints();

		String msg;

		if (msgList.size() > 0) {
			msg = "Found insecure check point(s)!\nCount: " + msgList.size()
					+ "\nComplete List:\n";

			for (String checkPoint : msgList) {
				msg += checkPoint + "\n";
			}
		} else {
			msg = "There is no insecure check point(s) found.";
		}

		return msg;
	}
	
	public void changeState(int index)
	{
		if(index > -1 && index < this.isSecure.length)
		{
			this.isSecure[index] = !this.isSecure[index];
		}
	}
	
	public void setAllToSecure()
	{
		for (int i = 0; i < this.isSecure.length; i++) {
			this.isSecure[i] = true;
		}
	}

	public String[] getNamesOfCheckPoints() {
		return namesOfCheckPoints;
	}

	public boolean[] getIsSecure() {
		return isSecure;
	}
	
	
	
	

}
