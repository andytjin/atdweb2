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
        String fnummer = request.getParameter("fNummer");
        String knop = request.getParameter("button");
        RequestDispatcher rd = null;  
        Integer i = null;
                
        if (!fnummer.equals("")){
            if (fnummer != null) {
                i = Integer.parseInt(fnummer);
            }
        }
        if (knop.equals("Haal op")){
            rd = request.getRequestDispatcher("AlleFacturen.jsp");            
            request.getSession().setAttribute("gezochteFactuur", fService.getFactuur(i));
        }
        rd.forward(request, response);
    }

}
