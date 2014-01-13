package behaviours;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.CustomSerializer;
import Enviroment.SecurityProperties;
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
					
					Object[] options = { "Okay"};
					JFrame frame = new JFrame();
					int n = JOptionPane
							.showOptionDialog(frame, "Your message has been send.\nDetails:\nTo: " + mesaj.getTo() + "\nMessage: " + mesaj.getMessage() ,
									"Message from Phone Agent",
									JOptionPane.OK_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null, options,
									options[0]);

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
