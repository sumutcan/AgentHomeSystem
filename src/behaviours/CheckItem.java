package behaviours;

import java.util.ArrayList;
import java.util.Scanner;

import Enviroment.RefrigeratorEnvironment;
import ObjectLayer.RefrigeratorItem;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CheckItem extends TickerBehaviour {

	public CheckItem(Agent a, long period) {
		super(a, period);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		ArrayList<RefrigeratorItem> criticalItems = RefrigeratorEnvironment
				.getInstance().GetCriticalItems();

		if (!criticalItems.isEmpty() && criticalItems != null) {
			System.out.println(criticalItems);
			System.out.println("Would you like to buy the items?");
			Scanner sc = new Scanner(System.in);
			boolean result = sc.nextBoolean();

			if (result) {
				for (RefrigeratorItem item : criticalItems) {
					RefrigeratorEnvironment.getInstance().BuyItem(
							item,
							RefrigeratorEnvironment.getInstance()
									.getCriticalCount(),
							RefrigeratorEnvironment.getInstance()
									.getCriticalWeight());
					
					System.out.println("I bought some " + item.getItemName());
				}
			}

		}
	}

}
