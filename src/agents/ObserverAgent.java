package agents;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class ObserverAgent extends Agent {

	public void setup()
	{
		System.out.println("Observer agent up and running.");
		
		addBehaviour(new TickerBehaviour(this,10000) {
			
			@Override
			protected void onTick() {
				
				DFAgentDescription agentDesc = new DFAgentDescription();
				DFAgentDescription[] results = null;
				//yorum
				try {
					results = DFService.search(myAgent, agentDesc);
				} catch (FIPAException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for (int i = 0; i<results.length; i++)
				{
					System.out.println("Agent: " + results[i].getName());
				}
				
			}
		});
	}
	
	public void takeDown()
	{
		System.out.println("Kapattık hafız.");
	}

}
