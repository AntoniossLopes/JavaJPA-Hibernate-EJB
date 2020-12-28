package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetPublication {
	/*
	 	private Long id;
		private String name;
		private String month;
		private int year;
		private ArrayList<String> author_names;
	 */

	private static ArrayList<Publication> list;
	
	public static ArrayList<Publication> get(){
		
		list = new ArrayList<Publication>();
		boolean done1 = false;
		Scanner sc = new Scanner(System.in);
		while(!done1) {
			
			System.out.println("Publication name (N to finish): ");
			String name = sc.nextLine();
			done1 = name.equals("N");
			if(!done1) {
				
				System.out.println("Month and Year: ");
				String month = sc.nextLine();
				
				System.out.println("Type: ");
				String type = sc.nextLine();
				
				
				List<Researcher> author_names = new ArrayList<Researcher>();	
				Publication novo = new Publication(name,month,type);
				novo.setAuthors(author_names);
				list.add(novo);
				
			}
			
		}
		//sc.close();
		
		return list;
	}
}
