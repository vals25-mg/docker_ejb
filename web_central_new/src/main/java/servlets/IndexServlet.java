package servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AnneeScolaireServiceWeb;

import java.io.IOException;
import java.util.List;

import ejb_module1.ejb.InscriptionService;
import ejb_module1.models.VInscription;
import eleve.major.ejb.module2.AnneeScolaireServiceRemote;
import eleve.major.ejb.module2.models.AnneeScolaire;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
    private InscriptionService inscription_service;
	
    private AnneeScolaireServiceRemote service;

    /**
     * Initialisation du servlet — appelée une seule fois au démarrage.
     */
    @Override
    public void init() throws ServletException {
        try {
            // 1️⃣ Création du proxy distant vers ton EJB
            AnneeScolaireServiceWeb anneeService = new AnneeScolaireServiceWeb();
            service = anneeService.getService();

            // 2️⃣ Lecture unique du CSV dans le conteneur Docker WildFly
            service.lireCsv("/opt/jboss/wildfly/standalone/deployments/annee_scolaire.csv");
            System.out.println("✅ CSV chargé une seule fois lors de l'initialisation du servlet");

        } catch (Exception e) {
            throw new ServletException("Erreur d'initialisation du service des années scolaires", e);
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            // 3️⃣ On ne relit plus le CSV ici — juste on récupère la liste
            List<AnneeScolaire> annees = service.getAnnees();
            System.out.println("👀 " + annees.size() + " années renvoyées depuis EJB distant");

            // Envoi à la JSP
            request.setAttribute("anneesScolaires", annees);
            // Récupère l'année sélectionnée depuis la requête
            String anneeParam = request.getParameter("anneeScolaire");
            int anneeDebut = (anneeParam != null) ? Integer.parseInt(anneeParam) : annees.get(0).getAnneeDebut();

            List<VInscription> resultats = inscription_service.getClassementsByAnnee(anneeDebut);
            request.setAttribute("resultats", resultats);

            List<VInscription> majors = inscription_service.getMajorDesMajorsByAnnee(anneeDebut);
            request.setAttribute("majors", majors);
            
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
