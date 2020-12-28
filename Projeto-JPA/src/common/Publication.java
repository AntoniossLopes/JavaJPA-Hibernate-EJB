package common;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Publication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	// we use this generation type to match that of SQLWriteStudents
	@Id
	@Column(name = "name")
	private String name;
	@Column(name = "date")
	private String date;
	@Column(name = "type")
	private String type;

	@ManyToMany
	private List<Researcher> author_names;
	
	public Publication() {}
	
	public Publication(String name, String date,String type) {
		this.name = name;
		this.date = date;
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Researcher> getAuthors(){
		return this.author_names;
	}
	
	public void setAuthors(List<Researcher> author_names) {
		this.author_names = author_names;
	}
	
	public void addAuthor(Researcher author) {
		this.author_names.add(author);
	}
	
	public void removeAuthor(Researcher author) {
		int index = -1;
		for(int i = 0; i < this.author_names.size(); i++) {
			if(this.author_names.get(i).getName().equals(author.getName()))
				index = i;
		}
		if(index != -1)
			this.author_names.remove(index);
	}
	
	@Override
	public String toString()
	{
		return "Publication : " + this.name + "  Date: " + this.date;
	}	
	
}
