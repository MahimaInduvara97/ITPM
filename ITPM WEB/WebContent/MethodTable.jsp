<%@page import="java.util.ArrayList"%>
<%@page import="com.itpmweb.model.MethForMethods"%>
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
ArrayList Cm = (ArrayList) request.getAttribute("Cm_col");
ArrayList Wpdtp = (ArrayList) request.getAttribute("Wpdtp_col");
ArrayList Statment = (ArrayList) request.getAttribute("Statment");
ArrayList Npdtp = (ArrayList) request.getAttribute("Npdtp_col");
ArrayList Wcdtp = (ArrayList) request.getAttribute("Wcdtp_col");
ArrayList Ncdtp = (ArrayList) request.getAttribute("Ncdtp_col");
ArrayList Wmrt= (ArrayList) request.getAttribute("Wmrt_col");
	%>
	
<table border=1 id="table1" class="table table-striped"
		style="color: #232f3e; width: 90%; margin-left: 69px; margin-top: 51px; text-align: center;">

		<thead>
			<tr style="background-color:#00008B; color:white"">
				<th scope="col">Lno</th>
				<th scope="col">Statment</th>
				<th scope="col">Cm</th>
				<th scope="col">Wpdtp</th>
				
				<th scope="col">Npdtp</th>
				<th scope="col">Wcdtp</th>
				<th scope="col">Ncdtp</th>
				<th scope="col">Wmrt</th>
			</tr>
		</thead>
		<tbody>

			<%
			for(int i=0; i<Lno.size();i++){
				out.print("<tr><td>"+Lno.get(i)+"</td>");
				out.print("<td>"+Statment.get(i)+"</td>");
				out.print("<td>"+ Cm.get(i) +"</td>");
				out.print("<td>"+Wpdtp.get(i)+"</td>");
				
				out.print("<td>"+Npdtp.get(i)+"</td>");
				out.print("<td>"+Wcdtp.get(i)+"</td>");
				out.print("<td>"+Ncdtp.get(i)+"</td>");
				out.print("<td>"+Wmrt.get(i)+"</td></tr>");
				
			}
			%>
		
		<tbody>
	</table>



</body>
</html>