package behaviours;


import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class Alive extends CyclicBehaviour {

	@Override
	public void action() {
		MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
		ACLMessage msg = myAgent.receive(mt);
		
		if (msg != null)
		{
			ACLMessage reply =  msg.createReply();
			reply.setContent("YES");
			reply.setPerformative(ACLMessage.INFORM);
			myAgent.send(reply);
		}
		else
			block();
		
	}


}
