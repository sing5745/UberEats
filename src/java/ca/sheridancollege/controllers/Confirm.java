/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import ca.sheridancollege.beans.*;
import ca.sheridancollege.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import static java.util.Collections.list;
import java.util.stream.Collectors;
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
@WebServlet(name = "Confirm", urlPatterns = {"/confirmOrder"})
public class Confirm extends HttpServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        
        HttpSession session = request.getSession();
        
        String street = request.getParameter("street");
        String add = request.getParameter("add");
        String city = request.getParameter("city");
        String email = session.getAttribute("email").toString();
        
        ArrayList s = (ArrayList<BigMac>) session.getAttribute("BigMacList");
        ArrayList s1 = (ArrayList<NuggetMeal>) session.getAttribute("NuggetList");
        ArrayList s2 = (ArrayList<HappyMeal>) session.getAttribute("HappyMealList");
        
        //String List = String.join(" ", s);
        
        session.setAttribute("address",street + " " + add + " " + city );
        
        ArrayList<String> itemList = new ArrayList();
        
        for (int i = 0; i < s.size(); i++)
        
       {
           BigMac nm = (BigMac) s.get(i);
            String  st = nm.getQty() + " " + nm.getName()  ;
           itemList.add(st);
                
        }
        for (int i = 0; i < s1.size(); i++)
        
       {
           NuggetMeal nm = (NuggetMeal) s1.get(i);
            String  st = nm.getQty() + " " + nm.getName()  ;
           itemList.add(st);
                
        }
        for (int i = 0; i < s2.size(); i++)
        
       {
           HappyMeal nm = (HappyMeal) s2.get(i);
           String  st = nm.getQty() + " " + nm.getName()  ;
           itemList.add(st);
                
        }
        
        String List = String.join(",", itemList);
        System.out.println(List);
        
        double fullP = (double)session.getAttribute("totalValue");
        
        Order o = new Order(randOrderNo(),email, street + " " + add + " " + city ,List,fullP, todaysDate());
        String dbHost = "jdbc:mysql://localhost/";
        String dbUser = "root";
        String dbPassword = "root";
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
       
        dao.addOrder(o, "order_database",email);
        dao.getOrders("order_database", email);
        
        System.out.println(dao.getOrders("order_database", email));
        
        session.setAttribute("Orders", dao.getOrders("order_database", email));
        response.sendRedirect("reciept.jsp");
        
        
        
    }
    
    public static int randOrderNo(){
        Random random=new Random();
             int num = 0;
        for(int j=10;j<=99;j++){        
            num=random.nextInt(100) ;
        }
       
    
        return num;
    }
    
    public static String todaysDate(){
    
       Calendar calendar = Calendar.getInstance();
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
     
       return dateFormat.format(calendar.getTime()).toString();
    }

    
}
