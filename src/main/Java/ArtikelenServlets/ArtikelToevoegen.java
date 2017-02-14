/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtikelenServlets;

import Domain.Artikel;
import Domain.ArtikelType;
import Domain.Bedrijf;
import Service.ArtikelService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andy
 */
@WebServlet(name = "ArtikelToevoegen", urlPatterns = {"/ArtikelToevoegen"})
public class ArtikelToevoegen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String artikelNummer = request.getParameter("artikelNummer");
        String artikelType = request.getParameter("artikelType");
        String aantal = request.getParameter("aantal");
        String minimum = request.getParameter("minimum");
        String prijs = request.getParameter("prijs");
        String knop = request.getParameter("knop");
        String artikeltype = request.getParameter("artikeltype");
        String message = "";
        int aant = 0;
        int min = 0;
        double pr = 0.0;

        boolean b = true;

        if (artikelNummer.equals("")) {
            b = false;
            message += "Artikelnummer is niet ingevuld ";
        }
        if (artikeltype.equals("")) {
            b = false;
            message += "Artikeltype is niet ingevuld ";
        }
        if (aantal.equals("")) {
            b = false;

            message += "Aantal is niet ingevuld ";
        } else {
            aant = Integer.parseInt(aantal);
        }

        if (minimum.equals("")) {
            b = false;

            message += "Minimum is niet ingevuld ";
        } else {
            min = Integer.parseInt(minimum);
        }

        if (prijs.equals("")) {
            b = false;

            message += "Prijs is niet ingevuld ";
        } else {
            pr = Double.parseDouble(prijs);
        }

        if (knop.equals("voeg toe")) {
            ArtikelService as = ServiceProvider.getArtikelService();
            ArtikelType hetType = new ArtikelType(artikelType);
            as.schrijfArtikelTypeNaarDatabase(artikelType);
            RequestDispatcher view = request.getRequestDispatcher("/ArtikelToevoegen.jsp");
            view.forward(request, response);
            //error message maken als het al bestaat
        }
        if (knop.equals("Terug")) {
            RequestDispatcher view = request.getRequestDispatcher("/HoofdSchermArtikelen.jsp");
            view.forward(request, response);
        }

        if (knop.equals("Opslaan")) {
            if (b) {
                ArtikelService artServlet = ServiceProvider.getArtikelService();
                String error = "";
                ArtikelType artType = new ArtikelType(artikeltype);
                Artikel artikel = new Artikel(artikelNummer, min, aant, pr, artType);

                boolean saved = false;
                try {
                    artServlet.schrijfArtikelNaarDatabase(artikel);
                    saved = true;
                }catch(Exception e){
                }
                if (saved) {
                    message += "Artikel is met succes opgeslagen ";

                } else {
                    message = "ArtikelID bestaat al";
                    System.out.println(error);

                }
                request.setAttribute("error", message);
                RequestDispatcher view = request.getRequestDispatcher("/ArtikelToevoegen.jsp");
                view.forward(request, response);
            } else {
                request.setAttribute("error", message);
                RequestDispatcher view = request.getRequestDispatcher("/ArtikelToevoegen.jsp");
                view.forward(request, response);
            }
        }

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
