/*
 * Licsense Header
 */
package Servlets;

import Domain.Klant;
import Service.KlantService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.mail.*;

/**
 *
 * @author Max
 */
public class KlantenOverzichtServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String button = request.getParameter("button");

        if (button.equals("Zoek klant")) {
            //ga klant zoeken
        } else {
            KlantService ks = ServiceProvider.getKlantService();
            List<Klant> lijst = ks.getAlleKlanten();
            for (Klant k : lijst) {
                if (k.isWiltHerinnering()) {
                    String emailadres = "maxraadgever@gmail.com";
                    
                    String myPassword = "password";
                    String senderId = "xyz@yahoo.com";
                    try {
                        MultiPartEmail email = new MultiPartEmail();
                        email.setSmtpPort(587);
                        //email.setAuthenticator(new DefaultAuthenticator(emailadres, myPassword));
                        email.setDebug(true);
                        email.setHostName("smtp.gmail.com");
                        email.setFrom(emailadres);
                        email.setSubject("Hi");
                        email.setMsg("This is a test mail ... :-)\n\nPlease check attachements that I have sent.\n\nThanks,\nFahim");
                        email.addTo(senderId);
                        email.setTLS(true);
                        
                        email.send();
                        System.out.println("Mail sent!");
                    } catch (Exception e) {
                        System.out.println("Exception :: " + e);
                    }
                }
            }

        }

    }

}
