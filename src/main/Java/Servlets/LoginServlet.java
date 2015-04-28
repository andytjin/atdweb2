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
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        String msgs = "De volgende velden zijn niet correct ingevuld<br/>";
        RequestDispatcher rd = request.getRequestDispatcher("WelcomeKlant.jsp");
        boolean b = true;

        Object obj = request.getServletContext().getAttribute("bedrijf");
        Bedrijf bedrijf;
        if (obj != null) {
            bedrijf = (Bedrijf) obj;
        } else {
            bedrijf = new Bedrijf();
        }

        if (!username.equals("")) {
            Klant k = bedrijf.getKlant(username);
            if (k != null) {
                if (k.checkPassword(password)) {
                    System.out.println("Wachtwoord correct");
                    if (username.equals("HenkPaladijn")) {
                        rd = request.getRequestDispatcher("AdminPage.jsp");
                    }
                } else {
                    b = false;
                    msgs += "- Wachtwoord is onjuist";
                }
            } else {
                b = false;
                msgs += "- Er is geen klant met deze gebruikers naam";
                for (Klant k2 : bedrijf.getAlleKlanten()) {
                    System.out.println(k2.toString());
                }
            }
        } else {
            b = false;
            msgs += "- Gebruikersnaam is niet ingevuld";
        }
        if (!b) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        request.setAttribute("loginmsgs", msgs);

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
