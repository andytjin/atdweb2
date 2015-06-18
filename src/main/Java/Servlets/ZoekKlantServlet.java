/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Service.FactuurService;
import Service.KlantService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thijs
 */
@WebServlet(name = "ZoekKlantServlet", urlPatterns = {"/ZoekKlantServlet"})
public class ZoekKlantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FactuurService fService = ServiceProvider.getFactuurService();
        KlantService kService = ServiceProvider.getKlantService();
        RequestDispatcher rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
        String zkKlant = request.getParameter("klant");
        String knop = request.getParameter("button");

        if (knop.equals("Zoek factuur")) {
            if (!zkKlant.equals("")) {
                request.setAttribute("klantFactuur", fService.getAlleFacturen(zkKlant));
                rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
                request.getServletContext().setAttribute("klanten", kService.getAlleKlanten());
            }
        }
        rd.forward(request, response);
    }

}
