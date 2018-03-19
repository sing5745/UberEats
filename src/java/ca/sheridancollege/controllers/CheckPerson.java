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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Inder
 */
@WebServlet(name = "CheckPerson", urlPatterns = {"/checkPerson"})
public class CheckPerson extends HttpServlet {

    String dbHost = "jdbc:mysql://localhost/";
    String dbUser = "root";
    String dbPassword = "root";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session= request.getSession();
         String password = request.getParameter("regP");
            String email = request.getParameter("regU");
            User u = new User(email,password);
            
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
        
        boolean b =  dao.CheckUsernameExists(u);
        
        session.setAttribute("email", email);
        
       if(b == true)
       {
           
           RequestDispatcher view = request.getRequestDispatcher("checkout");
           view.forward(request, response); 
       }
       else
       {
           
           RequestDispatcher view = request.getRequestDispatcher("register.jsp");
           view.forward(request, response);
       }
        
    }

}
