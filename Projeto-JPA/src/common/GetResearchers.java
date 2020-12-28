package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetResearchers {
	/*
	  	this.name = name;
		this.num_publications = num_publications;
		this.num_reads = num_reads;
		this.citations = citations;
		this.skills = skills;
	 */
	private static ArrayList<Researcher> list;
	
	public static ArrayList<Researcher> get(){
		
		list = new ArrayList<Researcher>();
		boolean done1 = false;
		Scanner sc = new Scanner(System.in);
		while(!done1) {
			System.out.println("Researcher name (N to finish): ");
			String name = sc.nextLine();

			done1 = name.equals("N");
			if(!done1) {
				System.out.println("Number of Publications: ");
				Long num_publications = Long.parseLong(sc.nextLine());
				
				System.out.println("Number of Reads: ");
				Long num_reads = Long.parseLong(sc.nextLine());
				
				System.out.println("Number of Citations: ");
				Long citations = Long.parseLong(sc.nextLine());
			
				List<Publication> publications = new ArrayList<Publication>();
				List<Skill> skills = new ArrayList<Skill>();
				Researcher novo = new Researcher(name, num_publications, num_reads, citations);
				novo.setSkills(skills);
				novo.setPublications(publications);
				list.add(novo);
			}
		}
		//sc.close();
		
		return list;
	}
}
