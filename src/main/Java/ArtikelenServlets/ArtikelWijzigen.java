/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtikelenServlets;

import Domain.Artikel;
import Domain.ArtikelType;
import Service.ArtikelService;
import Service.ServiceProvider;
import java.io.BufferedReader;
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
@WebServlet(name = "ArtikelWijzigen", urlPatterns = {"/ArtikelWijzigen"})
public class ArtikelWijzigen extends HttpServlet {

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
        String artikelNummer = request.getParameter("artikelNummer");
        String artikelType = request.getParameter("artikelType");
        String aantal = request.getParameter("aantal");
        String minimum = request.getParameter("minimum");
        String prijs = request.getParameter("prijs");
        String code = "";
        String type = "";

        int aant = 0;
        int min = 0;
        double pr = 0.0;
        try {
            Scanner sc = new Scanner(artikelNummer);
            sc.useDelimiter("\\s*,\\s*");
            code = sc.next();
            type = sc.next();
            String a = sc.next();
            String m = sc.next();
            String p = sc.next();
            sc.close();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        System.out.println(code);

        if (!aantal.equals("")) {
            aant = Integer.parseInt(aantal);
        }

        if (!minimum.equals("")) {
            min = Integer.parseInt(minimum);
        }

        if (!prijs.equals("")) {
            pr = Double.parseDouble(prijs);
        }

        if (knop.equals("Terug")) {
            RequestDispatcher view = request.getRequestDispatcher("/HoofdSchermArtikelen.jsp");
            view.forward(request, response);
        }

        if (knop.equals("Opslaan")) {
            ArtikelService as = ServiceProvider.getArtikelService();

            ArtikelType hetType = new ArtikelType(artikelType);
            Artikel a = new Artikel(code, min, aant, pr, hetType);

            as.schrijfArtikelTypeNaarDatabase(artikelType);
            as.WijzigArtikel(a);
            RequestDispatcher view = request.getRequestDispatcher("/ArtikelWijzigen.jsp");
            view.forward(request, response);
        }

    }
}
