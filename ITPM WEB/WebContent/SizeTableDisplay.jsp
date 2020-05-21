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
	    ArrayList Nkw = (ArrayList) request.getAttribute("Nkw_col");
	    ArrayList Nid = (ArrayList) request.getAttribute("Nid_col");
	    ArrayList Nop = (ArrayList) request.getAttribute("Nop_col");
	    ArrayList Nnv = (ArrayList) request.getAttribute("Nnv_col");
	    ArrayList Nsl = (ArrayList) request.getAttribute("Nsl_col");
	    ArrayList Cs = (ArrayList) request.getAttribute("Cs_col");
	    ArrayList weights = (ArrayList)request.getAttribute("weights");
	%>

	<table border=1 id="table1" class="table table-striped"
		style="color: #232f3e; width: 90%; margin-left: 69px; margin-top: 51px; text-align: center; border-color :#f8f8ff;">

		<thead>
			<tr style="background-color:#00008B; color:white">
				<th scope="col">Lno</th>
				<th scope="col">Program Statment</th>
				<th scope="col">Nkw</th>
				<th scope="col">Nid</th>
				<th scope="col">Nop</th>
				<th scope="col">Nnv</th>
				<th scope="col">Nsl</th>
				<th scope="col">Cs</th>
			</tr>
		</thead>
		<tbody>

			<%
			for(int i=0; i<Lno.size();i++){
				out.print("<tr><td>"+Lno.get(i)+"</td>");
				out.print("<td>"+ Statment.get(i) +"</td>");
				out.print("<td>"+ Nkw.get(i) +"</td>");
				out.print("<td>"+Nid.get(i)+"</td>");
				out.print("<td>"+Nop.get(i)+"</td>");
				out.print("<td>"+Nnv.get(i)+"</td>");
				out.print("<td>"+Nsl.get(i)+"</td>");
				out.print("<td>"+Cs.get(i)+"</td></tr>");
				
			}
			%>
		
		<tbody>
	</table>
	<form class="form mb-2" action="size.jsp" >
				<%
					
					session.setAttribute("weights", weights);
				%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" class="btn btn-secondary" value="Change Weights"> 
			</form>
</body>
</html>