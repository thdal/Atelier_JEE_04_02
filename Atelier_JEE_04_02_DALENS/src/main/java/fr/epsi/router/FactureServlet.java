package fr.epsi.router;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factures")
public class FactureServlet extends HttpServlet{
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Facture/ListFactures.jsp").forward(req, resp);
		    }


}
