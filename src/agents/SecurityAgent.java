package agents;

import behaviours.Alive;
import utils.AgentSetup;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class SecurityAgent extends Agent {

	public void setup()
	{
		DFAgentDescription dfd = AgentSetup.agentSetup();
		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Security system is up and running.");
		addBehaviour(new Alive());
	}
	
}
