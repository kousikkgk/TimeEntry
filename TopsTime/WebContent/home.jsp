<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>


<html>
	<head>
		<title>Login page</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<script type="text/javascript" src="javascript/jscript.js"></script>
		
		<style>
			
		</style>
	</head>

	<body>
		<div id="wrapper">

			<div id="header">
			<div class="top-right">Hello, <%= session.getAttribute("theName") %></div>
			</div>
			<!--<marquee style="color:red;">Welcome To TOPS TIME TRACKING APPLICATION.</marquee!-->
		 
			<div id="container">
		 
				<div id="nav">
					<div class="right"><h3 align="center">Add/Edit/Delete</h3></div>

					<!--<div class="left"><h3 align="center">Edit/Delete</h3></div>-->
					
					
					
				</div>	

			</div>
		 
			<br><br><br><br>

		 <!---For options--->
			<div id="nav1">
				<div id="options">
					<%-- <table width="50%" align="center">
						<tr>
							<td>Period Name : <input type="week" name="indt" /></td>
							<td>
									Project | Role* : 
									
								<%
								         try{
								         
								           
								           	  Class.forName("com.mysql.jdbc.Driver");
								              final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
								              final String DB_URL = "jdbc:mysql://localhost:3306/tops";
								              final String USER = "root";
								              final String PASS = "root";
								              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
								        	  Statement statement = conn.createStatement() ;
								        	  resultset =statement.executeQuery("select * from employee") ;
							     %>
							   
							     <select>
							        <%  while(resultset.next()){ %>
							            <option><%= resultset.getString(3)%></option>
							         <% } %>
							     </select>
							   
							     <%
							             }
							             catch(Exception e)
							             {
							                  out.println("wrong entry"+e);
							             }
							     %>
										
							</td>
							<td><input type="submit" name="button"></td>
						</tr>	
					</table > --%>
				</div>
				
				<!---for icons--->
				<br><br>
				<div id="icons">
				<table width="50%" align="center" >
				
				<tr>
				<td></td>
				<td></td>
				<td align="right"><i style="font-size:15px" class="fa">&#xf044;&nbsp<i style="font-size:15px" class="fa">&#xf021;</i></td>
				</tr>
				</table>
				</div>
				</div>
				
				<!-- OPTION- -->
				
				
				
				<table>

		<tr>

			<td width="500" align="left"><input type="button" id="addRow" value="Add Row" onclick="addRow()" /></td>

			<td width="400" align="left">Choose Date : <input type="date" name="indt" /></td>

			<td width="300" align="left"><button>Last week Activities</button></td>

			<td width="200" align="left"><input type="reset" align="right" value="Clear Efforts"></td>

			<td width="300" align="left"><p>Hours Total : </p></td>

			<td width="200" align="left"><p>Hours Selected : </p></td>

		</tr>

	</table>

	

	

	<hr>

		
		<!-- <body onload="createTable()">

			    

			    THE CONTAINER WHERE WE'll ADD THE DYNAMIC TABLE

			    <div id="cont"></div>


			    <p><input type="button" id="bt" value="Submit" onclick="submit()" /></p>

		</body>

		
		<div id="footer"></div>
				</div>
				
			
	</body> -->
	
	<body>
	<form action="entin" method="post">

 <table>
 
  <tr></tr>
  <!-- DROPDOWN FOR PROJECT NAME -->
  <tr>
   <td>Project Name :</td>
   <td align="left"> 
   
       <%
           try{
           
             
             Class.forName("com.mysql.jdbc.Driver");
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
                final String USER = "root";
                final String PASS = "root";
              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement statement = conn.createStatement() ;
          resultset =statement.executeQuery("select * from project") ;
       %>
     
       <select name="proj">
          <%  while(resultset.next()){ %>
              <option><%= resultset.getString(1)%></option>
           <% } %>
       </select>
     
       <%
               }
               catch(Exception e)
               {
                    out.println("wrong entry"+e);
               }
       %>
   </td>
   <td style="algin:right;"><label>MON : </label><input type="number" name="mon" min="0" max="24"></td>
  </tr>
   
  <tr></tr>
     
  <tr>
   <td>Process Name : </td>
   <td> <!-- DROPDOWN FOR COMMON PROCESS -->
   
       <%
           try{
           
             
             Class.forName("com.mysql.jdbc.Driver");
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
                final String USER = "root";
                final String PASS = "root";
              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement statement = conn.createStatement() ;
          resultset =statement.executeQuery("select * from process") ;
       %>
     
       <select name="proc">
          <%  while(resultset.next()){ %>
              <option><%= resultset.getString(2)%></option>
           <% } %>
       </select>
     
       <%
               }
               catch(Exception e)
               {
                    out.println("wrong entry"+e);
               }
       %>
    </td>
    <td><label>TUE : </label><input type="number" name="tue" min="0" max="24"></td>
  </tr>
   
  <tr></tr>  
     
  <tr>
   <td>Work Request : </td>
   <td><!-- DROPDOWN FOR WORK REQUEST -->
   
       <%
           try{
           
             
             Class.forName("com.mysql.jdbc.Driver");
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
                final String USER = "root";
                final String PASS = "root";
              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement statement = conn.createStatement() ;
          resultset =statement.executeQuery("select * from workrequest") ;
       %>
     
       <select name="woreq">
          <%  while(resultset.next()){ %>
              <option><%= resultset.getString(2)%></option>
           <% } %>
       </select>
     
       <%
               }
               catch(Exception e)
               {
                    out.println("wrong entry"+e);
               }
       %>
       
    </td>
   <td><label>WED : </label><input type="number" name="wed" min="0" max="24"></td>
 <!--    <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
    
    <td><label>MON : </label><input type="number" name="mon" min="0" max="24"></td>
    <td><label>TUE : </label><input type="number" name="tue" min="0" max="24"></td>
    <td><label>WED : </label><input type="number" name="wed" min="0" max="24"></td>
    <td><label>THU : </label><input type="number" name="thu" min="0" max="24"></td>
    <td><label>FRI : </label><input type="number" name="fri" min="0" max="24"></td>
    <td><label>SAT : </label><input type="number" name="sat" min="0" max="24"></td>
    <td><label>SUN : </label><input type="number" name="sun" min="0" max="24"></td>
  --> </tr>
   
  <tr></tr>
   
  <tr>
   <td>Enter Activity : </td>
   <td><!-- DROPDOWN FOR ACTIVITY -->
   
       <%
           try{
           
             
             Class.forName("com.mysql.jdbc.Driver");
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
                final String USER = "root";
                final String PASS = "root";
              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement statement = conn.createStatement() ;
          resultset =statement.executeQuery("select * from activity") ;
       %>
     
       <select name="act">
          <%  while(resultset.next()){ %>
              <option><%= resultset.getString(2)%></option>
           <% } %>
       </select>
     
       <%
               }
               catch(Exception e)
               {
                    out.println("wrong entry"+e);
               }
       %>
   </td>
   <td><label>THU : </label><input type="number" name="thu" min="0" max="24"></td>
  </tr>
   
  <tr></tr>
     
  <tr>
   <td>Work Unit Details : </td>
   <td style="width: 200px;"><!-- DROPDOWN FOR WORK UNIT -->
   
       <%
           try{
           
             
             Class.forName("com.mysql.jdbc.Driver");
                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
                final String USER = "root";
                final String PASS = "root";
              Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
          Statement statement = conn.createStatement() ;
          resultset =statement.executeQuery("select * from work_unit_details") ;
       %>
     
       <select name="worunit">
          <%  while(resultset.next()){ %>
              <option><%= resultset.getString(2)%></option>
           <% } %>
       </select>
     
       <%
               }
               catch(Exception e)
               {
                    out.println("wrong entry"+e);
               }
       %>    
   </td>
  </tr>
 
  <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
 
  <tr>
   <td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
   <td>
    <input type="submit" value="submit">
   </td>
  </tr>
 
 </table>
</form>
	
	</body>
	
</html>