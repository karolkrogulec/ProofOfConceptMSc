package Utils;

import java.sql.*;
import java.util.*;

//connection manager that will be used by the dao class tp establish a connection
public class ConnectionManager {
    //databse connection variables
    static Connection con;
    static String     url;
    //metod to get the database connection
    public static Connection getConnection() {

        try {
            //the below can be changed depending if the dev or prod database should be used
            //the url of MySQL database 
            String url = "jdbc:mysql://sabaik6fx8he7pua.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/";//dev "jdbc:mysql://db:3306/" //prod jdbc:mysql://sabaik6fx8he7pua.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/
            //databse name
            String dbName = "rkw2ywpakm09gcdf"; // dev "ProofOfConcept" //prod "rkw2ywpakm09gcdf"
            //databse driver
            String driver = "com.mysql.jdbc.Driver";
            //databse user
            String userName = "olfx3blf98416kcx"; // dev "prototype" //prod olfx3blf98416kcx
            //databse password
            String password = "rowvofb4zn38tw1k"; // dev "password" //prod rowvofb4zn38tw1k

            try {
                //creating new database connection
                Class.forName(driver).newInstance();
                con = DriverManager.getConnection(url + dbName, userName, password);
            }
            //catching exception if any and displaying the error stack trace
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //required exception handlers looking ofr a specifing type of exception
        catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IllegalAccessException e2) {
            System.out.println(e2);
        } catch (InstantiationException e3) {
            System.out.println(e3);
        }
        //returning the connection object
        return con;
    }
}
