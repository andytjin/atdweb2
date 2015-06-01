/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Auto;
import Domain.Bedrijf;
import Domain.Klant;
import Domain.Onderhoudsbeurt;
import Persistance.AutoDAO;
import Service.AutoService;
import Service.OnderhoudsbeurtService;
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
@WebServlet(name = "PlanningServlet", urlPatterns = {"/PlanningServlet"})
public class PlanningServlet extends HttpServlet {

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
            out.println("<title>Servlet PlanningServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PlanningServlet at " + request.getContextPath() + "</h1>");
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
        String error = "";
        //Auto selecteren
        AutoService as = ServiceProvider.getAutoService();
        OnderhoudsbeurtService os = ServiceProvider.getOnderhoudsbeurtService();
        Onderhoudsbeurt ob = null;
        Auto auto = null;
        List<Auto> alleAutos = null;

        Klant k = (Klant) request.getSession().getAttribute("User");
        String knop = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("Onderhoudsbeurt.jsp");

        if (knop.equals("Get Autos")) {
            alleAutos = (List<Auto>)as.getAutoByKlant(k);
            //System.out.println(alleAutos.get(1));
            request.getSession().setAttribute("Autos", alleAutos);
        }
        String dat = request.getParameter("SelectedDate");
        System.out.println(dat);
        if (knop.equals("Akkoord")) {
            alleAutos = (List<Auto>)request.getSession().getAttribute("Autos");
            try {
                String selectedAuto = request.getParameter("autoradios");
                if (!selectedAuto.equals("")) {
                    System.out.println("geselecteerde auto: " + selectedAuto);
                    
                    int i = Integer.parseInt(selectedAuto.charAt(4) + "") - 1;
                    auto = alleAutos.get(i);
                }
            } catch (Exception e) {
                error = "U heeft nog geen autos toegevoegd aan dit account";
            }

            if (auto != null) {
                int dnr = os.getHighestDNr() + 1;
                os.addOnderhoudsbeurt(dnr, dat, auto.getKenteken());
                rd = request.getRequestDispatcher("KlantPage.jsp");
                
                //request.getSession().setAttribute("SelectedAuto", auto);
            } else {
                System.out.println("FOUT!");
                error = "U moet eerst een auto selecteren voordat u door kunt gaan";
            }
        }

        if (knop.equals("Auto Toevoegen")) {
            rd = request.getRequestDispatcher("KlantSettings.jsp");
            request.setAttribute("PageName", "Klant Settings");
        }
        if (knop.equals("Terug")) {
            rd = request.getRequestDispatcher("KlantPage.jsp");
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
