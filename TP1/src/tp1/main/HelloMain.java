package tp1.main;

import jade.core.Profile;
import jade.core.ProfileException;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class HelloMain
{
    public static String SECOND_PROPERTIES_FILE = "properties/second.properties";

    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        ContainerController cc1 = create_second_container();
        ContainerController cc2 = create_second_container();
        create_hello_world_agent(cc1, 0);
        create_hello_world_agent(cc1, 1);
        create_hello_world_agent(cc2, 2);
        create_hello_world_agent(cc2, 3);
    }

    private static ContainerController create_second_container() {
        try {
            Profile p = new ProfileImpl(SECOND_PROPERTIES_FILE);
            ContainerController cc = rt.createAgentContainer(p);
            return cc;
        }
        catch (ProfileException e) {
            e.printStackTrace();
        }
    }

    private static void create_hello_world_agent(ContainerController cc, int id)
    {
        try {
            AgentController ac = cc.createNewAgent("Hello_" + id, "tp1.agent.HelloWorld", null);
            ac.start();
        }
        catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }


}

