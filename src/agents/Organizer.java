package agents;

import utils.AgentSetup;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class Organizer extends Agent {

	public void setup ()
	{
		DFAgentDescription dfd = AgentSetup.agentSetup();
		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
