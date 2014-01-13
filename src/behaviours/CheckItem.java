package behaviours;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

			Object[] options = { "Yes, please", "No, thanks"};
			JFrame frame = new JFrame();
			int n = JOptionPane.showOptionDialog(frame, criticalItems.toString() +
					"\nWould you like to buy the items?",
					"Message from Refrigerator Agent", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

			if (n == JOptionPane.YES_OPTION) {
				for (RefrigeratorItem item : criticalItems) {
					RefrigeratorEnvironment.getInstance().BuyItem(
							item,
							RefrigeratorEnvironment.getInstance()
									.getCriticalCount(),
							RefrigeratorEnvironment.getInstance()
									.getCriticalWeight());
					JOptionPane.showMessageDialog(frame,"I bought some " + item.getItemName());
				}
			}

		}
	}

}
