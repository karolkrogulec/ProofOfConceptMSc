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
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

         <center>
            <%-- displaying the fullname and the freeting of the
            current user pushed to the session--%> 
            <% String greet = (String) session.getAttribute("greeting");%>
            <% String full = (String) session.getAttribute("fullname");%>
			
            <%= greet %> <%= full %>
            	<body>
        <%-- Update greeting web form
        Greeting controller called to handle the request--%> 	
		<form action="GreetingsController">	
		
			Chenge your greeting
			<input type="text" name="gr"/>
			
			<input type="submit" value="change">			
		
		</form>
         </center>

      </body>
	
   </html>