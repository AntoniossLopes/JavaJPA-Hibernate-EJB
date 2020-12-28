package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetSkills {
	/*
	  	this.name = name;
		this.num_publications = num_publications;
		this.num_reads = num_reads;
		this.citations = citations;
		this.skills = skills;
	 */
	private static ArrayList<Skill> list;
	
	public static ArrayList<Skill> get(){
		
		list = new ArrayList<Skill>();
		boolean done1 = false;
		Scanner sc = new Scanner(System.in);
		while(!done1) {
			
			System.out.println("Skill name (N to finish): ");
			String name = sc.nextLine();
			done1 = name.equals("N");
			if(!done1) {		
				List<Researcher> getResearchers = new ArrayList<Researcher>();
				Skill novo = new Skill(name);
				novo.setResearchers(getResearchers);
				list.add(novo);
			}
		}
		//sc.close();
		
		return list;
	}
}
