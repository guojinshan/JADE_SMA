package tp1.behavior;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ContactBehaviour extends CyclicBehaviour
{
    private Agent agent;

    public ContactBehaviour(Agent agent) {
        this.agent = agent;
    }

    public void action() {
        ACLMessage message = this.agent.receive();
        if(message != null) {
            System.out.format("Contact : %s\n", message.getContent());
        }
        else {
            block();
        }
    }

    public boolean done() {
        return false;
    }
}
