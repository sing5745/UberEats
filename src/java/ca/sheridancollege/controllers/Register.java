/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import static ca.sheridancollege.controllers.SendMail.generateRandomPassword;
import ca.sheridancollege.dao.DAO;
import static ca.sheridancollege.email.SendEmail.sendEmailTo;
import ca.sheridancollege.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.console;
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
@WebServlet(name = "Register", urlPatterns = {"/registerUser"})
public class Register extends HttpServlet {

    
        
  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dbHost = "jdbc:mysql://localhost/";
        String dbUser = "root";
        String dbPassword = "root";
        
        HttpSession session = request.getSession();
        
        String userEmail = request.getParameter("uname");
        
        
        String password = request.getParameter("psw");
        User user = new User(userEmail,password);
        
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
        
        System.out.println(user.toString());
        
        dao.addUser(user); 
       
        session.setAttribute("email", userEmail);
        RequestDispatcher view = request.getRequestDispatcher("checkout.jsp");
        view.forward(request, response);
        
        
    }

   
}
