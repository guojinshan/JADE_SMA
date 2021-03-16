package tp1.agent;

import behaviour.ContactBehaviour;
import jade.core.Agent;

public class HelloWorld extends Agent {
    @Override
    protected void setup() {
        System.out.println("Création de l'agent : " + getLocalName() + "Hello World");

        System.out.println("Ajout du Contact Behaviour...");
        ContactBehaviour contactBehaviour = new ContactBehaviour(this);
        this.addBehaviour(contactBehaviour);
    }
}
