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
public class Researcher implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "num_publications")
	private Long num_publications;
	@Column(name = "num_reads")
	private Long num_reads;
	@Column(name = "citations")
	private Long citations;
	
	@ManyToMany(mappedBy = "researchers", fetch = FetchType.LAZY)
	private List<Skill> skills;
	@ManyToOne()
	@JoinColumn(name="institution_name", referencedColumnName = "name")
	private Institution institution;
	@ManyToMany(mappedBy = "author_names", fetch = FetchType.EAGER)
	private List<Publication> publications;
	
	
	public Researcher() {}
	
	public Researcher(String name, Long num_publications, Long num_reads, Long citations) {
		this.name = name;
		this.num_publications = num_publications;
		this.num_reads = num_reads;
		this.citations = citations;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getNum_publications() {
		return this.num_publications;
	}
	
	public void setNum_publications(Long num_publications) {
		this.num_publications = num_publications;
	}
	
	public Long getNum_reads() {
		return this.num_reads;
	}
	
	public void setNum_reads(Long num_reads) {
		this.num_reads = num_reads;
	}
	
	public Long getcitations() {
		return this.citations;
	}
	
	public void setCitations(Long citations) {
		this.citations = citations;
	}
	
	public List<Skill> getSkills() {
		return this.skills;
	}
	
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	public void addSkills(Skill skill) {
		this.skills.add(skill);
	}
	
	public void removeSkills(Skill skill) {
		int index = -1;
		for(int i = 0 ; i < this.skills.size(); i++) {
			if(this.skills.get(i).getName().equals(skill.getName())) {
				index = i;
			}
		}
		if(index != -1)
			this.skills.remove(index);
	}
	
	public List<Publication> getPublications() {
		return this.publications;
	}
	
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
	public void addPublication(Publication publication) {
		this.publications.add(publication);
	}
	
	public void removePublication(Publication publication) {
		int index = -1;
		for(int i = 0 ; i < this.publications.size(); i++) {
			if(this.publications.get(i).getName().equals(publication.getName())) {
				index = i;
			}
		}
		if(index != -1)
			this.publications.remove(index);
	}
	
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	public Institution getInstitution() {
		return this.institution;
	}
	
	@Override
	public String toString()
	{
		return "Researcher: " + this.name + "  Publications ->" + this.num_publications + " Reads ->" + this.num_reads + " Citations ->" + this.citations;
	}
	
}
