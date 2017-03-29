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
public class UserController extends HttpServlet{
    //required class varaibles
        /**
    * @generated
    */
    private String Username;
    
    /**
    * @generated
    */
    private String Password;
    
    /**
    * @generated
    */
    private String FullName;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
	    try
{
     //setting username from the http request
     setUsername(request.getParameter("nu"));
     //setting password from the http request
     setPassword(request.getParameter("np"));
     //setting fullname from the http request
     setFullName(request.getParameter("nf"));
     //calling method to persist new user entry in the database
     UserDao.addUser(getUsername(), getPassword(), getFullName());
     //redirecting back to the loing page
     response.sendRedirect("LoginPage.jsp");
 }
     //catching exception if any
     catch (Throwable theException) 	    
{
     //outputting the error stack trace to the console
     System.out.println(theException); 
}
			              		               
    }
//getters and setters
    /**
    * @generated
    */
    public String getUsername() {
        return this.Username;
    }
    
    /**
    * @generated
    */
    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    /**
    * @generated
    */
    public String getPassword() {
        return this.Password;
    }
    
    /**
    * @generated
    */
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    /**
    * @generated
    */
    public String getFullName() {
        return this.FullName;
    }
    
    /**
    * @generated
    */
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }
    

    //                          Operations                                  
    
    /**
    * @generated
    */
    public void CreateNewAccount() {
        //TODO
    }
    
    
}
