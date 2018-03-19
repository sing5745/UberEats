/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import ca.sheridancollege.*;
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
@WebServlet(name = "Mcdonalds", urlPatterns = {"/addMcd"})
public class Mcdonalds extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        ArrayList<BigMac> bm ;
        ArrayList<NuggetMeal> nm ;
        ArrayList<HappyMeal> hm;
         
        HttpSession session = request.getSession();
        String bigmac = request.getParameter("BigMacMeal");
        String nugget = request.getParameter("NuggetMeal");
        String happy = request.getParameter("HappyMeal");
        
        if (session.getAttribute("BigMacList") != null)
        {
            bm = (ArrayList)session.getAttribute("BigMacList");
        }
        else{
            bm = new ArrayList();
        }
        
         if (session.getAttribute("NuggetList") != null)
        {
            nm = (ArrayList)session.getAttribute("NuggetList");
        }
        else{
            nm = new ArrayList();
        }
         if (session.getAttribute("HappyMealList") != null)
        {
            hm = (ArrayList)session.getAttribute("HappyMealList");
        }
        else{
            hm = new ArrayList();
        } 
            
        
        if (bigmac != null)
        {
            bm.add(new BigMac(Integer.parseInt(bigmac), "Big Mac Meal"));
        }
        if (nugget != null)
        {
            nm.add(new NuggetMeal(Integer.parseInt(nugget),"Nugget Meal"));
        }
        if (happy != null)
        {
            hm.add(new HappyMeal(Integer.parseInt(happy),"Happy Meal"));
        }
        
        
        
        session.setAttribute("bms", bm.size());
        session.setAttribute("hps", hm.size());
        session.setAttribute("nms", nm.size());
        
        session.setAttribute("BigMacList", bm);
        session.setAttribute("NuggetList", nm);
        session.setAttribute("HappyMealList", hm);
       
        
        session.setAttribute("items", hm.size() + nm.size() + bm.size());
        request.getRequestDispatcher("mcd.jsp").forward(request, response);
    }

}
