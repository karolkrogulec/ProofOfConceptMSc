 <%@ page language="java" 
      contentType="text/html; charset=windows-1256"
      pageEncoding="windows-1256"
   %>

   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
      "http://www.w3.org/TR/html4/loose.dtd">

   <html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>Invalid Login</title>
      </head>
	
      <body>
         <center>
            <%-- displaying user not found error message --%> 
            Sorry, you are not a registered user! Please sign up below first
		<%-- web form to create new user account
		calling user contrller to handle the request--%> 
		<form action="UserController">

			Please enter your username 		
			<input type="text" name="nu"/><br>		
		
			Please enter your password
			<input type="text" name="np"/><br>
			
			Please enter your full name 		
			<input type="text" name="nf"/><br>	
				
			<input type="submit" value="create account">			
		
		</form>
         </center>
      </body>
	
   </html>