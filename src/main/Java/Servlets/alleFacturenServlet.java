/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Domain.Factuur;
import Service.FactuurService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thijs
 */
public class alleFacturenServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FactuurService fService = ServiceProvider.getFactuurService();
        String id = request.getParameter("id");
        String knop = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("AlleFacturen.jsp");
        Integer i;
        System.out.println(id);
        if (knop.equals("Open")) {
            if (id != null) {
                i = Integer.parseInt(id);
                Factuur factuur = fService.getFactuur(i);
                System.out.println("" + id);
                request.setAttribute("fact", factuur);
            }
        }
        rd.forward(request, response);
    }
}
