package agents;

import jade.core.Agent;

public class ObserverAgent extends Agent {

	public void setup()
	{
		System.out.println("Selamun Aleyküm mümin kardeş. Ben gözlemciyim elhamdülillah.");
		doDelete();
	}
	
	public void takeDown()
	{
		System.out.println("Kapattık hafız.");
	}

}
