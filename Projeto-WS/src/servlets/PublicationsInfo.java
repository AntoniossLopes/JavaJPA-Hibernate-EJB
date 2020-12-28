package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import common.Publication;
import ejb.EJBPublicationRemote;


/**
 * Servlet implementation class PublicationsInfo
 */
@WebServlet("/PublicationsInfo")
public class PublicationsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@EJB
	EJBPublicationRemote ejb;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicationsInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("INFORMAÇÕES DAS PUBLICACOES");
		ejb.initial();
		List<Publication> pubs = ejb.getPublicationsInfo();
		request.setAttribute("lista", pubs);
		request.getRequestDispatcher("/info.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
