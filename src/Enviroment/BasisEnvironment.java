package Enviroment;

import java.util.ArrayList;

import ObjectLayer.Contact;

public class BasisEnvironment {

	private static volatile BasisEnvironment instance = null;

	public static BasisEnvironment getInstance() {
		if (instance == null) {
			synchronized (BasisEnvironment.class) {
				if (instance == null) {
					instance = new BasisEnvironment();
				}
			}
		}
		return instance;
	}

	RefrigeratorEnvironment refrigiratorEnvironment;
	ArrayList<Contact> contactList;
	
	
	public ArrayList<Contact> getContactList() {
		return contactList;
	}


	private BasisEnvironment() {
		this.contactList = new ArrayList<Contact>();
	}
	
	

	
	

}
