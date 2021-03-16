package tp2sol.messages;

import jade.lang.acl.ACLMessage;
import tp2sol.model.Constants;
import tp2sol.model.Product;

/**
 * Message envoyé par l'agent multiplication en réponse à une demande de produit
 */
public class InformMultResultMessage {
	public static ACLMessage answer(ACLMessage message) {
		String par = message.getContent();
		ACLMessage reply = message.createReply();
		Product p = Product.read(par);

		if (p != null && p.getAction().equals(Constants.MULTIPLICATION)) {
			double n = p.product();
			reply.setPerformative(ACLMessage.INFORM);
			reply.setContent(String.valueOf(n));
		} else {
			reply.setPerformative(ACLMessage.FAILURE);
			reply.setContent(Constants.UNKNOWN);
		}
		return reply;
	}
}
