package agents;

import behaviours.MessageSend;
import utils.AgentSetup;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;

public class Phone extends Agent {

	public void setup()
	{
		DFAgentDescription dfd = AgentSetup.agentSetup("Phone","phone");
		addBehaviour(new MessageSend());
		try {
			DFService.register(this, dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
