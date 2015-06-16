package Filters;

import Domain.Klant;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Max
 */
public class AdminSecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r3 = (HttpServletRequest) request;
        chain.doFilter(request, response);
        Klant k = (Klant) r3.getSession().getAttribute("User");
        if(!k.getUsername().equals("HenkPaladijn")){
            System.out.println("Geen Admin");
            r3.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
           
        }
    }

    @Override
    public void destroy() {
    }

}
