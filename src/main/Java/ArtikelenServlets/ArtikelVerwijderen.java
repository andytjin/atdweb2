/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtikelenServlets;

import Domain.Artikel;
import Domain.ArtikelType;
import Domain.GebruikteArtikelen;
import Domain.Onderhoudsbeurt;
import Service.ArtikelService;
import Service.GebruikteArtikelenService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
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
@WebServlet(name = "ArtikelVerwijderen", urlPatterns = {"/ArtikelVerwijderen"})
public class ArtikelVerwijderen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
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
            String message = "";
            String artikelNummer = request.getParameter("artikelNummer");
            String code = "";
            String type = "";
            String aantal = "";
            String minimum = "";
            String prijs = "";
            try{
            Scanner sc = new Scanner(artikelNummer);
            sc.useDelimiter("\\s*,\\s*");
            code = sc.next();
            type = sc.next();
            aantal = sc.next();
            minimum = sc.next();
            prijs = sc.next();
            sc.close();
            } catch(NoSuchElementException e){
                e.printStackTrace();
            }
            int aant = 0;
            int min = 0;
            double pr = 0.0;
            
            if (aantal.equals("")) {
                
            } else {
                aant = Integer.parseInt(aantal);
            }

            if (minimum.equals("")) {
                
            } else {
                min = Integer.parseInt(minimum);
            }

            if (prijs.equals("")) {
                
            } else {
                pr = Double.parseDouble(prijs);
            }
            if(knop.equals("Terug")){
             RequestDispatcher view = request.getRequestDispatcher("/HoofdSchermArtikelen.jsp");
             view.forward(request, response);    
            }
            
            
            if(knop.equals("Verwijder")){
            ArtikelService as = ServiceProvider.getArtikelService();
            
            ArtikelType hetType = new ArtikelType(code);
            Artikel a = new Artikel(code, min, aant, pr, hetType);
       //     GebruikteArtikelen ga = as.getGA(code);
            
          //  as.schrijfArtikelTypeNaarDatabase(artikelType);
            
          //  as.verwijderArtikelType(hetType);
            try{
            if(as.verwijderArtikel(a)){
                ArtikelService aService = ServiceProvider.getArtikelService();
                List<Artikel> lijst = aService.getAlleArtikelen();
                request.getSession().setAttribute("artikel", lijst);
                System.out.println("verwijderen is gelukt");
                message = "Artikel is met succes verwijderd";
                request.setAttribute("error", message);
            } else{
                message = "Artikel wordt al gebruikt in een onderhoudsbeurt";
                request.setAttribute("error", message);
            }
            }catch(Exception e){
            }
            RequestDispatcher view = request.getRequestDispatcher("/ArtikelVerwijderen.jsp");
            view.forward(request, response);
        }
        
        
            
    }
}
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
