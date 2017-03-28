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
             
             String url = "jdbc:mysql://olfx3blf98416kcx:rowvofb4zn38tw1k@sabaik6fx8he7pua.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306//";//dev "jdbc:mysql://db:3306/" //prod jdbc:mysql://olfx3blf98416kcx:rowvofb4zn38tw1k@sabaik6fx8he7pua.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/
             String dbName = "rkw2ywpakm09gcdf"; // dev "ProofOfConcept" //prod "rkw2ywpakm09gcdf"
             String driver = "com.mysql.jdbc.Driver";
             String userName = "olfx3blf98416kcx"; // dev "prototype" //prod olfx3blf98416kcx
             String password = "rowvofb4zn38tw1k"; // dev "password" //prod rowvofb4zn38tw1k
            
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