package tp2sol.main;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;

public class FactorielMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		startWithProfile();
	}

	public static void startWithProfile() {
		Runtime rt = Runtime.instance();
		Profile p = null;
		ContainerController cc;
		try {
			/**
			 * host : null value means use the default (i.e. localhost) port - is the port
			 * number. A negative value should be used for using the default port number.
			 * platformID - is the symbolic name of the platform, isMain : boolean
			 */

			p = new ProfileImpl(null, -1, "tdia04", false);

			cc = rt.createAgentContainer(p);
			/*
			 * Agent factorielle basique. Le calcul de factorielle se fait par une machine à
			 * deux états (envoi, réception)
			 */
			AgentController ac = cc.createNewAgent("FACT", "tp2sol.agents.FactAgent", null);
			ac.start();
			ac = cc.createNewAgent("MULT1", "tp2sol.agents.MultAgent", null);
			ac.start();
			ac = cc.createNewAgent("MULT2", "tp2sol.agents.MultAgent", null);
			ac.start();
			ac = cc.createNewAgent("STORE", "tp2sol.agents.StoreAgent", null);
			ac.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
