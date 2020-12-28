package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import common.Institution;
import common.Researcher;

/**
 * Session Bean implementation class EJBInstitution
 */
@Stateless
@LocalBean
public class EJBInstitution implements EJBInstitutionRemote {


	@PersistenceContext(name = "Persistence")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBInstitution() {
        // TODO Auto-generated constructor stub
    }
    
	private List<Researcher> researchers;
	private List<Institution> institutions;
	
	public void initial() {
		
		String jpqlR = "SELECT s FROM Researcher s";
		String jpqlI = "SELECT s FROM Institution s";
		
		TypedQuery<Researcher> typedQueryR = em.createQuery(jpqlR, Researcher.class);
		List<Researcher> mylistR = typedQueryR.getResultList();
		
		TypedQuery<Institution> typedQueryI = em.createQuery(jpqlI, Institution.class);
		List<Institution> mylistI = typedQueryI.getResultList();
		
		institutions = mylistI;
		researchers = mylistR;
		
		// Close an application-managed entity manager.
		// Close the factory, releasing any resources that it holds.	
	}
	
	public List<Researcher> getResearchersInfo() {
		return this.researchers;
	}
	
	public List<Institution> getInstitutionsInfo(){
		return this.institutions;
	}
	
	public Institution getByInstitution(String instName){
		for(Institution inst : institutions) {
			if(inst.getName() == instName) {
				return inst;
			}
		}
		return null;
	}
	
	public Institution getPublicationData(String name) {
		Institution publication = null;
		for(int i = 0 ; i < this.institutions.size(); i++) {
			if(institutions.get(i).getName().equals(name)){
				publication = institutions.get(i);
			}
		}
		return publication;
		
	}
	
	public List<Institution> getPublicationsByResearcher(String s) {
		List<Institution> aux = new ArrayList<Institution>();
		
		for(int i = 0; i < this.institutions.size();i++) {
			for(int j = 0 ; j < this.institutions.get(i).getResearchers().size(); j++) {
				if(this.institutions.get(i).getResearchers().get(j).getName().equals(s)) {
					aux.add(this.institutions.get(i));
					break;
				}
			}
		}
		
		return aux;
	}

}
