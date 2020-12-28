package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import common.Researcher;
import common.Skill;

/**
 * Session Bean implementation class EJBResearcher
 */
@Stateless
@LocalBean
public class EJBResearcher implements EJBResearcherRemote {
	
	@PersistenceContext(name = "Persistence")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBResearcher() {
        // TODO Auto-generated constructor stub
    }
    
	private List<Researcher> researchers;
	private List<Skill> skills;
	
	public void initial() {
		
		String jpqlR = "SELECT DISTINCT r FROM Researcher r LEFT JOIN FETCH r.institution i LEFT JOIN FETCH r.publications p";
		String jpqlS = "SELECT DISTINCT s FROM Skill s";
		
		TypedQuery<Researcher> typedQueryR = em.createQuery(jpqlR, Researcher.class);
		List<Researcher> mylistR = typedQueryR.getResultList();
		
		jpqlR = "SELECT DISTINCT r FROM Researcher r JOIN FETCH r.skills s";
		typedQueryR = em.createQuery(jpqlR, Researcher.class);
		mylistR = typedQueryR.getResultList();
		
		TypedQuery<Skill> typedQueryS = em.createQuery(jpqlS, Skill.class);
		List<Skill> mylistS = typedQueryS.getResultList();
		
		
		/*for (Researcher st : mylistR)
			System.out.println(st);
		*/
		
		skills = mylistS;
		researchers = mylistR;
		
		// Close an application-managed entity manager.
		// Close the factory, releasing any resources that it holds.	
	}
	
	public List<Researcher> getResearchersInfo() {
		return this.researchers;
	}
	
	public List<Skill> getSkillsInfo(){
		return this.skills;
	}
	
	public Researcher getResearcherData(String name) {
		Researcher researcher = null;
		for(int i = 0 ; i < this.researchers.size(); i++) {
			if(researchers.get(i).getName().equals(name)){
				researcher = researchers.get(i);
			}
		}
		return researcher;
		
	}
	
	public List<Researcher> getResearchersWithSkill(String s) {
		List<Researcher> aux = new ArrayList<Researcher>();
		
		for(int i = 0; i < this.researchers.size();i++) {
			for(int j = 0 ; j < this.researchers.get(i).getSkills().size(); j++) {
				if(this.researchers.get(i).getSkills().get(j).getName().equals(s)) {
					aux.add(this.researchers.get(i));
					break;
				}
			}
		}
		
		return aux;
	}
}
