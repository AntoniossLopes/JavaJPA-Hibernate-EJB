package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import common.Publication;
import common.Researcher;

/**
 * Session Bean implementation class EJBPublication
 */
@Stateless
@LocalBean
public class EJBPublication implements EJBPublicationRemote {

	@PersistenceContext(name = "Persistence")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EJBPublication() {
        // TODO Auto-generated constructor stub
    }
    
	private List<Researcher> researchers;
	private List<Publication> publications;
	
	public void initial() {
		
		String jpqlR = "SELECT DISTINCT r FROM Researcher r LEFT JOIN FETCH r.institution i LEFT JOIN FETCH r.publications p";
		String jpqlP = "SELECT DISTINCT p FROM Publication p LEFT JOIN FETCH p.author_names a";
		
		TypedQuery<Researcher> typedQueryR = em.createQuery(jpqlR, Researcher.class);
		List<Researcher> mylistR = typedQueryR.getResultList();
		
		TypedQuery<Publication> typedQueryP = em.createQuery(jpqlP, Publication.class);
		List<Publication> mylistP = typedQueryP.getResultList();
		
		publications = mylistP;
		researchers = mylistR;
		
		// Close an application-managed entity manager.
		// Close the factory, releasing any resources that it holds.	
	}
	
	public List<Researcher> getResearchersInfo() {
		return this.researchers;
	}
	
	public List<Publication> getPublicationsInfo(){
		return this.publications;
	}
	
	public Publication getPublicationData(String name) {
		Publication publication = null;
		for(int i = 0 ; i < this.publications.size(); i++) {
			if(publications.get(i).getName().equals(name)){
				publication = publications.get(i);
			}
		}
		return publication;
		
	}
	
	public List<Publication> getPublicationsByResearcher(String s) {
		List<Publication> aux = new ArrayList<Publication>();
		
		for(int i = 0; i < this.publications.size();i++) {
			for(int j = 0 ; j < this.publications.get(i).getAuthors().size(); j++) {
				if(this.publications.get(i).getAuthors().get(j).getName().equals(s)) {
					aux.add(this.publications.get(i));
					break;
				}
			}
		}
		
		return aux;
	}
}
