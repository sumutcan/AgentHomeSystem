package agents;


import Enviroment.RefrigeratorEnvironment;
import ObjectLayer.RefrigeratorItem;
import behaviours.Ping;
import behaviours.Pong;
import behaviours.PrintInfo;
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
		RefrigeratorEnvironment.getInstance().setCriticalCount(3);
		RefrigeratorEnvironment.getInstance().setCriticalWeight(100);
		
		
		RefrigeratorItem i = new RefrigeratorItem("Meyve Suyu", 4);
		i.setBasedOnCount(true);
		RefrigeratorEnvironment.getInstance().AddItemToRefrigirator(i);
		
		RefrigeratorItem j = new RefrigeratorItem("Elma", 150.0);
		j.setBasedOnCount(false);
		RefrigeratorEnvironment.getInstance().AddItemToRefrigirator(j);
		
		addBehaviour(new TickerBehaviour(this, 5000) {

			@Override
			protected void onTick() {

				DFAgentDescription agentDesc = new DFAgentDescription();
				
				DFAgentDescription[] results = null;
				// yorum
				try {
					results = DFService.search(myAgent, agentDesc);
				} catch (FIPAException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				allAgents = new AID[results.length];
				for (int i = 0; i < results.length; i++) {
					allAgents[i] = results[i].getName();
					
				}
				
				
				FSMBehaviour observing = new FSMBehaviour();
				observing.registerFirstState(new Ping(allAgents), "PING");
				observing.registerLastState(new Pong(), "PONG");
				observing.registerDefaultTransition("PING", "PONG");
				observing.registerDefaultTransition("PONG", "PING");
				
				addBehaviour(observing);
				addBehaviour(new PrintInfo());
			}
		});
	}
	
	public void takeDown()
	{
		System.out.println("Kapattık hafız.");
	}

}
