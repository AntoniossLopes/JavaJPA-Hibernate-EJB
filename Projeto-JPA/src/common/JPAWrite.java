package common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class JPAWrite {
	public static void main(String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		List<Institution> mylistI = new ArrayList<Institution>();
		List<Researcher> mylistR = new ArrayList<Researcher>();
		List<Publication> mylistP = new ArrayList<Publication>();
		List<Skill> mylistS =  new ArrayList<Skill>();
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
			
		Scanner sc = new Scanner(System.in);
		int flag = 1;
		
		while(flag == 1) {
			System.out.println("SELECT OPTION :");
			System.out.println("1 - ADD_INSTITUIONS :");
			System.out.println("2 - ADD_RESEARCHER :");
			System.out.println("3 - ADD_PUBLICATIONS :");
			System.out.println("4 - ADD_SKILLS :");
			System.out.println("5 - ADD INSTITUTION TO RESEARCHER :");
			System.out.println("6 - ADD SKILLS TO RESEARCHER :");
			System.out.println("7 - ADD PUBLICATIONS TO RESEARCHER :");
			System.out.println("0 - LEAVE :");
			System.out.println("SELECT OPTION :");
			int x = Integer.parseInt(sc.nextLine());
			switch(x) {
				case 0:
					flag = 0;
					break;
				case 1:
					mylistI = GetInstitution.get();
					break;
				case 2:
					mylistR = GetResearchers.get();
					break;
				case 3:
					mylistP = GetPublication.get();
					break;
				case 4:
					mylistS = GetSkills.get();
					break;
				case 5:
					for(int i = 0 ; i < mylistR.size();i++) {
						System.out.println(i+" "+mylistR.get(i).getName());
					}
					System.out.println("Choose Person:");
					int a = Integer.parseInt(sc.nextLine()); 
					for(int i = 0 ; i < mylistI.size();i++) {
						System.out.println(i+" "+mylistI.get(i).getName());
					}
					System.out.println("Choose Department:");
					int b = Integer.parseInt(sc.nextLine());
					mylistR.get(a).setInstitution(mylistI.get(b));
					mylistI.get(b).addResearcher(mylistR.get(a));
					break;
				case 6:
					for(int i = 0 ; i < mylistR.size();i++) {
						System.out.println(i+" "+mylistR.get(i).getName());
					}
					System.out.println("Choose Researcher:");
					int b1 = Integer.parseInt(sc.nextLine());
					while(true) {
						for(int i = 0 ; i < mylistS.size();i++) {
							System.out.println(i+" "+mylistS.get(i).getName());
						}
						System.out.println("Choose Skill (-1 to leave):");
						int a1 = Integer.parseInt(sc.nextLine());
						if(a1 == -1)
							break;
						mylistS.get(a1).addResearcher(mylistR.get(b1));
						mylistR.get(b1).addSkills(mylistS.get(a1));
					}
					break;
				case 7:
					for(int i = 0 ; i < mylistR.size();i++) {
						System.out.println(i+" "+mylistR.get(i).getName());
					}
					System.out.println("Choose Researcher:");
					int a2 = Integer.parseInt(sc.nextLine());
					while(true) {
						for(int i = 0 ; i < mylistP.size();i++) {
							System.out.println(i+" "+mylistP.get(i).getName());
						}
						System.out.println("Choose Publication(-1 to leave):");
						int b2 = Integer.parseInt(sc.nextLine());
						if(b2 == -1)
							break;
						mylistP.get(b2).addAuthor(mylistR.get(a2));
						mylistR.get(a2).addPublication(mylistP.get(b2));
					}
					break;
			}
		}
			
		
		
		tx.begin();
		//persists all arraylists to tables
		for (Institution st : mylistI)
			em.persist(st);		
		
		
		
		//persists all arraylists to tables
		for (Researcher st : mylistR)
			em.persist(st);		
		
		
		
		//persists all arraylists to tables
		for (Publication st : mylistP)
			em.persist(st);		
		
		//persists all arraylists to tables
		for (Skill st : mylistS)
			em.persist(st);		
		
		tx.commit();

		// after commit we have ids:
		//for (Researcher st : mylistR)
			//System.out.println(st);
		
		System.out.println("Done");
		// Close an application-managed entity manager.
		em.close();
		//Close the factory, releasing any resources that it holds.
		emf.close();
		sc.close();
	}
}
