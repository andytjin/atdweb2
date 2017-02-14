package Servlets;

import Domain.Monteur;
import Service.MonteurService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
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
        String password = request.getParameter("Password");
        String passwordcheck = request.getParameter("PasswordCheck");
        String button = request.getParameter("button");
        String errormsgs = checkInput(id, naam, password, passwordcheck);
        String msgs = "De volgende velden zijn niet goed ingevuld<br/>";
        boolean b = true;

        RequestDispatcher rd = request.getRequestDispatcher("AddMonteur.jsp");
        if(button.equals("terug")){
            rd = request.getRequestDispatcher("/AdminPage.jsp");
            b = false;
        }
        MonteurService ms = ServiceProvider.getMonteurService();
        int idnummer = 0;
        if(!errormsgs.equals("")){
            idnummer = Integer.parseInt(id);
            b = false;
        }
        if (b) {
            ms.voegMonteurToe(idnummer, naam, password);
            System.out.println("Monteur toegevoegd");
            msgs = "Monteur " + naam + " is toegevoegd";
        }else{
            msgs += errormsgs;
        }
        request.setAttribute("msgs", msgs);
        rd.forward(request, response);
    }
    
    private String checkInput(String id, String naam, String password, String passwordcheck){
        String errormsgs = "";
        errormsgs += id.equals("") ? "- ID<br/>" : "";
        errormsgs += naam.equals("") ? "- Naam<br/>" : "";
        errormsgs += password.equals("") && passwordcheck.equals("") ? "- Wachtwoord<br/>" : "";
        errormsgs += !password.equals(passwordcheck) ? "- Wachtwoorden komen niet overeen" : "";
        int idnummer = 0;
        try {
            idnummer = Integer.parseInt(id);
        } catch (Exception e) {
            errormsgs += " - Het ID moet een nummer zijn<br/>";
            
        }
        MonteurService ms = ServiceProvider.getMonteurService();
        for (Monteur m : ms.getAlleMonteurs()) {
            if (idnummer == m.getID()) {
                errormsgs += "- Dit ID wordt al gebruikt.<br/>";  
            }
        }
        return errormsgs;
    }
}
