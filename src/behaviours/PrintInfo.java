package behaviours;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class PrintInfo extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage msg = myAgent.receive(MessageTemplate.MatchConversationId("info"));
		
		if (msg != null)
		{
			System.out.println(msg.getContent());
		}
		
	}



}
