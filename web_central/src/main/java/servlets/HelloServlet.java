package servlets;

import com.monprojet.ejb.HelloService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private HelloService helloService;

    @Override
    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            helloService = (HelloService) ctx.lookup("ejb:/ejb1/HelloBean!com.monprojet.ejb.HelloService");
        } catch (NamingException e) {
            throw new ServletException("Erreur lookup EJB", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nom = req.getParameter("nom");
        if (nom == null) nom = "visiteur";

        String message = helloService.direBonjour(nom);
        req.setAttribute("message", message);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
