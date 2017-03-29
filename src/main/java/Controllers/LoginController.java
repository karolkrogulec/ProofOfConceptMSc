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
//class that will authenticate user
public class LoginController extends HttpServlet {
        /**
    * @generated
    */
    private User CurrentUser;

    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {

try
{
     //setting user to a new instance of the User class
     setCurrentUser(new User());
     //setting username from http request
     getCurrentUser().setUsername(request.getParameter("un"));
     //setting password from http request
     getCurrentUser().setPassword(request.getParameter("pw"));
     //setting fullname to the blank entry that will be overwritten from the db
     getCurrentUser().setFullName("");
     //setting greeting to the blank entry that will be overwritten from the db
     getCurrentUser().setGreeting("");
     //setting user id to 0 that will be overwritten from the db
     getCurrentUser().setUserId(0);
     //calling a method to authenticate user and passing the user class instance as a parameter
     setCurrentUser(UserDao.login(getCurrentUser()));
	 //The first user id in the database must be higher then 0,
	 //if the returned user id will be greater it will indicate that the user was found
     if (getCurrentUser().getUserId()>0) {
          //receiving session
          HttpSession session = request.getSession(true);	 
          //setting the fullname session variable that will be passed to the loged user page
          session.setAttribute("fullname",getCurrentUser().getFullName()); 
          //setting the greetin session variable that will be passed to the loged user page
          session.setAttribute("greeting",getCurrentUser().getGreeting()); 
          //setting the user id session variable that will be passed to the loged user page
          session.setAttribute("id",getCurrentUser().getUserId()); 
          //redirecting to logged user page where session variables will be displayed
          response.sendRedirect("UserLogged.jsp"); //logged-in page   
     //if the fefault value will be returned it will mean that,
	 //the username and password combination was not found
     } else 
          response.sendRedirect("InvalidLogin.jsp"); //error page 
} 	
//catching exception if any
catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
    //getter and setter for a new user
    
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
