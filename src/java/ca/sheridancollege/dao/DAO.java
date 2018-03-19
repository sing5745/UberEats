/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package ca.sheridancollege.dao;

import ca.sheridancollege.beans.Order;
import ca.sheridancollege.user.User;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Inder
 */
public class DAO {

    private final String userName;
    private final String password;
    private final String host;

    String database = "uberemail";
    
    public DAO(String host, String userName, String password)
    {
        this.userName = userName;
        this.password = password;
        this.host = host;
    }
    
     public ArrayList<Order> getOrders(String databaseOrder,String name) {
       
        ArrayList<Order> order = new ArrayList();
        try{
            //Create a connection to our JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Create a connection to the SQL Server
            //(Database, user, password)
            Connection con = DriverManager.getConnection
             (host + databaseOrder, userName, password);
            
            Statement st = con.createStatement();
            
            String Query = "SELECT * FROM " + databaseOrder + " WHERE EMAIL = '" + name + "'"; //MySQL statement
            
            ResultSet rs =st.executeQuery(Query);
            //ResultSet rs = st.executeUpdate(Query);
            
            
            
            
            
            while (rs.next()){
                Order o = new Order(Integer.parseInt(rs.getString(1)),
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    Double.parseDouble(rs.getString(5)),
                                    rs.getString(6)
                                            );
                                    

               // System.out.println(d.toString());
               order.add(o);
                
            }
            
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return order;
    }
     
    public void addOrder(Order o,String databaseOrder, String email)
    {
         try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //Try to connect to the database.  If the database does 
	    //not exist then create it.
	    //The database in this case is called "mycontacts"
	    
            try
            {
                con = DriverManager.getConnection
			(host + databaseOrder, userName, password);
            
            }catch(Exception e)
            {
                con = DriverManager.getConnection
                (host, userName, password);
                Statement st = con.createStatement();
                st.executeUpdate("CREATE DATABASE " + databaseOrder);
                con = DriverManager.getConnection
			(host + databaseOrder, userName, password);
                System.out.println(st);
                
            }
            
             //String to add a new row goes here.
            
            String add = "INSERT INTO " + databaseOrder + "(orderno,email, address, items, total, orderdate)" 
                    + " VALUES "+
                    "('"+ o.getOrderno()
                         +"', '"+ email
                        +"', '"+ o.getAddress()
                         +"', '"+ o.getItems()
                          +"', '"+ o.getTotal()
                           +"', '"+ o.getDate()
                         +"')";
            System.out.println(add);   
            Statement st = con.createStatement();
            
            //Add the new contact into the SQL table.
            try
            {
                st.executeUpdate(add);
                System.out.println(add);
            }catch(Exception e)
            {
                 //String to make a new table goes here.
                
            String make = 
                    "CREATE TABLE " + databaseOrder +
                    "(orderno  CHAR(50)"
                    + ",email CHAR(50)"
                    + ",address CHAR(50)"
                    + ",items CHAR(50)"
                    + ",total CHAR(50)"
                    + ",orderdate CHAR(50)"
                    + ")";   
                
            
            
                     
                System.out.println(make);
                st.executeUpdate(make);
                st.executeUpdate(add);
            }
            con.close();

            
                    
        }catch(Exception e)
        {
            System.out.println("No man");
        }
    }
    
    
    
    
    
    public  void addUser(User user)
    {
         try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //Try to connect to the database.  If the database does 
	    //not exist then create it.
	    //The database in this case is called "mycontacts"
	    
            try
            {
                con = DriverManager.getConnection
			(host + database, userName, password);
            
            }catch(Exception e)
            {
                con = DriverManager.getConnection
                (host, userName, password);
                Statement st = con.createStatement();
                st.executeUpdate("CREATE DATABASE " + database);
                con = DriverManager.getConnection
			(host + database, userName, password);
                
                
            }
            
             //String to add a new row goes here.
            
            String add = "INSERT INTO " + database + " (email, password)" 
                    + " VALUES "+
                    "('"+ user.getEmail()
                        +"', '"+ user.getPassword()
                         +"')";
            System.out.println(add);   
            Statement st = con.createStatement();
            
            //Add the new contact into the SQL table.
            try
            {
                st.executeUpdate(add);
                System.out.println(add);
            }catch(Exception e)
            {
                 //String to make a new table goes here.
                
                
            String make = 
                    "CREATE TABLE " + database +
                    "(email  CHAR(50)"
                    + ",password CHAR(8)"
                    + ")";
            
                     
                System.out.println(make);
                st.executeUpdate(make);
                st.executeUpdate(add);
            }
            con.close();

            
                    
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public User checkPasswordFromDatabase(String user) {
       
        /*
         * when checking user 
         * this method returns a new user 
         */
        User u = new User();
        //ArrayList<String> contacts = new ArrayList();
        try{
            //Create a connection to our JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //Create a connection to the SQL Server
            //(Database, user, password)
            Connection con = DriverManager.getConnection
             (host + database, userName, password);
            
            Statement st = con.createStatement();
            
            String Query = "SELECT * FROM " + database; //MySQL statement
            
            ResultSet rs =st.executeQuery(Query);
            //ResultSet rs = st.executeUpdate(Query);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next()){
                
                                    
                u.setPassword(rs.getString(2));
                
            }
            
           
            
            System.out.println(rs.getString(2));
            
            con.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
        return u;
    }
    
    public boolean CheckUsernamePasswordExists(User u)
{
    boolean usernameExists = false;

    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(host + database, userName, password);
        // s = "select password from " + database + "where email = ' " + u.getEmail() + "' and password = '" + u.getPassword() + "'";
        PreparedStatement st = connection.prepareStatement("select password from " + database + " where email = " + "'" + u.getEmail() + "'" + " and password = " + "'" + u.getPassword() + "'");
        System.out.println(st);
        ResultSet r1=st.executeQuery();
        
         if(r1.next()) 
         {
           String pass = r1.getString(1);
           
           if(pass.equals(u.getPassword())) //this part does not happen even if it should
           {
               System.out.println("It already exists");
               usernameExists = true;
               
           }
           else{
           
               usernameExists = false;
           }
         }


     }

     catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
     catch (ClassNotFoundException cE) 
     {
        System.out.println("Class Not Found Exception: "+ cE.toString());
     }

 return usernameExists;
 }
    
    
    public boolean CheckUsernameExists(User u)
{
    boolean usernameExists = false;

    try
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(host + database, userName, password);
        // s = "select password from " + database + "where email = ' " + u.getEmail() + "' and password = '" + u.getPassword() + "'";
        PreparedStatement st = connection.prepareStatement("select email from " + database + " where email = " + "'" + u.getEmail() + "'");
        System.out.println(st);
        ResultSet r1=st.executeQuery();
        
         if(r1.next()) 
         {
           String email = r1.getString(1);
           
           if(email.equals(u.getEmail())) //this part does not happen even if it should
           {
               System.out.println("It already exists");
               usernameExists = true;
               
           }
           else{
           
               usernameExists = false;
           }
         }


     }

     catch (SQLException e) 
     {
        System.out.println("SQL Exception: "+ e.toString());
     } 
     catch (ClassNotFoundException cE) 
     {
        System.out.println("Class Not Found Exception: "+ cE.toString());
     }

 return usernameExists;
 }
    
    }
    
    
    
    
