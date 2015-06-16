/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WerkzaamhedenServlets;

import Domain.Artikel;
import Domain.Auto;
import Domain.GebruikteArtikelen;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.ArtikelService;
import Service.AutoService;
import Service.GebruikteArtikelenService;
import Service.MonteurService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
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
@WebServlet(name = "WerkzaamheidToevoegen", urlPatterns = {"/WerkzaamheidToevoegen"})
public class WerkzaamheidToevoegen extends HttpServlet {

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

        String knop = request.getParameter("knop");
        String onderhoudsbeurtID = request.getParameter("werkzaamheid");
        String datum = request.getParameter("datum");
        String nettoPrijs = request.getParameter("prijs");
        String bestedeUur = request.getParameter("uur");
        String ArtikelCode = request.getParameter("artikel");
        String kenteken = request.getParameter("auto");
        String monteurID = request.getParameter("monteur");
        String gaAantal = request.getParameter("ga");
        int gAantal = 0;
        int ohID = 0;

        if (gaAantal.equals("")) {
            System.out.println("null");
        } else {
            gAantal = Integer.parseInt(gaAantal);
        }

        if (onderhoudsbeurtID.equals("")) {
            System.out.println("null");
        } else {
            ohID = Integer.parseInt(onderhoudsbeurtID);
        }

        if (monteurID != null) {
            int MonteurID = Integer.parseInt(monteurID);
        } else {
            System.out.println("MonteurID = null");
        }

//     int GAID = Integer.parseInt(gaID);
        //     int MonteurID = Integer.parseInt(monteurID);
       //artikel moet opgeslagen worden in gebruikte artikel
        // auto moet in auto database
        // monteur in monteur
        //onderhoudsbeurt bevat autoid, monteurid en gebruikte artikelen id
        // datum, aantalbestede uren, nettoprijs
        if (knop.equals("voeg toe")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            GebruikteArtikelenService gaService = ServiceProvider.getGebruikteArtikelenService();

            if (gAantal > 0) {
                Artikel a = aService.getArtikelByCode(ArtikelCode);
                GebruikteArtikelen ga = new GebruikteArtikelen(gAantal, a);
                gaService.schrijfGebruikteArtikelNaarDatabase(ga);
            }

            //   List<GebruikteArtikelen> gaLijst = gaService.getGAList();
            List<GebruikteArtikelen> gaLijst = gaService.getByID(ohID);
            request.setAttribute("gaLijst", gaLijst);
        }

        if (knop.equals("Opslaan")) {
            ArtikelService aService = ServiceProvider.getArtikelService();
            Artikel a = aService.getArtikelByCode(ArtikelCode);
            MonteurService mService = ServiceProvider.getMonteurService();
            Monteur m = mService.getMonteurByID(ohID);
            AutoService auService = ServiceProvider.getAutoService();
            Auto au = auService.getAutoByKenteken(kenteken);
            GebruikteArtikelenService gaS = ServiceProvider.getGebruikteArtikelenService();
            GebruikteArtikelen ga = gaS.getGebruikteArtikel(gAantal);
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();
            Onderhoudsbeurt o = new Onderhoudsbeurt(ohID, datum, au, m);
            if (nettoPrijs.equals("") || bestedeUur.equals("")) {
                System.out.println("velden zijn leeg");
            } else {
                double prijs = Double.parseDouble(nettoPrijs);
                int uur = Integer.parseInt(bestedeUur);
                oService.schrijfOnderhoudsbeurtNaarDatabase(o, ga.getGebruikteArtikelID(), prijs, uur);
            }

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
