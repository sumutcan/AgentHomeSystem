package behaviours;

import java.util.ArrayList;
import java.util.Scanner;

import Enviroment.RefrigeratorEnvironment;
import Enviroment.SecurityProperties;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CheckSecurity extends TickerBehaviour {

	public CheckSecurity(Agent a, long time) {
		super(a, time);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTick() {
		// TODO Auto-generated method stub
		ArrayList<String> listOfInsecurePlaces = SecurityProperties
				.getInstance().getListOfInsecureCheckPoints();

		String insecurePlaces = SecurityProperties.getInstance()
				.getNamesOfInsecureCheckPoints();

		if (!insecurePlaces.isEmpty() && insecurePlaces != null) {

			System.out.println(insecurePlaces);

			if (listOfInsecurePlaces.size() > 0)
			{
				Scanner s = new Scanner(System.in);
				System.out.println("Options\n- Call the police(1)\n- Do nothing(Other)\n\nYour selection is: ");
				String selection = s.next();
				
				if(selection.equals("1"))
				{
					System.out.println("Calling the police...\nSecurity breach terminated.");
				}
				SecurityProperties.getInstance().setAllToSecure();
			}
		}
	}
}
