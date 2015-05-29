/*
 * Licsense Header
 */

package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Max
 */
public class KlantSecurityFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest r2 = (HttpServletRequest) request;
        if(r2.getSession().getAttribute("User") == null){
            r2.getRequestDispatcher("index.jsp").forward(request, response);
        }else{
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }

}
