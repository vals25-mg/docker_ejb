package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AnneeScolaireServiceWeb;

import java.io.IOException;
import java.util.List;

import eleve.major.ejb.module2.AnneeScolaireServiceRemote;
import eleve.major.ejb.module2.models.AnneeScolaire;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 AnneeScolaireServiceWeb anneeService = new AnneeScolaireServiceWeb();
	            AnneeScolaireServiceRemote service = anneeService.getService();
	            service.lireCsv("/opt/jboss/wildfly/standalone/deployments/annee_scolaire.csv");
	            List<AnneeScolaire> annees = service.getAnnees();
	            System.out.println("👀 Récupérées " + annees.size() + " années depuis EJB distant");

	            // Envoie la liste à la JSP
	            request.setAttribute("annees", annees);
	            request.getRequestDispatcher("index.jsp").forward(request, response);

	        } catch (Exception e) {
	            throw new ServletException("Erreur lors de la récupération des années scolaires", e);
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
