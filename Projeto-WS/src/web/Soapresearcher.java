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

import common.Researcher;
import common.Skill;
import ejb.EJBResearcherRemote;

@Stateless 
@WebService
public class Soapresearcher {
	
	
	 public Soapresearcher() {
		 
	 }
	 
	 @WebMethod
	 public String getSkills() {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Skill> lista = myejb.getSkillsInfo();
			 String x= "";
			 for(int i = 0 ; i < lista.size(); i++) {
				 x = x + lista.get(i).getName();
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
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
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
	 public String getResearcher(@WebParam(name = "name")String name) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 Researcher y = myejb.getResearcherData(name);
			 String x = y.toString();
			 x = x + "\n";
			 x = x + y.getInstitution().toString() + "\n";
			 x = x + "Publications:" + "\n";
			 for(int i = 0; i < y.getPublications().size(); i++) {
				 x = x + y.getPublications().get(i).toString() + "\n";
			 }
			 x = x + "Skills:" + "\n";
			 for(int i = 0 ; i < y.getSkills().size(); i++) {
				 x = x + y.getSkills().get(i).getName() + "\n";
			 }
			 return x;
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "Nada";
		 }
	 }
	
	 @WebMethod
	 public String getResearchersWithSkill(@WebParam(name = "skills")String skill) {
		 Context context;
		 Properties jndiProperties = new Properties();	  
		 jndiProperties.setProperty("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
		 jndiProperties.setProperty("java.naming.provider.url","http-remoting://localhost:8080");
		 jndiProperties.setProperty("jboss.naming.client.ejb.context","true");
		 try {
			 context = (Context) new InitialContext(jndiProperties);
			 //java:jboss/exported/projetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote
			 EJBResearcherRemote myejb = (EJBResearcherRemote)context.lookup("ProjetoEAR/Projeto-EJB/EJBResearcher!ejb.EJBResearcherRemote");
			 myejb.initial();
			 System.out.println("chamando MyEJB...");
			 List<Researcher> lista = myejb.getResearchersWithSkill(skill);
			 if(lista == null) {
				 return "not found";
			 }
			 else {
				 String x= "Skill => "+ skill;
				 x = x + "\n";
				 for(int i = 0 ; i < lista.size(); i++) {
					 x = x + lista.get(i).toString();
					 x = x + "\n";
				 }
				 return x;
			 	}
			 } catch (NamingException e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
			 return "nada";
		 }
	}

}