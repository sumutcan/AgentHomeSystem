package behaviours;

import java.util.Random;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class Alive extends CyclicBehaviour {

	boolean isCrashed;

	@Override
	public void action() {
		MessageTemplate mt = MessageTemplate
				.MatchPerformative(ACLMessage.REQUEST);
		ACLMessage msg = myAgent.receive(mt);

		if (msg != null) {
			Random r = new Random();

			if ((r.nextInt() % 10) == 0) {
				isCrashed = true;
				ACLMessage reply = msg.createReply();
				reply.setContent("CRASHED");
				reply.setPerformative(ACLMessage.INFORM);
				myAgent.send(reply);
			} else {
				if (isCrashed) {
					isCrashed = false;
					ACLMessage reply = msg.createReply();
					reply.setContent("RECOVERED");
					reply.setPerformative(ACLMessage.INFORM);
					myAgent.send(reply);
				} else {
					ACLMessage reply = msg.createReply();
					reply.setContent("YES");
					reply.setPerformative(ACLMessage.INFORM);
					myAgent.send(reply);
				}
			}
		} else {
			block();
		}

	}

}
