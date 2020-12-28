package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetInstitution {
	/*
	private String name;
	private String localization;
	private String department;
	private ArrayList<String> researcher_names;
 */

	private static ArrayList<Institution> list;
	
	public static ArrayList<Institution> get(){
		
		list = new ArrayList<Institution>();
		boolean done1 = false;
		Scanner sc = new Scanner(System.in);
		while(!done1) {
			
			System.out.println("Institution name (N to finish): ");
			String name = sc.nextLine();
			done1 = name.equals("N");
			if(!done1) {
				
				System.out.println("Localization: ");
				String localization = sc.nextLine();
				
				System.out.println("Department: ");
				String department = sc.nextLine();
				List<Researcher> lista = new ArrayList<Researcher>();
				Institution novo = new Institution(name, localization, department);
				novo.setResearchers(lista);
				list.add(novo);
				
			}
			
		}
		//sc.close();
		
		return list;
	}
}
