

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ITPM</title>
<link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
        <script>
            function toFileUpload(){
                window.location.replace("fileupload.jsp");
            }
        </script>
</head>
<body style="background-color:#F0F8FF;">
    <div id="wrapper"><br>
     <div class="icon-bar">
					<a class="active" href="index.jsp"><img src="images/homeic.png" width="30px" height="30px"></a> 
						<a href onClick=" history.go(-1);return true;"><img src="images/left.png" width="30px" height="30px"></a> 
						<img src="images/right.png" width="30px" height="30px">
                                                <img src="images/qmark.jpg" width="30px" height="30px">
                                     </div><br>
	<div id="header-wrapper" >
		<div id="header">
			<div id="logo" style="background-color:#F0F8FF;">
				<h1>MEASURING CODE</h1>
				<p>web-based code complexity measuring tool <a href="http://templated.co" rel="nofollow"></a></p>
			</div>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu-wrapper">
		<ul id="menu">
			<li class="current_page_item"><a href="#"><span>Home</span></a></li>
			<li><a href="size.jsp"><span>Size</span></a></li>
            <li><a href="variable.jsp"><span>Variable</span></a></li>
			<li><a href="Methods.jsp"><span>Methods</span></a></li>
			<li><a href="Upload.jsp"><span>Inheritance</span></a></li>
			<li><a href="cupling.jsp"><span>Coupling</span></a></li>
			<li><a href="controlStruture.jsp"><span>Control Structures</span></a></li>
		</ul>
		
	</div>
	<!-- end #menu -->
	<div id="page">
		<div id="content" Style="">
                    
                   <div class="panel panel-primary">
                        <div class="panel-heading">All Result Of Measurement</div>
                        <div class="panel-body">
                          <br>
                            <%Integer SumNkw = (Integer)request.getAttribute("SumNkw"); %>
                            <%Integer SumNid = (Integer)request.getAttribute("SumNid"); %>
                            <%Integer SumNop = (Integer)request.getAttribute("SumNop"); %>
                            <%Integer SumNnv = (Integer)request.getAttribute("SumNnv"); %>
                            <%Integer SumNsl = (Integer)request.getAttribute("SumNsl"); %>
                            <% if (SumNkw == null) { %>
							<div> <label style="center" for="male"><u>Size </u></label><br>
							<input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<div> <label style="center" for="male"><u>Method </u></label><br>
							 <input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<div>  <label style="center" for="male"><u>Variable </u></label><br>
							<input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<div>  <label style="center" for="male"><u>Control Structure </u></label><br>
							<input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<div>  <label style="center" for="male"><u>Inheritance </u></label><br>
							<input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<div>  <label style="center" for="male"><u>Coupling </u></label><br>
							<input type="text" class="res" name="result" value="" style="width: 320px;" readonly="readonly" /><br></div>
							<% } else { %>
							<div><input type="text" class="res" name="result" value="Nkw=<%= SumNkw%>  |  Nid=<%= SumNid%>  |  Nop=<%= SumNop%>  |  Nnv=<%= SumNnv%>  |  Nsl=<%= SumNsl%>" style="width: 320px;" readonly="readonly" /><br></div>
							<% } %>
                                <!-- <input type="text" class="res" name="result" value="" size="20px" readonly="readonly" /><br> -->
                                <div style="align:center;">
                                 <button  class="btn btn-lg btn-default btn-res" onclick="toFileUpload();">View Reslut</button><br></div>
                                   
                         
                        </div>
                                 </div>
			</div>
		
		<!-- end #content -->
		
		<!-- end #sidebar -->
		<div style="clear: both;">&nbsp;</div>
		<br>
		<br>
		<br>
		
	</div>
	
	<!-- end #page -->
</div>
    <hr>
<div>
  <div>	
        <table align="right">
		<tr>
			<th><span class="fa fa-star checked" ></span></th>
			<th><span class="fa fa-star checked"></span></th>
			<th><span class="fa fa-star checked"></span></th>
			<th><span class="fa fa-star"></span></th>
			<th><span class="fa fa-star"></span></th>
			</br>
													<a href="https://www.facebook.com" class="fa fa-facebook"></a>
														<a href="https://www.twitter.com" class="fa fa-twitter"></a>
															<a href="https://www.youtube.com/" class="fa fa-youtube"></a>
														<a href="https://www.instragram.com/" class="fa fa-instagram"></a>
													<a href="https://www.skype.com/" class="fa fa-skype"></a>
											
											
											
											
		</tr>
	</table>
    </div>
<center><h5>Copyright ©2020 ITPM Inc. All Rights Reserved. Accessibility, User Agreement, Privacy, Cookies and AdChoice</h5></center>
</div>
<!-- end #footer -->
</body>
</html>
