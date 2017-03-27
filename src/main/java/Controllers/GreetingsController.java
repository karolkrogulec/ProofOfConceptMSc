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
public class GreetingsController extends HttpServlet{
        
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	    try
{
     String greeting = request.getParameter("gr");
     HttpSession session = request.getSession(true);
     int id = (Integer) session.getAttribute("id");
     UserDao.updateGreet(greeting,id);
     session.setAttribute("greeting",greeting);
     response.sendRedirect("UserLogged.jsp");
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
    
    /**
    * @generated
    */
    private String NewGreeting;
    
    
    
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
    
    /**
    * @generated
    */
    public String getNewGreeting() {
        return this.NewGreeting;
    }
    
    /**
    * @generated
    */
    public void setNewGreeting(String NewGreeting) {
        this.NewGreeting = NewGreeting;
    }
}
