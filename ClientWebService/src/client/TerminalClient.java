package client;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import javax.xml.rpc.ServiceException;
import web.SoapPublication;
import web.SoapPublicationServiceLocator;
import web.Soapresearcher;
import web.SoapresearcherServiceLocator;
import common.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericType;

public class TerminalClient {

	public static void main(String[] args) {
		System.out.println("WELCOME\n\nWhat Service you want to Connect?");
		System.out.println("1 - Researcher Soap\n2 - Publication Soap\n3 - Institution REST\n\nSelect option:");
		Scanner sc = new Scanner(System.in);
		int flag = 1;
		int exit = 0;
		int selectNumber = Integer.parseInt(sc.nextLine());
		switch (selectNumber) {
		case 1:
			SoapresearcherServiceLocator locator1 = new SoapresearcherServiceLocator();
			try {
				Soapresearcher service1 = locator1.getSoapresearcherPort();
				while (flag == 1) {
					System.out.println("1 - Get All Researchers Data");
					System.out.println("2 - Get Full Info About a Researcher");
					System.out.println("3 - Get All Researcher With a Certain Skill");
					System.out.println("0 - Leave");
					System.out.println("Select option:");
					int selectNumber2 = Integer.parseInt(sc.nextLine());
					switch (selectNumber2) {
					case 0:
						flag = 0;
						break;
					case 1:
						System.out.println(service1.getResearchers());
						break;
					case 2:
						System.out.println("Researcher Name:");
						String name = sc.nextLine();
						System.out.println(service1.getResearcher(name));
						break;
					case 3:
						System.out.println("Skills\n");
						System.out.println(service1.getSkills());
						System.out.println("Skill:");
						String skill = sc.nextLine();
						System.out.println(service1.getResearchersWithSkill(skill));
						break;

					}
				}
			} catch (ServiceException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			SoapPublicationServiceLocator locator2 = new SoapPublicationServiceLocator();
			try {
				SoapPublication service2 = locator2.getSoapPublicationPort();
				while (flag == 1) {
					System.out.println("1 - Get All Publications Data");
					System.out.println("2 - Get Full Info About a Publication");
					System.out.println("3 - Get All Publication Create By Researcher");
					System.out.println("0 - Leave");
					System.out.println("Select option:");
					int selectNumber2 = Integer.parseInt(sc.nextLine());
					switch (selectNumber2) {
					case 0:
						flag = 0;
						break;
					case 1:
						System.out.println(service2.getPublications());
						break;
					case 2:
						System.out.println("Publication Name:");
						String name = sc.nextLine();
						System.out.println(service2.getPublication(name));
						break;
					case 3:
						System.out.println("Researchers");
						System.out.println(service2.getResearchers());
						System.out.println("Researcher Name:");
						String researcherName = sc.nextLine();
						System.out.println(service2.getPublicationByResearcherName(researcherName));
						break;

					}
				}
			} catch (ServiceException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			while (exit == 0) {
				System.out.println("1 - Get all data about institutions");
				System.out.println("2 - Get information about specific institution");
				System.out.println("3 - Get information about a specific researcher's institution");
				System.out.println("0 - Leave");
				System.out.println("Select option:");
				int selectNumber3 = Integer.parseInt(sc.nextLine());
				Client client = ClientBuilder.newClient();
				WebTarget target;
				Response response;
				String value;
				String name;
				Entity<String> input;
				switch (selectNumber3) {
				case 1:
					target = client.target("http://localhost:8080/Projeto-WS/rest/institution/get");
					response = target.request().get();
					value = response.readEntity(String.class);
					System.out.println("ALL INSTITUTIONS:\n" + value);
					response.close();
					break;
				case 2:
					System.out.println("Institution name: ");
					target = client.target("http://localhost:8080/Projeto-WS/rest/institution/postInst");
					name = sc.nextLine();
					input = Entity.entity(name, MediaType.APPLICATION_JSON);
					response = target.request().post(input);
					value = response.readEntity(String.class);
					System.out.println(value);
					response.close();
					break;
				case 3:
					System.out.println("Researcher name: ");
					target = client.target("http://localhost:8080/Projeto-WS/rest/institution/postRes");
					name = sc.nextLine();
					input = Entity.entity(name, MediaType.APPLICATION_JSON);
					response = target.request().post(input);
					value = response.readEntity(String.class);
					System.out.println(value);
					response.close();
					break;
				case 0:
					exit = 1;
					break;
				}
			}
			break;
		}
		sc.close();

	}
}
