package Servlets;

import Domain.Bedrijf;
import Domain.Monteur;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
@WebServlet(name = "AddMonteurServlet", urlPatterns = {"/AddMonteurServlet"})
public class AddMonteurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String id = request.getParameter("ID");
        String naam = request.getParameter("Naam");
        String button = request.getParameter("button");
        int idnummer = 0;
        String msgs = "De volgende velden zijn niet goed ingevuld<br/>";
        boolean b = true;

        RequestDispatcher rd = request.getRequestDispatcher("AddMonteur.jsp");

        Object obj = request.getServletContext().getAttribute("bedrijf");
        Bedrijf bedrijf;
        if (obj != null) {
            bedrijf = (Bedrijf) obj;
        } else {
            bedrijf = new Bedrijf();
        }

        if(button.equals("terug")){
            rd = request.getRequestDispatcher("AdminPage.jsp");
            b = false;
        }
        if (id.equals("")) {
            msgs += "- ID<br/>";
            b = false;
        }
        try {
            idnummer = Integer.parseInt(id);
        } catch (Exception e) {
            msgs += " - Het ID moet een nummer zijn<br/>";
            b = false;
        }
        if (naam.equals("")) {
            msgs += "- Naam<br/>";
            b = false;
        }
        for (Monteur m : bedrijf.getAlleMonteurs()) {
            if (idnummer == m.getID()) {
                msgs += "- Dit ID wordt al gebruikt.<br/>";
                b = false;
            }
        }
        if (b) {
            Monteur m = new Monteur(naam, idnummer, "monteur");
            bedrijf.voegMonteurToe(m);
            request.getServletContext().setAttribute("bedrijf", bedrijf);
            System.out.println("Monteur toegevoegd");
            msgs = "Monteur " + naam + " is toegevoegd";
        }
        request.setAttribute("msgs", msgs);

        rd.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
