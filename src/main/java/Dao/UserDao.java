package Dao;

import Model.*;
import Utils.*;

import java.text.*;
import java.util.*;
import java.sql.*;

   public class UserDao	
   {
      static Connection currentCon = null;
      static ResultSet rs = null;  
	
	
	
      public static User login(User user) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
	
         String username = user.getUsername();    
         String password = user.getPassword();   
	    
         String searchQuery =
               "select * from Users where UserName='"
                        + username
                        + "' AND Password='"
                        + password
                        + "'";
	    
      // "System.out.println" prints in the console; Normally used to trace the process
      System.out.println("Your user name is " + username);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+searchQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         boolean more = rs.next();
	       
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            user.setUserId(0);
         } 
	        
         else if (more) 
         {
            String fullname = rs.getString("FullName");
            int userId = rs.getInt("UserId");
            String greeting = rs.getString("Greeting");
	     	
            System.out.println(greeting +" "+ fullname);
            user.setFullName(fullname);
            user.setGreeting(greeting);
            user.setUserId(userId);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }

return user;
	
      }	
public static void updateGreet(String greet, int id) {
	
         //preparing some objects for connection 
         Statement stmt = null;    
 
	    
         String updateQuery =
               "update Users set Greeting='"
                        + greet
                        + "' where UserId='"
                        + id
                        + "'";
	    
      System.out.println("Query: "+updateQuery);
	    
      try 
      {
         //connect to DB 
         currentCon = ConnectionManager.getConnection();
         stmt=currentCon.createStatement();
         stmt.executeUpdate(updateQuery);
	       
      } 

      catch (Exception ex) 
      {
         System.out.println("An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (currentCon != null) {
            try {
               currentCon.close();
            } catch (Exception e) {
            }

            currentCon = null;
         }
      }
      }
   }
