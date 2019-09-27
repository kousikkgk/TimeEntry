<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%ResultSet resultset =null;%>
<%@page import="com.webapp.servlet.GetConnection"%>
<%@page import="com.webapp.servlet.TimePOJO"%>
<%
	String gProjName;
	String gProcess;
	String gWrkReq;
	String gActivity;
	String gWrkUnit;
%>
<%-- <html>
	<head>
		<title>Home page</title>
	</head>
	<body>
		<form>
				<h1>Hello ${query1} </h1>
		</form>
	</body>
	
</html>

 --%>

<html>
<head>
<title>Login page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
	<style type="text/css">
		<%@ include file ="styles.css" %>
	</style>
<!--link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
			$(document).ready(function(){
 		 		$("#addRow").click(function(){
    			$(".entrydiv").toggle();
  				});
			});
</script>
<!-- 		<script type="text/javascript" src="javascript/jscript.js"></script>	 -->
<style>
</style>
</head>
<body>
	<div id="wrapper">

		<div id="header">
			<div class="top-right">
				Hello,
				<%= session.getAttribute("name") %></div>
		</div>
		<!--<marquee style="color:red;">Welcome To TOPS TIME TRACKING APPLICATION.</marquee!-->

		<div id="container">

			<!-- <div id="nav">
					<div class="right"><h3 align="center">Add/Edit/Delete</h3></div>

					<div class="left"><h3 align="center">Edit/Delete</h3></div>
					
					
					
				</div>	 -->

		</div>

		<br>
		<br>
		<br>
		<br>

		<table>
			<tr>
				<td width="500" align="left"><input type="button" id="addRow"
					value="Add Row" onclick="addRow()" /></td>

				<td width="300" align="left"><input type="button"
					value="Last week Activities" /></td>

				<td width="300" align="left"><p>Hours Total :</p></td>

				<td width="200" align="left"><p>Hours Selected :</p></td>

				<td width="500" align="left">Choose Date : <input type="date"
					name="indt" id="datefld" placeholder="Choose date" /></td>

			</tr>

		</table>



		<hr>
		<div>
			<form action="entin" method="post" id="myform">
				<div>
					<div class="entrydiv"
						style="width: 920px; float: left; height: 300px; margin: 10px">

						<div id="act-div">

							<table>
								<tr>
									<td>Project Name :</td>
									<td>
										<%
						           try{
						             	Class.forName("com.mysql.jdbc.Driver");
						                final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
						                final String DB_URL = "jdbc:mysql://localhost:3306/tops";
						                final String USER = "root";
						                final String PASS = "root";
						              	Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
						          		Statement statement = conn.createStatement() ;
						          		resultset =statement.executeQuery("select distinct a.project_name from project a,emp_proj b,employee c where a.project_id = b.Project_id and b.emp_id = c.emp_id and c.emp_id ="+session.getAttribute("id")+"  and c.emp_active='Y'") ;
						       %> <select name="proj_name" id="proj_name">
											<%  while(resultset.next()){ %>
											<option selected="Selected">Select Project</option>
											<option><%=resultset.getString(1)%></option>
											<% } %>
									</select> <script>
						       	$(document).ready(function(){
						       		var proName;
						    	   $("#proj_name").change(function(e){
						    		   //e.preventDefault();
						    		  proName = $( "#proj_name option:selected" ).text();
						    			if(proName!=null)
						    			{
						    				//alert("Data: ");
						    		  		$.post("projname",
						    				    {
						    				      data: proName,
						    				      dataType: 'json',
						    				    },
						    				    function(data,status){
						    				     // alert("Data: " + data);
						    				      /* $.each(data, function (i, item) {
					    				   				//alert(item);
					    				   			    $('#proj_process').append($('<option>', { 
					    				   			        value: item.id,
					    				   			        text : item.name 
					    				   			    }));
					    				   			});  */
					    				   			
					    				   			
						    				      $.each(data, function (i, item) {
					    				   				//alert(item);
					    				   			    $('#proj_process').append($('<option>', { 
					    				   			        //value: item.id,
					    				   			        text : item.name 
					    				   			    }));
					    				   			}); 
						    	 			    });
						    			}
						    	   		});
						    	   $("#datefld").change(function(e)
						    		{
						    		   var dateFld=$( "#datefld").val();
						    		   alert(dateFld);
						    		  // alert(dateFld);
						    		    $.post("projname",
						    				    {
						    				      dateaj: dateFld,
						    				    },
						    				    function(data,status){
						    				     // alert("Data: " + data + "\nStatus: " + status);
						    				      
						    				    }); 
						    		});
						    	   
						    	 }); 
						       </script> <%
						               }
						               catch(Exception e)
						               {
						                    out.println("wrong entry"+e);
						               }
						       %>
									</td>
								</tr>

								<tr>
									<td>Common Process :</td>
									<td><select name="proj_process" id="proj_process">
											<option selected="Selected">Select Process</option>
									</select> <script>
						       	$(document).ready(function(){
						    	   $("#proj_process").change(function()
						    		{
										var projProcs = $( "#proj_process option:selected" ).text();
						    			if(projProcs!=null)
						    			{
						    				//alert("Data: ");
						    		  		$.post("procsname",
						    				    {
						    				      data: projProcs,
						    				      dataType: 'json',
						    				    },
						    				    function(data,status){
						    				     // alert("Data: " + data);
						    				      $.each(data, function (i, item) {
					    				   				//alert(item);
					    				   			    $('#wrkreq').append($('<option>', { 
					    				   			        //value: item.id,
					    				   			        text : item.name 
					    				   			    }));
					    				   			}); 
						    	 			    });
						    			}
						    	   		});
						    	   
						    	 }); 
						       </script></td>
								</tr>
								<tr>
									<td>Work Request :</td>
									<td><select name="wrkreq" id="wrkreq">
											<option selected="Selected">Select Request</option>
									</select> <script>
						       	$(document).ready(function(){
						       		var wrkReq;
						    	   $("#wrkreq").change(function(e){
						    		   //e.preventDefault();
						    		  // alert("Data: ");
						    		  wrkReq = $( "#wrkreq option:selected" ).text();
						    		  //alert("Data: " + wrkReq);
						    		//alert(proProcess);
						    		  $.post("wrkreq",
						    		  {
						    				      data: wrkReq,
						    				    },
						    				    function(data,status){
						    				      //alert("Data: " + data + "\nStatus: " + status);
						    				    	//alert("Data: " + data);
							    				      $.each(data, function (i, item) {
						    				   				//alert(item);
						    				   			    $('#activity').append($('<option>', { 
						    				   			       // value: item.id,
						    				   			        text : item.name 
						    				   			    }));
						    				   			}); 
						    				    });
						    	   });
						    	   });
						    	 
						       </script></td>
								</tr>
								<tr>
									<td>Activity :</td>
									<td><select name="activity" id="activity">
											<option selected="Selected">Select Activity</option>
									</select></td>
								</tr>
								<tr>
									<td>Work Unit :</td>
									<td><select name="wrkunit" id="wrkunit">
											<option selected="Selected">Select Unit</option>
									</select> <script>
						       	$(document).ready(function(){
						       		var wrkReq;
						    	   $("#activity").change(function(e){
						    		   //e.preventDefault();
						    		  // alert("Data: ");
						    		  wrkReq = $( "#activity option:selected" ).text();
						    		  //alert("Data: " + wrkReq);
						    		//alert(proProcess);
						    		  $.post("activity",
						    		  {
						    				      data: wrkReq,
						    				    },
						    				    function(data,status){
						    				      //alert("Data: " + data + "\nStatus: " + status);
						    				    	//alert("Data: " + data);
							    				      $.each(data, function (i, item) {
						    				   				//alert(item);
						    				   			    $('#wrkunit').append($('<option>', { 
						    				   			       // value: item.id,
						    				   			        text : item.name 
						    				   			    }));
						    				   			}); 
						    				    });
						    	   });
						    	   });
						    	 
						       </script></td>
								</tr>

							</table>
						</div>
					</div>



					<div class="entrydiv"
						style="width: 920px; float: right; height: 200px; margin: 10px">

						<table>
							<tr>
								<td>MON :</td>
								<td><input type="number" name="mon" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>TUE :</td>
								<td><input type="number" name="tue" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>WED :</td>
								<td><input type="number" name="wed" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>THU :</td>
								<td><input type="number" name="thu" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>FRI :</td>
								<td><input type="number" name="fri" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>SAT :</td>
								<td><input type="number" name="sat" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
							<tr>
								<td>SUN :</td>
								<td><input type="number" name="sun" min="0" max="24"
									placeholder="Please Enter Your Efforts in Hours"></td>
							</tr>
						</table>
						<div style="margin-top: 5%;">
							<table>
								<tr>
									<td style="width: 10px;align=right;"><input type="reset"
										value="Clear Efforts" /></td>
									<td style="width: 10px;align=right;"><input type="button"
										value="save" /></td>
									<td style="width: 10px;align=right;"><input type="submit"
										value="submit" /></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				</form>
				<!-- <script>
				$(document).ready(function(){
				$("#myform").submit(function(){
					  var x = $("#myform").serializeArray();
					// alert(x);
						$.post("entin",
					    		  {
					    				      data:{'json':$("myform").serializeArray()},
					    				    },
					    				    function(data,status){
					    				      //alert("Data: " + data + "\nStatus: " + status);
					    				    	alert("Data: " + data+" status "+status);
						    				      /* $.each(data, function (i, item) {
					    				   				//alert(item);
					    				   			    $('#wrkunit').append($('<option>', { 
					    				   			       // value: item.id,
					    				   			        text : item.name 
					    				   			    }));
					    				   			});  */
					    				    });
					});
				});
				/* $(document).ready(function(){
					
					var form=$("#myform");
					$("#myform").click(function(){
						alert($("#myform").serializeArray());
						alert("inside");
					$.ajax({
					        type:"POST",
					        url:"entin",
					        data:$("#myform").serializeArray();,
					        success: function(data){
					        if(data === 1){
					            //load chech.php file 
					            alert("success");
					        }  else {
					            //show error
					        	alert("error");
					        }
					        }
					    });
					});
					}); */

				   // });

				//});
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		/* 		(document).ready(function(){
		       		var wrkReq;
		       	 	$("#myform").submit(function(e) {
		    		   //e.preventDefault();
		    		  alert("Data: ");
		    		 // wrkReq = $( "#wrkreq option:selected" ).text();
		    		  //alert("Data: " + wrkReq);
		    		//alert(proProcess);
		    		  $.post("entin",
		    		  {
		    			  	data: $("#myform").serialize(),
		    				    },
		    				    function(data,status){
		    				      //alert("Data: " + data + "\nStatus: " + status);
		    				    	alert("status="+status);
			    				      /* $.each(data, function (i, item) {
		    				   				alert(item);
		    				   			    $('#activity').append($('<option>', { 
		    				   			       // value: item.id,
		    				   			        text : item.name 
		    				   			    }));
		    				   			});  
		    				    });
		    	   });
		    	   });  */
				</script> -->
		</div>

		<p id="testid">Test</p>
</body>

</html>
