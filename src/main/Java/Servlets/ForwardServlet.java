/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Service.FactuurService;
import Service.ServiceProvider;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ForwardServlet", urlPatterns = {"/ForwardServlet"})
public class ForwardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FactuurService fService = ServiceProvider.getFactuurService();
        
        String knop = request.getParameter("button");
        RequestDispatcher rd = null;

        if (knop.equals("Alle Facturen")) {
            rd = request.getRequestDispatcher("AlleFacturen.jsp");
            request.getSession().setAttribute("alleFacturen", fService.getAll());
            System.out.println(fService.getAll());
        }
        rd.forward(request, response);
    }

}
