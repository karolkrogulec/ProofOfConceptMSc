package Utils;

   import java.sql.*;
   import java.util.*;


   public class ConnectionManager {

      static Connection con;
      static String url;
            
      public static Connection getConnection()
      {
        
         try
         {
             String url = "jdbc:mysql://10.0.18.2:3306/";
             String dbName = "ProofOfConcept";
             String driver = "com.mysql.jdbc.Driver";
             String userName = "prototype";
             String password = "password";
            
            try
            {
               Class.forName(driver).newInstance();
               con = DriverManager.getConnection(url + dbName, userName, password);
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }
         catch(IllegalAccessException e2)
         {
            System.out.println(e2);
         }
         catch(InstantiationException e3)
         {
            System.out.println(e3);
         }

      return con;
}
   }