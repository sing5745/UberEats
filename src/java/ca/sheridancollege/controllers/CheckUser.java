/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class deals with the code to check password from user 
 * that has been set to database 
 * 
 */

package ca.sheridancollege.controllers;

import ca.sheridancollege.dao.DAO;
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
@WebServlet(name = "CheckUser", urlPatterns = {"/CheckUser"})
public class CheckUser extends HttpServlet {

    String dbHost = "jdbc:mysql://localhost/";
    String dbUser = "root";
    String dbPassword = "root";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String password = request.getParameter("uPass");
        
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
        
       if (password != null)
       {     
        
       if(dao.checkPasswordFromDatabase(password).getPassword().equals(password))
       {
           RequestDispatcher view = request.getRequestDispatcher("checkout.jsp");
           view.forward(request, response);
       }
       else
       {
         RequestDispatcher view = request.getRequestDispatcher("register.jsp");
         view.forward(request, response);   
       }
       }
        
       
    }


}
