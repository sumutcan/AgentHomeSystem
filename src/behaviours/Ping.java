package behaviours;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Ping extends Behaviour {

	AID[] allAgents = null;
	
	public Ping(AID[] allAgents)
	{
		this.allAgents = allAgents;
	}
	@Override
	public void action() {
		
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		
		for(AID agent : allAgents)
			msg.addReceiver(agent);
		
		msg.setContent("IS_ALIVE");
		msg.setConversationId("observing");
		msg.setReplyWith("request"+System.currentTimeMillis());
		
		
		myAgent.send(msg);
		

	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
