package utils;

import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import behaviours.Alive;

public class AgentSetup {

	public static DFAgentDescription agentSetup(String name, String type) {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName(name);
		sd.setType(type);
		dfd.addServices(sd);
		
		
		return dfd;
	}
}
