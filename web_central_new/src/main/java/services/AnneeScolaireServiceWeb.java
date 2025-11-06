package services;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import eleve.major.ejb.module2.AnneeScolaireServiceRemote;

public class AnneeScolaireServiceWeb {
	 public AnneeScolaireServiceRemote getService() throws NamingException {
	        Hashtable<String, String> props = new Hashtable<>();
	        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
	        props.put(Context.PROVIDER_URL, "http-remoting://localhost:8085"); // ton conteneur Docker WildFly exposé ici
	        props.put(Context.SECURITY_PRINCIPAL, "ejbuser");
	        props.put(Context.SECURITY_CREDENTIALS, "ejbpass123");

	        Context ctx = new InitialContext(props);
	        return (AnneeScolaireServiceRemote) ctx.lookup(
	                "ejb:/EjbDockerEleveMajor/AnneeScolaireService!eleve.major.ejb.module2.AnneeScolaireServiceRemote?stateful"
	        );
	    }
}
