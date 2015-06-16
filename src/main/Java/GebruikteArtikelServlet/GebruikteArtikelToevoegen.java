/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GebruikteArtikelServlet;

import Domain.Artikel;
import Domain.GebruikteArtikelen;
import Service.ArtikelService;
import Service.GebruikteArtikelenService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
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
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            String onderhoudsbeurtID = request.getParameter("onderhoudsbeurt");
            String artikelID = request.getParameter("artikel");
            String aantalArt = request.getParameter("ga");
            
            int ohID = 0;
            int aantalGA = 0;
            
            if (onderhoudsbeurtID.equals("")) {
            System.out.println("onderhoudsID = null");
        } else {

            ohID = Integer.parseInt(onderhoudsbeurtID);
        }
        
        
        if (aantalArt.equals("")) {
            System.out.println("MonteurID = null");
        } else {
            aantalGA = Integer.parseInt(aantalArt);
        }
        
        if(knop.equals("voeg toe")){
            
            ArtikelService aService = ServiceProvider.getArtikelService();
            Artikel a = aService.getArtikelByCode(artikelID);
            GebruikteArtikelen ga = new GebruikteArtikelen(aantalGA, a);
            GebruikteArtikelenService gService = ServiceProvider.getGebruikteArtikelenService();
            
            gService.schrijfGebruikteArtikelNaarDatabase(ga,ohID);
        }
          RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidToevoegen.jsp");
          view.forward(request, response);  
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
}
