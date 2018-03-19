/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import ca.sheridancollege.beans.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Inder
 */
@WebServlet(name = "Checkout", urlPatterns = {"/checkout"})
public class Checkout extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        
        HttpSession session = request.getSession();
        
        ArrayList s = (ArrayList<BigMac>) session.getAttribute("BigMacList");
        ArrayList s1 = (ArrayList<NuggetMeal>) session.getAttribute("NuggetList"
                );
        ArrayList s2 = (ArrayList<HappyMeal>) session.getAttribute("HappyMealList");
        
        double totalBM = 0;
        double totalHM = 0;
        double totalNM = 0;
        
        if (s != null) {
            for (int i = 0; i < s.size(); i++) {
                BigMac bm = (BigMac) s.get(i);

                double price = bm.getQty() * 10.99;

                totalBM += price;
            }
        }
        
        if (s1 != null) {
            for (int i = 0; i < s1.size(); i++) {
                NuggetMeal nm = (NuggetMeal) s1.get(i);

                double price = nm.getQty() * 8.99;

                totalNM += price;
            }
        }
        
       
         
        if (s2 != null)
        {
            for (int i = 0; i < s2.size(); i++) {
                HappyMeal nm = (HappyMeal) s2.get(i);

                double price = nm.getQty() * 4.99;

                totalHM += price;
            }
        }
        System.out.println(totalBM);
        System.out.println(totalHM);
        System.out.println(totalNM);
                
        double subtotal = totalBM + totalHM + totalNM;
        System.out.println(subtotal);
        double taxes = subtotal * 0.13;
        double total = taxes + subtotal + 3;
        
        session.setAttribute("subBM", totalBM);
        session.setAttribute("subHM", totalHM);
         session.setAttribute("subNM", totalNM);
        
        
        session.setAttribute("Taxes", taxes);
        session.setAttribute("Total", total );
        session.setAttribute("Subtotal", subtotal);
       
        System.out.println(session.getAttribute("totalValue"));
        
        request.getRequestDispatcher("checkout.jsp")
        .forward(request, response);
        
        
        
        
        
       
        
    }

  
}
