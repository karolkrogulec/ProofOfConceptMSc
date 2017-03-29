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
//class that will be used to control the greeting update
public class GreetingsController extends HttpServlet{
    
    //variable to stroe new greeting		               
        /**
    * @generated
    */
    private String NewGreeting;
        
        public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
    
	    try
{
     //receiving the new reetig from the htyp rewqest
     setNewGreeting(request.getParameter("gr"));
     //receiving current seesion
     HttpSession session = request.getSession(true);
     //receiving current user's id
     int id = (Integer) session.getAttribute("id");
     //calling update greet method and passing new greeting and user id as parameters
     UserDao.updateGreet(getNewGreeting(),id);
     //setting new greeing in the seesion
     session.setAttribute("greeting",getNewGreeting());
     //redirecting back to the logged user page
     response.sendRedirect("UserLogged.jsp");
 }
     //catching the exception if any
     catch (Throwable theException) 	    
{
     //outputting the error stack back to the console
     System.out.println(theException); 
}
			              		               
    }
    //getter and setter for new greeting
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
