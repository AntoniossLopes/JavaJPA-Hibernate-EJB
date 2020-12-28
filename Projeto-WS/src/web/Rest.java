package web;

import ejb.*;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import common.Institution;
import common.Researcher;



@Path("/institution")
public class Rest {
	@EJB 
	EJBInstitutionRemote ejbInst;
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)

	public String getAllInstitutions() {
		String aux = "";
		ejbInst.initial();
		List<Institution> instList = ejbInst.getInstitutionsInfo();
		for(Institution inst : instList) {
			aux = aux + inst.toString() + "\n";
		}
		return aux;
	}
	
	
	
	@POST
	@Path("/postInst")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getInstitutionInfo(String name) {
		ejbInst.initial();
		List<Institution> instList = ejbInst.getInstitutionsInfo();
		for(Institution i : instList) {
			if(i.getName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
				return i.toString();
			}
		}
		return "Not found";
		
	}
	
	@POST
	@Path("/postRes")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getResearcherInstitutionInfo(String name) {
		ejbInst.initial();
		List<Researcher> resList = ejbInst.getResearchersInfo();
		//List<Institution> instList = ejbInst.getInstitutionsInfo();
		for(Researcher r : resList) {
			if(r.getName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
				return r.getName()+"'s information: "+r.getInstitution().toString();
			}
		}
		return "Not found";
		
	}

}