<%@page import="com.itpmweb.services.*"%>
<%@page import="com.itpmweb.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inheritance</title>

<style>
table, td, th {
  border: 1px solid black;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th {
  height: 50px;
}
</style>
</head>
<body>
	<center>
	<h1>Inheritance Result</h1>
	<table>
	<tr>
	<thead>
		<th>Count</th>
		<th>Class Name</th>
		<th>No of direct inheritances</th>
		<th>No of indirect inheritances</th>
		<th>Total inheritances</th>
		<th>Ci</th>
	</tr>
	</thead>
	<tbody>
		<%
				Inheritance_service test4 = new Inheritance_service();
		ArrayList<Inheritance> arrayList4 = test4.inheritance(session.getAttribute("test_code").toString());
		
		for (Inheritance inheritance : arrayList4) {
			int total = inheritance.getDirect()+inheritance.getIndirect();
			
			int Ci=total;
			if(Ci==0){
				Ci=Integer.parseInt(session.getAttribute("Inheritance").toString());
			}else if(Ci==1){
                Ci=Integer.parseInt(session.getAttribute("Inheritance1").toString());
            }else if(Ci==2){
                Ci=Integer.parseInt(session.getAttribute("Inheritance2").toString());
            }else if(Ci==3){
                Ci=Integer.parseInt(session.getAttribute("Inheritance3").toString());
            }else if(Ci>4){
                Ci=Integer.parseInt(session.getAttribute("Inheritance4").toString());
            }
		%>
			<tr>
				<td><%=inheritance.getLineNumber() %></td>
				<td><%=inheritance.getClassName() %></td>
				<td><%=inheritance.getDirect() %></td>
				<td><%=inheritance.getIndirect() %></td>
				<td><%=total %></td>
				<td><%=Ci %></td>
			</tr>
			<% 
		}	
	%>
	</tbody>
	</table>
	</center>
</body>
</html>