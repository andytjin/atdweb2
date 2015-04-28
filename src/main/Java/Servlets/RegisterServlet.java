/*
 * Licsense Header
 */
package Servlets;

import Domain.Bedrijf;
import Domain.Klant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        //TODO tijdelijk bedrijf, vervangen door servlet context listener 
        Bedrijf bedrijf = new Bedrijf();
        request.getServletContext().setAttribute("bedrijf", bedrijf);
        
        String username = request.getParameter("Username");
        String realname = request.getParameter("Fullname");
        String pass1 = request.getParameter("Password");
        String pass2 = request.getParameter("PasswordConfirm");
        String email1 = request.getParameter("Email");
        String email2 = request.getParameter("EmailConfirm");
        String telnmr = request.getParameter("Phonenumber");
        String adres = request.getParameter("Address");
        String postcode = request.getParameter("Postcode");
        String geboortedatum = request.getParameter("DateofBirth");
        String sHerrinering = request.getParameter("Herrinnering");
        boolean herrinering = false;

        String msgs = "De volgende velden zijn niet correct ingevuld<br/>";
        boolean b = true;
        if (username.equals("")) {
            b = false;
            msgs += "- Gebruikersnaam <br/>";
        }
        if (realname.equals("")) {
            b = false;
            msgs += "- Naam<br/>";
        }
        if (pass1.equals("") || pass2.equals("")) {
            b = false;
            msgs += "- Wachtwoord<br/>";
        } else if (!pass1.equals(pass2)) {
            b = false;
            msgs += "- Wachtwoorden komen niet overeen<br/>";
        }
        if (email1.equals("") || email2.equals("")) {
            b = false;
            msgs += "- Email<br/>";
        } else if (!email1.equals(email2)) {
            b = false;
            msgs += "- Email adressen komen niet overeen<br/>";
        }
        if (adres.equals("")) {
            b = false;
            msgs += "- Adres<br/>";
        }
        if (postcode.equals("")) {
            b = false;
            msgs += "- Postcode<br/>";
        }
        if (geboortedatum.equals("")) {
            b = false;
            msgs += "- GeboorteDatum<br/>";
        }
        //TODO toevoegen extra checks voor geboortedatum en postcode.
        if (sHerrinering != null) {
            if (sHerrinering.equals("on")) {
                herrinering = true;
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                
        if (b) {
            Klant k = new Klant(username, realname, pass1, adres, geboortedatum, telnmr, postcode, email1, herrinering);
            if(!bedrijf.heeftKlant(k.getUsername())){
                bedrijf.voegKlantToe(k);
                request.getSession().setAttribute("user", k);
                 request.setAttribute("msgs", "U bent geregistreerd, log boven aan de pagina in.");
            }
            else{
                request.setAttribute("msgs", "Deze username bestaat al");
            }
        }else{
            request.setAttribute("msgs", msgs);
        }
        
        request.getServletContext().setAttribute("bedrijf", bedrijf);
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
