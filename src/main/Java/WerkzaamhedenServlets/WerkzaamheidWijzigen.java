/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WerkzaamhedenServlets;

import Domain.Auto;
import Domain.Monteur;
import Domain.Onderhoudsbeurt;
import Service.AutoService;
import Service.MonteurService;
import Service.OnderhoudsService;
import Service.ServiceProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andy
 */
@WebServlet(name = "WerkzaamheidWijzigen", urlPatterns = {"/WerkzaamheidWijzigen"})
public class WerkzaamheidWijzigen extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

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
        String knop = request.getParameter("knop");
        String onderhoudsbeurtID = request.getParameter("onderhoudsbeurtID");
        String datum = request.getParameter("wijzigDatum");
        String bestedeUur = request.getParameter("uur");
        String kenteken = request.getParameter("auto");
        String monteurID = request.getParameter("monteur");
        String Onderhoudid = "";
        String status = request.getParameter("status");
        Calendar date = Calendar.getInstance();
      
        int ohID = 0;
        int MonteurID = 0;
        
        try{
            Scanner sc = new Scanner(onderhoudsbeurtID);
            sc.useDelimiter("\\s*,\\s*");
            Onderhoudid = sc.next();
            
            
            sc.close();
            } catch(NoSuchElementException e){
                e.printStackTrace();
            } 
        
        if (status.equals("Selecteer Status")) {
            System.out.println("Status = null");
        } else {
            System.out.println("Status is niet null");
        }
        
        if (datum.equals("")) {
                System.out.println("datum = null");
            } else {
               
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                date.setTime(sdf.parse(datum));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            if (kenteken.equals("Selecteer Kenteken")) {
                System.out.println("Kenteken = null");
            } else {
                System.out.println("Kenteken != null");
            }
        if (Onderhoudid.equals("Selecteer OnderhoudsbeurtID")) {
            System.out.println("onderhoudsID = null");
        } else {
            ohID = Integer.parseInt(Onderhoudid);
        }
        if (monteurID.equals("Selecteer MonteurID")) {
            System.out.println("MonteurID = null");
        } else {
            MonteurID = Integer.parseInt(monteurID);
        }

        if (knop.equals("Opslaan")) {
            MonteurService mService = ServiceProvider.getMonteurService();
            Monteur m = mService.getMonteurByID(MonteurID);
            AutoService auService = ServiceProvider.getAutoService();
            Auto au = auService.getAutoByKenteken(kenteken);
            //datum, aantalbestede uren, nettoprijs
            OnderhoudsService oService = ServiceProvider.getOnderhoudsService();

            

            System.out.println("TEST : " + datum);

            Onderhoudsbeurt o = new Onderhoudsbeurt(ohID, date, au, m,status);
            if (bestedeUur.equals("")) {
                System.out.println("velden zijn leeg");
            } else {
              
                int uur = Integer.parseInt(bestedeUur);
                oService.wijzigOnderhoudsbeurt(o,uur);
                List<Onderhoudsbeurt> oLijst = oService.getAlleOnderhoudsbeurten();
                request.getSession().setAttribute("onderhoudsbeurt", oLijst);
            }
            RequestDispatcher view = request.getRequestDispatcher("/WerkzaamheidWijzigen.jsp");
            view.forward(request, response);

        }
        if(knop.equals("Terug")){
        RequestDispatcher view = request.getRequestDispatcher("/HoofdSchermWerkzaamheden.jsp");
        view.forward(request, response);
        }
    }
   

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   
}
