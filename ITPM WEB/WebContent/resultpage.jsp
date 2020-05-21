<%@page import="com.itpmweb.services.Main"%>
<%@page import="com.itpmweb.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itpmweb.*"%>
<!DOCTYPE html>
<html>
<head>
<script>
            function home(){
                window.location.replace("index.jsp");
            }
        </script>
<title>Result Page</title>
<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="js/resultPage.js"></script>
</head>
<body style="background-color: #F0FFFF;">
	<div id="resultContainer">
		<div id="coupling" class="coupling">
			<center>
				<h2>Measuring the complexity of Coupling</h2>
				<button  style="margin-left:-90px" class="btn btn-lg btn-default btn-res" onclick="home();">Home</button>
				<br />
			</center>
				<%@ include file="components/couplingView.jsp"%>
		</div>
		<br />
		<br />
	</div>

</body>
</html>