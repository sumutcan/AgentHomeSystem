package ObjectLayer;

import java.io.Serializable;

public class Message implements Serializable {

	private Contact to;
	private String message;

	public Message(Contact c, String m) {
		this.to = c;
		this.message = m;
	}

	public Contact getTo() {
		return to;
	}

	public void setTo(Contact to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message Info:\nTo=" + to.name + " (" + to.telNumber
				+ ")\nMessage=" + message + "]";
	}

}
