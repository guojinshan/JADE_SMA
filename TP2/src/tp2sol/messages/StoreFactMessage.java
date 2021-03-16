package tp2sol.messages;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import tp2sol.model.Constants;
import tp2sol.model.FactValue;

/**
 * Message envoyé à l'agent store indiquant une factorielle calculée
 * 
 * @author cmoulin
 *
 */
public class StoreFactMessage extends ACLMessage {

	public StoreFactMessage(FactValue fv) {
		super(ACLMessage.INFORM);
		addReceiver(new AID(Constants.STORE, AID.ISLOCALNAME));
		setContent(fv.toJSON());
	}

}
