package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
@WebServlet(name = "AdminPageServlet", urlPatterns = {"/AdminPageServlet"})
public class AdminPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("AddMonteur.jsp");
        if (button.equals("log out")) {
            rd = request.getRequestDispatcher("index.jsp");
        }
        if (button.equals("Home")){
            rd = request.getRequestDispatcher("AdminPage.jsp"); 
        }
        if(button.equals("Factuur")){
            rd = request.getRequestDispatcher("FactuurOverzichtBeheerder.jsp");
        }
        rd.forward(request, response);
    }
}
