package agents;

import utils.AgentSetup;
import behaviours.Alive;
import behaviours.CheckItem;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class RefrigeratorAgent extends Agent {

	public  void setup()
	{
		DFAgentDescription dfd = AgentSetup.agentSetup("Refrigerator","refrigerator");
		try {
			
			DFService.register(this, dfd);
			System.out.println("Refrigerator is up and running.");
			addBehaviour(new Alive());
			addBehaviour(new CheckItem(this, 5000));
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
