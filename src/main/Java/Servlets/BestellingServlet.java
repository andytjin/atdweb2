/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Artikel;
import Service.ArtikelService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author freekvdp
 */
@WebServlet(name = "BestellingServlet", urlPatterns = {"/BestellingServlet"})
public class BestellingServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BestellingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BestellingServlet at " + request.getContextPath() + "</h1>");
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
        ArtikelService as = ServiceProvider.getArtikelService();
        List<Artikel> alleArtikelen = as.getAlleArtikelen();
        List<Artikel> teBestellenArtikelen = new ArrayList<Artikel>();
        List<Artikel> bijnaBestellenArtikelen = new ArrayList<Artikel>();
        List<Artikel> besteldeArtikelen = new ArrayList<Artikel>();
        String knop = request.getParameter("knop"); 
        RequestDispatcher rd = request.getRequestDispatcher("/Bestelling.jsp");

        /*for (Artikel a : alleArtikelen) {
            if (a.getAantal() < a.getMinimum()) {
                teBestellenArtikelen.add(a);
                
            } else if (a.getAantal() <= a.getMinimum() + 2) {
                bijnaBestellenArtikelen.add(a);
            }
        }*/

        if (knop.equals("Bestel!")) {
            teBestellenArtikelen = (List<Artikel>)request.getSession().getAttribute("teBestellen");
            double totaalprijs = 0;
            
           
            for (Artikel a : teBestellenArtikelen) {
                if(a.getMinimum()>=a.getAantal()){
                    a.setAantal(a.getAantal()+5);
                    totaalprijs += a.getPrijs()*5;
                }
                    
                int teweinig = 5+(a.getMinimum() - a.getAantal());
                totaalprijs += a.getPrijs() * (teweinig);
                a.setAantal(a.getAantal()+teweinig);
                as.wijzigArtikel(a);
                besteldeArtikelen.add(a);
            }
            teBestellenArtikelen.clear();
            System.out.println(besteldeArtikelen.size());
            request.getSession().setAttribute("besteldeLijst", besteldeArtikelen);
            System.out.println("de totaalprijs = " + totaalprijs);
            request.getSession().setAttribute("totaalprijs", totaalprijs);
        }
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
