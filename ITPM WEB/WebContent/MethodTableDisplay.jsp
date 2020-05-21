<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

table {
  width: 90%;
}
#nav li:hover{
	background-color:#0BADF3FF;
}

th {
  height: 50px;
}
tr{
width:90%;
}
table {

  border-collapse: collapse;
}
</style>
</head>
<body>

	<%
		ArrayList Lno = (ArrayList) request.getAttribute("Lno_col");
	    ArrayList Statment = (ArrayList) request.getAttribute("Statment");
	    ArrayList Wmrt = (ArrayList) request.getAttribute("Wmrt_col");
	    ArrayList Npdtp = (ArrayList) request.getAttribute("Npdtp_col");
	    ArrayList Ncdtp = (ArrayList) request.getAttribute("Ncdtp_col");
	    ArrayList Cm = (ArrayList) request.getAttribute("Cm_col");
	    ArrayList weights = (ArrayList)request.getAttribute("weights");
	%>

	<table border=1 id="table1" class="table table-striped"
		style="color: #232f3e; width: 90%; margin-left: 69px; margin-top: 51px; text-align: center; border-color :#f8f8ff;">

		<thead>
			<tr style="background-color:#00008B; color:white">
				<th scope="col">Lno</th>
				<th scope="col">Program Statment</th>
				<th scope="col">Wmrt</th>
				<th scope="col">Npdtp</th>
				<th scope="col">Ncdtp</th>
				<th scope="col">Cm</th>
			</tr>
		</thead>
		<tbody>

			<%
			for(int a=0; a< Statment.size();a++){
				out.print("<tr><td>"+a+"</td>");
				out.print("<td>"+ Statment.get(a) +"</td>");
				out.print("<td>"+ Wmrt.get(a) +"</td>");
				out.print("<td>"+Npdtp.get(a)+"</td>");
				out.print("<td>"+Ncdtp.get(a)+"</td>");
				out.print("<td>"+Cm.get(a)+"</td></tr>");
				
			}
			%>
		
		<tbody>
	</table>
	
				<form class="form mb-2" action="Methods.jsp" >
				<%
					System.out.println("WEight list : "+weights.size());
					session.setAttribute("weights", weights);
				%>
				<input type="submit" class="btn btn-secondary" value="Change Weights"> 
			</form>
	
</body>
</html>