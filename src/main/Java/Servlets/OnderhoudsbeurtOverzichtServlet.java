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
@WebServlet(name = "OnderhoudsbeurtOverzichtServlet", urlPatterns = {"/OnderhoudsbeurtOverzichtServlet"})
public class OnderhoudsbeurtOverzichtServlet extends HttpServlet {

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
            out.println("<title>Servlet OnderhoudsbeurtOverzichtServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OnderhoudsbeurtOverzichtServlet at " + request.getContextPath() + "</h1>");
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
        
        List<Auto> alleAutos = (List<Auto>) request.getSession().getAttribute("Autos");
        List<Onderhoudsbeurt> alleOnderhoudsbeurten = null;
        //Klant k = (Klant) request.getSession().getAttribute("User");
        AutoService as = ServiceProvider.getAutoService();
        PlanningService os = ServiceProvider.getOnderhoudsbeurtService();
        RequestDispatcher rd = request.getRequestDispatcher("Onderhoudsbeurt.jsp");
        
        String selectedAuto = request.getParameter("autos");
        
        for(Auto a : alleAutos){
            if(a.getKenteken().equals(selectedAuto)){
                
            }
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
