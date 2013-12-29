package agents;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class RefrigeratorAgent extends Agent {

	public  void setup()
	{
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setName("Refrigerator");
		sd.setType("home-device");
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
			System.out.println("Refrigerator is up and running.");
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
