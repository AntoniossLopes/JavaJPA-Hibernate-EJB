package common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Institution implements Serializable{
	private static final long serialVersionUID = 1L;
	// we use this generation type to match that of SQLWriteStudents
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "department")
	private String department;
	
	@OneToMany(mappedBy = "institution")
	private List<Researcher> researcher_names;
	
	public Institution() {}
	
	public Institution(String name, String location, String department) {
		this.name = name;
		this.location = location;
		this.department = department;
	}
		
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public List<Researcher> getResearchers(){
		return this.researcher_names;
	}
	
	public void setResearchers(List<Researcher> researcher_names) {
		this.researcher_names = researcher_names;
	}
	
	public void addResearcher(Researcher researcher) {
		this.researcher_names.add(researcher);
	}
	
	public void removeResearcher(Researcher researcher) {
		int index = -1;
		for(int i = 0 ; i < this.researcher_names.size();i++) {
			if(this.researcher_names.get(i).getName().equals(researcher.getName())) {
				index = i;
			}
		}
		if(index != -1)
			this.researcher_names.remove(index);
	}
	
	@Override
	public String toString()
	{
		return "Institution: " + this.name + " | Location: " + this.location + " | Department: " + this.department;
	}	
}
