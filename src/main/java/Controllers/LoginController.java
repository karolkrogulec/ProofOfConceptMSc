package Controllers;

import Model.*;
import Dao.*;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* @generated
*/
public class LoginController  extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{
     setCurrentUser(new User());
     getCurrentUser().setUsername(request.getParameter("un"));
     getCurrentUser().setPassword(request.getParameter("pw"));
     getCurrentUser().setFullName("");
     getCurrentUser().setGreeting("");
     getCurrentUser().setUserId(0);

     setCurrentUser(UserDao.login(getCurrentUser()));
	   		    
     if (getCurrentUser().getUserId()>0) {	        
          HttpSession session = request.getSession(true);	    
          session.setAttribute("fullname",getCurrentUser().getFullName()); 
          session.setAttribute("greeting",getCurrentUser().getGreeting()); 
          response.sendRedirect("UserLogged.jsp"); //logged-in page      		
     } else 
          response.sendRedirect("InvalidLogin.jsp"); //error page 
} 
		
		
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
    
    /**
    * @generated
    */
    private User CurrentUser;
    
        //                          Operations                                  
    
    /**
    * @generated
    */
    public User LogIn() {
        //TODO
        return null;
    }

    
    /**
    * @generated
    */
    public User getCurrentUser() {
        return this.CurrentUser;
    }
    
    /**
    * @generated
    */
    public void setCurrentUser(User CurrentUser) {
        this.CurrentUser = CurrentUser;
    }   
    
}
