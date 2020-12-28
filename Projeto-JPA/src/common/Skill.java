package common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.*;

@Entity
public class Skill implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "Researchers_Skills",
			joinColumns = @JoinColumn(name = "skill_name", referencedColumnName = "name"),
			inverseJoinColumns = @JoinColumn(name = "researcher_name", referencedColumnName = "name")
	)
	private List<Researcher>researchers;
	
	public Skill() {}
	
	public Skill(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Researcher> getResearchers() {
		return this.researchers;
	}
	
	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}
	
	public void addResearcher(Researcher researcher) {
		this.researchers.add(researcher);
	}
	
	public void removeResearcher(Researcher researcher) {
		int index = -1;
		for(int i = 0; i < this.researchers.size(); i++) {
			if(this.researchers.get(i).getName().equals(researcher.getName())) {
				index = i;
			}
		}
		if(index != -1)
			this.researchers.remove(index);
	}
}
