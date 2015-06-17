/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Auto;
import Domain.Klant;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.PlanningService;
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
 * @author freekvdp
 */
@WebServlet(name = "PlanningServlet", urlPatterns = {"/PlanningServlet"})
public class PlanningServlet extends HttpServlet {

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
        PlanningService os = ServiceProvider.getPlanningService();
        Onderhoudsbeurt ob = null;
        Auto auto = null;
        List<Auto> alleAutos = null;

        Klant k = (Klant) request.getSession().getAttribute("User");
        String knop = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("Planning.jsp");

        String dat = request.getParameter("SelectedDate");

        if (knop.equals("Akkoord")) {
            try {
                alleAutos = null;
                Object o = request.getSession().getAttribute("Autos");
                if (o != null) {
                    alleAutos = (List<Auto>) o;
                    System.out.println("Alle autos is NIET null");
                } else {
                    System.out.println("Alle autos is null");
                }
                //System.out.println(alleAutos.size());
                String selectedAuto = request.getParameter("autoradios");
                if (!selectedAuto.equals("")) {
                    System.out.println("geselecteerde auto: " + selectedAuto);

                    for (Auto a : alleAutos) {
                        if (a.getKenteken().equals(selectedAuto)) {

                            auto = a;
                            System.out.println("auto gevonden");
                        }
                    }

                }
            } catch (Exception e) {
                error = "U heeft nog geen autos toegevoegd aan dit account";
            }

            if (auto != null) {
                //System.out.println("auto is NIET null!!");
                //TODO
                int dnr = 1;
                //System.out.println(os.getHighestDNr());
                try {
                    System.out.println(dat);
                    dnr = os.getHighestDNr() + 1;
                    System.out.println("--------dit is de try!!!!!");
                    os.addOnderhoudsbeurt(dnr, dat, auto.getKenteken());
                    rd = request.getRequestDispatcher("KlantPage.jsp");
                } catch (Exception e) {
                    System.out.println("dit is de catch!!!!!--------");
                    e.printStackTrace();
                }

                //request.getSession().setAttribute("SelectedAuto", auto);
            } else {
                System.out.println("FOUT! Auto is null");
                error = "U moet eerst een auto selecteren voordat u door kunt gaan";
            }
        }

        if (knop.equals("Auto Toevoegen")) {
            rd = request.getRequestDispatcher("/KlantSettingsPages/AutoGegevens.jsp");
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
