package Controllers;

import Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
* @generated
*/
public class UserController {
    
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
