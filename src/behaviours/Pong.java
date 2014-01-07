package behaviours;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Pong extends Behaviour {

	@Override
	public void action() {
		// TODO Auto-generated method stub

		MessageTemplate mt = MessageTemplate.and(
				MessageTemplate.MatchConversationId("observing"),
				MessageTemplate.MatchPerformative(ACLMessage.INFORM));
		ACLMessage reply = myAgent.receive(mt);

		if (reply != null) {
			if (reply.getContent().equals("YES")) {
				System.out.println(reply.getSender().getName() + " is alive.");
			}
			else if (reply.getContent().equals("RECOVERED")) {
				System.out.println(reply.getSender().getName() + " is recovered by me.");
			}
			else
				System.out.println(reply.getSender().getName() + " crashed!");
		} else {
			block();
		}

	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
