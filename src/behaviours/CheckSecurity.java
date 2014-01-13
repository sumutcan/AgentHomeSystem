package behaviours;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Enviroment.RefrigeratorEnvironment;
import Enviroment.SecurityProperties;
import ObjectLayer.RefrigeratorItem;
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
			if (listOfInsecurePlaces.size() > 0) {

				Object[] options = { "Call the police", "Do nothing" };
				JFrame frame = new JFrame();
				int n = JOptionPane
						.showOptionDialog(frame, insecurePlaces.toString(),
								"Message from Security Agent",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE, null, options,
								options[1]);

				if (n == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(frame,
							"Calling the police...");
					JOptionPane.showMessageDialog(frame,
							"Security breach terminated.");
				} else {
					JOptionPane.showMessageDialog(frame,
							"Well... You're the boss.");
				}
				
				SecurityProperties.getInstance().setAllToSecure();
			}

		}
	}
}
