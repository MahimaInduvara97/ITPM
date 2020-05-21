<%@page import="java.util.ArrayList"%>
<%@page import="com.itpmweb.servlet.UploadConStructServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList Lno = (ArrayList) request.getAttribute("Lno_col");
ArrayList Statment = (ArrayList) request.getAttribute("Statment");
ArrayList Ccs = (ArrayList) request.getAttribute("Ccs_col");
ArrayList Nccs = (ArrayList) request.getAttribute("Nccs_col");
ArrayList Nics = (ArrayList) request.getAttribute("Nics_col");
ArrayList Nswitch = (ArrayList) request.getAttribute("Nswitch_col");
ArrayList Ncase = (ArrayList) request.getAttribute("Ncase_col");
ArrayList Ccspps= (ArrayList) request.getAttribute("Ccspps_col");

	%>
	
<table border=1 id="table1" class="table table-striped"
		style="color: #232f3e; width: 90%; margin-left: 69px; margin-top: 51px; text-align: center;">

		<thead>
			<tr style="background-color:#00008B; color:white"">
				<th scope="col">Lno</th>
				<th scope="col">Statment</th>
				<th scope="col">Ccs</th>
				<th scope="col">Nccs</th>
				<th scope="col">Nics</th>
				<th scope="col">Nswitch</th>
				<th scope="col">Ncase</th>
				<th scope="col">Ccspps</th>
				
			</tr>
		</thead>
		<tbody>

			<%
			for(int i=0; i<Lno.size();i++){
				out.print("<tr><td>"+Lno.get(i)+"</td>");
				out.print("<td>"+Statment.get(i)+"</td>");
				out.print("<td>"+ Ccs.get(i) +"</td>");
				out.print("<td>"+Nccs.get(i)+"</td>");
				out.print("<td>"+Nics.get(i)+"</td>");
				out.print("<td>"+Nswitch.get(i)+"</td>");
				out.print("<td>"+Ncase.get(i)+"</td>");
				out.print("<td>"+Ccspps.get(i)+"</td></tr>");
				
				
			}
			%>
		
		<tbody>
	</table>



</body>
</html>