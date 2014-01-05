package agents;


import behaviours.Ping;
import behaviours.Pong;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class ObserverAgent extends Agent {

	AID[] allAgents = null;
	
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
				allAgents = new AID[results.length];
				for (int i = 0; i<results.length; i++)
				{
					allAgents[i] = results[i].getName();
					System.out.println("Agent: " + results[i].getName().getLocalName());
				}
				
				FSMBehaviour observing = new FSMBehaviour();
				observing.registerFirstState(new Ping(allAgents), "PING");
				observing.registerLastState(new Pong(), "PONG");
				observing.registerDefaultTransition("PING", "PONG");
				observing.registerDefaultTransition("PONG", "PING");
				
				addBehaviour(observing);
			}
		});
	}
	
	public void takeDown()
	{
		System.out.println("Kapattık hafız.");
	}

}
