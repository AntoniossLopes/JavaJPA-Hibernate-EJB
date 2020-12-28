package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.Researcher;
import common.Skill;

@Remote
public interface EJBResearcherRemote {
	
	public void initial();
	
	public List<Researcher> getResearchersInfo();
	
	public List<Skill> getSkillsInfo();
	
	public Researcher getResearcherData(String name);
	
	public List<Researcher> getResearchersWithSkill(String s);
}
