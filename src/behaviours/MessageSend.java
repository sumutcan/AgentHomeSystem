package behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.IOException;

import utils.CustomSerializer;
import ObjectLayer.Message;


public class MessageSend extends CyclicBehaviour {

	@Override
	public void action() {
		
		ACLMessage msg = myAgent.receive();
		
		if (msg != null)
		{
			
			if (msg.hasByteSequenceContent())
			{
				try {
					Message mesaj = (Message)CustomSerializer.deserialize(msg.getByteSequenceContent());
					System.out.println(mesaj);
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
				
		
		}
		else
			block();
	}

}
