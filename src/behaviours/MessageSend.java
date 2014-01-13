package behaviours;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import com.sun.xml.internal.ws.encoding.soap.SerializationException;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;


public class MessageSend extends CyclicBehaviour {

	@Override
	public void action() {
		
		ACLMessage msg = myAgent.receive();
		
		if (msg != null)
		{
			try {
				Serializable obj = msg.getContentObject();
				
				
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
