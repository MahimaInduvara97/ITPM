<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.itpmweb.services.Main"%>
<%@page import="com.itpmweb.model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coupling Weight Changer</title>
<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
<div id="header-wrapper" >
		<div id="header">
			 <a href="http://templated.co" rel="nofollow"></a>
			</div>
		</div>
	</div>
	<%
		ArrayList<CustomFile> fileList = (ArrayList) session.getAttribute("fileList");
	%>

	<div class="container" style="background-color: #F0FFFF;">

		<div style="text-align: center">
			<h3>Weights related to the coupling factor</h3>
		</div>
		<form action="../UpdateCouplingWeight?update=true" method="post">
			<table class="table table-striped" style="margin-top: 30px;">
				<thead>
					<tr>
						<th scope="col">Coupling Type</th>
						<th scope="col">Weight</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">A recursive call</th>
						<td><input type="number" name="c1" id="c1" value="<% out.print(Coupling.getWeights()[0]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method calling another regular
							method in the same file</th>
						<td><input type="number" name="c2" id="c2" value="<% out.print(Coupling.getWeights()[1]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method calling another regular
							method in a different file</th>
						<td><input type="number" name="c3" id="c3" value="<% out.print(Coupling.getWeights()[2]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method calling a recursive method
							in the same file</th>
						<td><input type="number" name="c4" id="c4" value="<% out.print(Coupling.getWeights()[3]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method calling a recursive method
							in a different file</th>
						<td><input type="number" name="c5" id="c5" value="<% out.print(Coupling.getWeights()[4]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method calling another recursive
							method in the same file</th>
						<td><input type="number" name="c6" id="c6" value="<% out.print(Coupling.getWeights()[5]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method calling another recursive
							method in a different file</th>
						<td><input type="number" name="c7" id="c7" value="<% out.print(Coupling.getWeights()[6]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method calling a regular method
							in the same file</th>
						<td><input type="number" name="c8" id="c8" value="<% out.print(Coupling.getWeights()[7]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method calling a regular method
							in a different file</th>
						<td><input type="number" name="c9" id="c9" value="<% out.print(Coupling.getWeights()[8]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method referencing a global
							variable in the same file</th>
						<td><input type="number" name="c10" id="c10" value="<% out.print(Coupling.getWeights()[9]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A regular method referencing a global
							variable in a different file</th>
						<td><input type="number" name="c11" id="c11" value="<% out.print(Coupling.getWeights()[10]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method referencing a global
							variable in the same file</th>
						<td><input type="number" name="c12" id="c12" value="<% out.print(Coupling.getWeights()[11]); %>"/></td>
					</tr>
					<tr>
						<th scope="row">A recursive method referencing a global
							variable in a different file</th>
						<td><input type="number" name="c13" id="c13" value="<% out.print(Coupling.getWeights()[12]); %>"/></td>
					</tr>
				</tbody>
			</table>
			<Button style="margin-left:395px" class="btn btn-lg btn-default btn-res" style="float: right">Save</Button>
		</form>
		<form action="../UpdateCouplingWeight?default=true" method="post" style="margin-bottom: 20px;">
		<button class="btn btn-lg btn-default btn-res" style="margin-left:390px">Default</button>
		</form>
	</div>
</body>
</html>