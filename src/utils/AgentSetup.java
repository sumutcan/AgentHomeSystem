package utils;

import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import behaviours.Alive;

public class AgentSetup {

	public static DFAgentDescription agentSetup() {
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName("Refrigerator");
		sd.setType("home-device");
		dfd.addServices(sd);
		
		
		return dfd;
	}
}
