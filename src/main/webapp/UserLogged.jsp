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
            <% String greet = (String) session.getAttribute("greeting");%>
            <% String full = (String) session.getAttribute("fullname");%>
			
            <%= greet %> <%= full %>
            	<body>
            	
		<form action="GreetingController">	
		
			Chenge you greeting
			<input type="text" name="gr"/>
			
			<input type="submit" value="change">			
		
		</form>
         </center>

      </body>
	
   </html>