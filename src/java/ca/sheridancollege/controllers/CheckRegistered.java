/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import ca.sheridancollege.dao.DAO;
import ca.sheridancollege.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Inder
 */
@WebServlet(name = "CheckRegistered", urlPatterns = {"/checkRegistered"})
public class CheckRegistered extends HttpServlet {

    String dbHost = "jdbc:mysql://localhost/";
    String dbUser = "root";
    String dbPassword = "root";
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        
            String password = request.getParameter("regP");
            String email = request.getParameter("regU");
            User u = new User(email,password);
            
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
        
        boolean b =  dao.CheckUsernamePasswordExists(u);
        boolean chkEmail = dao.CheckUsernameExists(u);
        
        
       if(chkEmail == true)
       {
           if(b == true)
           {
            RequestDispatcher view = request.getRequestDispatcher("forget.html");
            view.forward(request, response); 
           }
       }

        
        
        
    }

    
    
}
