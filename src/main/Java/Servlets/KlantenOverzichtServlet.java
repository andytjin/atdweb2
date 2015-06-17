/*
 * Licsense Header
 */
package Servlets;

import Domain.Klant;
import Service.KlantService;
import Service.ServiceProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            KlantService ks = ServiceProvider.getKlantService();
            List<Klant> lijst = new ArrayList<Klant>();
            if(uname.equals("")){
                lijst = ks.getAlleKlanten();
            }else{
            
            Klant k = ks.getKlant(uname);
            
            lijst.add(k);
            }
            
            request.setAttribute("KlantenLijst", lijst);
            
        } else {
            KlantService ks = ServiceProvider.getKlantService();
            List<Klant> lijst = ks.getAlleKlanten();
            for (Klant k : lijst) {
                if (k.isWiltHerinnering()) {
                    Properties props = System.getProperties();
                    props.put("mail.smtp.starttls.enable", true);
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.user", "username");
                    props.put("mail.smtp.password", "password");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", true);

                    Session session = Session.getInstance(props, null);
                    MimeMessage message = new MimeMessage(session);

                    System.out.println("Port: " + session.getProperty("mail.smtp.port"));

                    try {
                        InternetAddress from = new InternetAddress("to4henkpaladijn@gmail.com");
                        message.setSubject("Yes we can");
                        message.setFrom(from);
                        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("maxraadgever@gmail.com"));
                        Multipart multipart = new MimeMultipart("alternative");

                        BodyPart messageBodyPart = new MimeBodyPart();
                        messageBodyPart.setText("some text to send");

                        multipart.addBodyPart(messageBodyPart);

                        messageBodyPart = new MimeBodyPart();
                        String htmlMessage = "Our html text";
                        messageBodyPart.setContent(htmlMessage, "text/html");

                        multipart.addBodyPart(messageBodyPart);

                        message.setContent(multipart);

                        Transport transport = session.getTransport("smtp");
                        transport.connect("smtp.gmail.com", "to4henkpaladijn", "themaopdracht4");
                        System.out.println("Transport: " + transport.toString());
                        transport.sendMessage(message, message.getAllRecipients());

                    } catch (AddressException e) {
                        e.printStackTrace();
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        request.getRequestDispatcher("KlantenOverzicht.jsp").forward(request, response);

    }

}
