package tp1.main;

import jade.core.ProfileException;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;

public class MainBoot {
    public static String MAIN_PROPERTIES_FILE = "properties/main.properties";

    public static void main(String[] args) {
        Runtime rt = Runtime.instance();
        try {
            ProfileImpl p = new ProfileImpl(MAIN_PROPERTIES_FILE);
            AgentContainer mc = rt.createMainContainer(p);
        }
        catch (ProfileException e) {
            e.printStackTrace();
        }
    }
}
