package ejb;

import javax.ejb.Remote;
import java.util.List;
import common.Institution;
import common.Researcher;

@Remote
public interface EJBInstitutionRemote {
	public void initial();

	public List<Researcher> getResearchersInfo();

	public List<Institution> getInstitutionsInfo();

	public Institution getPublicationData(String name);

	public List<Institution> getPublicationsByResearcher(String s);

}
