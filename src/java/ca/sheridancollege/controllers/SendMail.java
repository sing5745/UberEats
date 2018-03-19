/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.controllers;

import java.util.*;
import static ca.sheridancollege.email.SendEmail.sendEmailTo;
import ca.sheridancollege.user.*;
import ca.sheridancollege.dao.DAO;
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
@WebServlet(name = "SendMail", urlPatterns = {"/sendMail"})
public class SendMail extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dbHost = "jdbc:mysql://localhost/";
        String dbUser = "root";
        String dbPassword = "root";
        
        HttpSession session = request.getSession();
        User user = new User();
        String userEmail = request.getParameter("uEmail");
        //String message = request.getParameter("message");
        
        String password = generateRandomPassword(8);
        
        user.setEmail(userEmail);
        user.setPassword(password);
        
        DAO dao = new DAO(dbHost, dbUser, dbPassword);
        
        
       
                
        if (dao.CheckUsernameExists(user))
        {    
           sendEmailTo(userEmail, "Your Password is: " + password);
           dao.addUser(user);
           RequestDispatcher view = request.getRequestDispatcher("forget_password.html");
           view.forward(request, response);
        }
        else{
             session.setAttribute("message", "Sorry we could'nt find you");
             RequestDispatcher view = request.getRequestDispatcher("register.jsp");
             view.forward(request, response);
            
        }
        
        
        session.setAttribute("email", user.getEmail());
        
        
    }

     public static String generateRandomPassword(int numberOfWords)
  {
    String[] randomStrings = new String[numberOfWords];
    Random random = new Random();
    for(int i = 0; i < numberOfWords; i++)
    {
      char[] word = new char[random.nextInt(1)+8]; // words of length 3 through 10. (1 and 2 letter words are boring.)
      for(int j = 0; j < word.length; j++)
      {
        word[j] = (char)('a' + random.nextInt(26) );
      }
      randomStrings[i] = new String(word);
      
    }
    return randomStrings[1].toUpperCase();
  }
    
   
    

}
