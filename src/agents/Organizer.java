package agents;

import java.io.IOException;

import ObjectLayer.Contact;
import ObjectLayer.Message;
import gui.UserInterface;
import utils.AgentSetup;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;

public class Organizer extends Agent {


	public void setup ()
	{
		DFAgentDescription dfd = AgentSetup.agentSetup("Organizer","organizer");

		try {
			DFService.register(this, dfd);
			UserInterface ui = new UserInterface(this);

		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(Contact c, String message) {
		try {
			DFAgentDescription desc = new DFAgentDescription();
			ServiceDescription sDesc = new ServiceDescription();
			sDesc.setType("Phone");
			desc.addServices(sDesc);

			DFAgentDescription[] results = null;

			try {
				results = DFService.search(this, desc);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			Message m = new Message(c, message);
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.setContentObject(m);
			msg.setConversationId("sendMessage");

			for (int i = 0; i < results.length; i++) {
				msg.addReceiver(results[i].getName());
			}

			this.send(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
