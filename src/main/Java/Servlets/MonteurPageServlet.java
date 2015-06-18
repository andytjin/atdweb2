
package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Max
 */
public class MonteurPageServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String button = request.getParameter("button");
        RequestDispatcher rd = request.getRequestDispatcher("MonteurPage.jsp");

        if(button.equals("Onderhoudsbeurt")){
            rd = request.getRequestDispatcher("HoofdSchermWerkzaamheden.jsp");
        }
        
        if(button.equals("Artikelen")){
            rd = request.getRequestDispatcher("HoofdSchermArtikelen.jsp");
        }
        
        rd.forward(request, response);
        
    }
}
