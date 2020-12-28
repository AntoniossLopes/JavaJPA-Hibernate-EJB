package web;

import java.util.List;
import java.util.Properties;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import common.Publication;
import common.Researcher;
import ejb.EJBPublicationRemote;

@Stateless 
@WebService
public class SoapPublication {

	 public SoapPublication() {
		 
	 }
	 
	 @WebMethod
	 public String getPublications() {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBPublicationRemote myejb = (EJBPublicationRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBPublication!ejb.EJBPublicationRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Publication> lista = myejb.getPublicationsInfo();
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
	
	 @WebMethod
	 public String getResearchers() {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBPublicationRemote myejb = (EJBPublicationRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBPublication!ejb.EJBPublicationRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Researcher> lista = myejb.getResearchersInfo();
			 String x= "";
			 for(int i = 0 ; i < lista.size(); i++) {
				 x = x + lista.get(i).toString();
				 x = x + " " + lista.get(i).getInstitution();
				 x = x + "\n";
			 }
			 return x;
			 
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "Nada";
		 }
	 }
	
	 @WebMethod
	 public String getPublication(@WebParam(name = "name")String name) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBPublicationRemote myejb = (EJBPublicationRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBPublication!ejb.EJBPublicationRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 Publication y = myejb.getPublicationData(name);
			 String x = y.toString();
			 x = x + "\n";
			 x = x + "Authors:"+"\n";
			 for(int i = 0; i < y.getAuthors().size(); i++) {
				 x = x + y.getAuthors().get(i).toString() + "\n";
			 }
			 return x;
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "Nada";
		 }
	 }
	
	 @WebMethod
	 public String getPublicationByResearcherName(@WebParam(name = "ResearcherName")String name) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBPublicationRemote myejb = (EJBPublicationRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBPublication!ejb.EJBPublicationRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Publication> lista = myejb.getPublicationsByResearcher(name);
			 String x= "Researcher Name: => "+name;
			 x = x + "\n";
			 for(int i = 0 ; i < lista.size(); i++) {
				 x = x + lista.get(i).toString();
				 x = x + "\n";
			 }
			 return x;
			 
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return null;
		 }
	}
}
