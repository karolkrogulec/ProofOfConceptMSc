package Dao;

import Model.*;
import Utils.*;

import java.sql.*;

//Data Access Object class that is responible for handling all databse transactions
public class UserDao {
    //declaring database connetion and database result set variables
    static Connection currentCon = null;
    static ResultSet  rs         = null;

    //metod to authenticate user taking user instance from user controller
    public static User login(User user) {

        //preparing some objects for connection 
        Statement stmt = null;
        //assigning passed username and password to the local variables
        String username = user.getUsername();
        String password = user.getPassword();
        //actual quesry that will search fo the username and password combination in the users table
        String searchQuery = "select * from users where UserName='" + username + "' AND Password='" + password + "'";

        // "System.out.println" prints in the console; Normally used to trace the process
        System.out.println("Your user name is " + username);
        System.out.println("Your password is " + password);
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            //DB statemanet
            stmt = currentCon.createStatement();
            //DB result set
            rs = stmt.executeQuery(searchQuery);
            //if anything retrned result set will not be empty and more variable set to true
            boolean more = rs.next();
            //if more is fale, it implies that the user does not exist in the databse
            if (!more) {
                //displaying the error on the screen
                System.out.println("Sorry, you are not a registered user! Please sign up first");
                //setting user id to 0 informing the user controller that user was not found
                user.setUserId(0);
            }
            //if more equals true, the user was found
            else if (more) {
                //storing fullname of the user retrieved from db
                String fullname = rs.getString("FullName");
                //storing id of the user retrieved from db
                int userId = rs.getInt("UserId");
                //storing greeting of the user retrieved from db
                String greeting = rs.getString("Greeting");
                //displaying greeting and full name to the console
                System.out.println(greeting + " " + fullname);
                //replacing empty full name in the user object that was passed as a parameter
                user.setFullName(fullname);
                //replacing empty greeting in the user object that was passed as a parameter
                user.setGreeting(greeting);
                //replacing empty full name in the user object that was passed as a parameter
                user.setUserId(userId);
            }
        }
        //catching exception if any and displaying the error stack trace
        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        //some exception handling
        //closing the database connection
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
        //returnig the updated user object if the user found or unchanged instance if not
        return user;
    }

    public static void updateGreet(String greet, int id) {

        //preparing some objects for connection 
        Statement stmt = null;
        //query that will update the greeting of the user id specified to the new value
        String updateQuery = "update users set Greeting='" + greet + "' where UserId='" + id + "'";
        //displaying the query in the console
        System.out.println("Query: " + updateQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            stmt.executeUpdate(updateQuery);

        }
        //cathing exception if any and prinitng the error stack trace
        catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
        }

        //some exception handling
        //closing database connetions
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
    }
    //method to add new user to the database takimg username, password and fullname
    public static void addUser(String newUsername, String newPassword, String newFullname) {
        //local database variables
        Statement stmt = null;
        ResultSet rs = null;
        //defaulting highest id to 0
        //before new user can be added, application must know what is the curent highest id
        int highestId = 0;
        //nested query to retrieve user detials with the highest id
        String searchQuery = "select * from users where UserId = (select max(UserId) from users)";
        //displaying the query as a control
        System.out.println("Query: " + searchQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            //if at least one user is present in the database,
            //result set will not be empty
            boolean more = rs.next();
            //if user found
            if (more) {
                //assigning the user id to the highest value +1
                highestId = rs.getInt("UserId") + 1;
                System.out.println("Current highest id " + highestId);
            //if no user found in the db, first id must be set to 1
            } else {
                highestId = 1;
            }

        }
        //catching exception if any and displaying the error stack trace
        catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
        }
        //some exception handling
        //cloaing the connection
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
        //preparing some objects for connection 
        Statement stmt2 = null;
        //since the next user's id was found
        //new user can be persisted with the username, password, and fullname passed to
        //the user controller form the web form
        //greeting will be set to the default value for each new user
        String insertQuery =
                             "insert into users values ('" + highestId + "','" + newUsername + "','" + newPassword + "','" + newFullname
                                 + "','This is the default greeting')";
        //displaying the query
        System.out.println("Query: " + insertQuery);

        try {
            //connect to DB 
            currentCon = ConnectionManager.getConnection();
            stmt2 = currentCon.createStatement();
            //executing query
            stmt2.executeUpdate(insertQuery);

        }
        //catching exception if any
        catch (Exception ex) {
            System.out.println("An Exception has occurred! " + ex);
        }

        //some exception handling
        //closing the databse connection
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }
    }
}
