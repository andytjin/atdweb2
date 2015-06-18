/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GebruikteArtikelenServlets;

import Domain.Artikel;
import Domain.GebruikteArtikelen;
import Service.ArtikelService;
import Service.GebruikteArtikelenService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "GebruikteArtikelToevoegen", urlPatterns = {"/GebruikteArtikelToevoegen"})
public class GebruikteArtikelToevoegen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        System.out.println("Running GAtoevoegen");
        String gaAantal = request.getParameter("ga");
        String ArtikelCode = request.getParameter("artikel");
        String onderhoudsID = request.getParameter("onderhoudsbeurt");
        int gAantal = 0;
        int ohID = 0;
        boolean b = true;

        if (onderhoudsID.equals("")) {
            System.out.println("null");
            b = false;
        } else {
            ohID = Integer.parseInt(onderhoudsID);
        }

        if (gaAantal.equals("")) {
            System.out.println("null");
            b = false;
        } else {
            gAantal = Integer.parseInt(gaAantal);
        }
        if (b) {

            ArtikelService aService = ServiceProvider.getArtikelService();
            GebruikteArtikelenService gaService = ServiceProvider.getGebruikteArtikelenService();

            if (gAantal > 0) {
                Artikel a = aService.getArtikelByCode(ArtikelCode);
                if ((a.getAantal() - gAantal) < 0) {
                    System.out.println("Niet genoeg voorraad");
                    request.setAttribute("msgs", "Niet genoeg op voorraad");
                } else {
                    a.setAantal(a.getAantal() - gAantal);
                    GebruikteArtikelen ga = new GebruikteArtikelen(gAantal, a);
                    aService.WijzigArtikel(a);
                    System.out.println("Artikel aantal gewijzigd naar: " + a.getAantal());
                    gaService.schrijfGebruikteArtikelNaarDatabase(ga, ohID);
                }
            }

            //   List<GebruikteArtikelen> gaLijst = gaService.getGAList();
            List<GebruikteArtikelen> gaLijst = gaService.getByID(ohID);
            request.setAttribute("gaLijst", gaLijst);

        }else{
            System.out.println("WTF");
        }
        RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
        view.forward(request, response);
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
