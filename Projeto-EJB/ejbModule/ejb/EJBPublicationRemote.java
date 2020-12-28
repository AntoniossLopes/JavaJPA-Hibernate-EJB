package ejb;

import java.util.List;

import javax.ejb.Remote;

import common.Publication;
import common.Researcher;

@Remote
public interface EJBPublicationRemote {

	public void initial();
	
	public List<Researcher> getResearchersInfo();
	
	public List<Publication> getPublicationsInfo();
	
	public Publication getPublicationData(String name);
	
	public List<Publication> getPublicationsByResearcher(String s);
}
