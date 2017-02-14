/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Artikel;
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
@WebServlet(name = "NaarBestelLijstServlet", urlPatterns = {"/NaarBestelLijstServlet"})
public class NaarBestelLijstServlet extends HttpServlet {

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
            out.println("<title>Servlet naarBestelLijstServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet naarBestelLijstServlet at " + request.getContextPath() + "</h1>");
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
        String verplaatsknop = request.getParameter("Artikelcode");
        Object o1 = request.getSession().getAttribute("teBestellen");
        Object o2 = request.getSession().getAttribute("bijnaBestellen");
        List<Artikel> teBestellenArtikelen = null;
        List<Artikel> bijnaTeBestellenArtikelen = null;
        RequestDispatcher rd = request.getRequestDispatcher("/Bestelling.jsp");

        if (o1 != null) {
            teBestellenArtikelen = (List<Artikel>) o1;
            System.out.println("te bestellenLijst IS NIET leeg");
        } else {
            System.out.println("te bestellenLijst IS leeg");
        }
        if (o2 != null) {
            bijnaTeBestellenArtikelen = (List<Artikel>) o2;
            System.out.println("Bijna te bestellenLijst IS NIET leeg");
        } else {
            System.out.println("Bijna te bestellenLijst IS leeg");
        }
        if (bijnaTeBestellenArtikelen != null) {
            Artikel verplaatsArtikel = null;
            for (Artikel a : bijnaTeBestellenArtikelen) {
                if (a.getCode().equals(verplaatsknop)) {
                    verplaatsArtikel = a;
                }
            }

            try {
                bijnaTeBestellenArtikelen.remove(verplaatsArtikel);
                teBestellenArtikelen.add(verplaatsArtikel);
                request.getSession().setAttribute("teBestellen", teBestellenArtikelen);
                request.getSession().setAttribute("bijnaBestellen", bijnaTeBestellenArtikelen);
                System.out.println("TRY");
            } catch (Exception e) {
                System.out.println("CATCH");
            }
        }
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
