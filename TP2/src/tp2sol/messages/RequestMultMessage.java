package tp2sol.messages;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import tp2sol.model.Product;

/**
 * Message envoyé par l'agent factorielle pour demander un résultat de produit
 * 
 * @author cmoulin
 *
 */
public class RequestMultMessage extends ACLMessage {
	public RequestMultMessage(Product p, String id, AID receiver) {
		super(ACLMessage.REQUEST);
		setConversationId(id);
		addReceiver(receiver);
		setContent(p.toJSON());
	}
}
