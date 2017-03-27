package Controllers;

import Model.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* @generated
*/
public class LoginController {
    
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
