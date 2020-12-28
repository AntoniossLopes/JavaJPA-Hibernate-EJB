package web;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejb.EJBPublicationRemote;
import ejb.EJBResearcherRemote;
import common.Publication;
import common.Researcher;

@Stateless
public class EjbClient {
	
	/*public static void main(String[] args) {
		EjbClient ejb = new EjbClient();
		System.out.println("BOY SE QUERIAS UM FEAT LIGAVAS");
		System.out.println(ejb.getResearcher("Nilu Singh"));
		System.out.println(ejb.getResearchers());
		//Researcher[] researcher = ejb.getResearchers(); 
	}*/

	public String getResearchers() {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Researcher> lista = myejb.getResearchersInfo();
			 String x= "";
			 for(int i = 0 ; i < lista.size(); i++) {
				 x = x + lista.get(i).toString();
				 x = x + "\n";
			 }
			 return x;
			 
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "Nada";
		 }
	 }
	
	public String getResearcher(String name) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 return myejb.getResearcherData(name).toString();
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "Nada";
		 }
	 }
	
	public Researcher[] getResearchersWithSkill(String skill) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 return (Researcher[]) myejb.getResearchersWithSkill(skill).toArray();
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return null;
		 }
	}
	
	public List<Publication> getPublications() {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBPublicationRemote myejb = (EJBPublicationRemote)context.lookup("projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBPublicationRemote");
			 myejb.initial();
			 List<Publication> lista = myejb.getPublicationsInfo();
			 return lista;
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return null;
		 }
	}
}
