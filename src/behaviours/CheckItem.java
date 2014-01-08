package behaviours;

import Enviroment.RefrigeratorEnvironment;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class CheckItem extends CyclicBehaviour {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		String criticalItems = RefrigeratorEnvironment.getInstance().GetCriticalItems();
		
		if (!criticalItems.isEmpty() && criticalItems != null)
		{
			ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
			msg.addReceiver(new AID("observer",AID.ISLOCALNAME));
			msg.setConversationId("info");
			msg.setContent(criticalItems);
			myAgent.send(msg);
		}
	}

	

}
