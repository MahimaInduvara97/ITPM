<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="java.util.ArrayList"%>
<html lang="en">
    <head class="header">
        <title> ITPM </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/functioncss.css" type="text/css">
         <link rel="stylesheet" href="css/footer.css" type="text/css">
           <link rel="stylesheet" href="css/header.css" type="text/css">
           <link rel="stylesheet" href="css/fileUpload.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <style>
* {
  box-sizing: border-box;
}
</style>
    
		<div class="icon-bar">
					<a class="active" href="index.jsp"><img src="images/homeic.png" width="30px" height="30px"></a> 
						<a href onClick=" history.go(-1);return true;"><img src="images/left.png" width="30px" height="30px"></a> 
						<img src="images/right.png" width="30px" height="30px">
                                                <img src="images/qmark.jpg" width="30px" height="30px">
                </div><br>
                <div>
                        <div align="left"><img src="images/main.png" width="75" height="75" ></div>
                </div>
                <br>
                <ul>
                    <li><a href=index.jsp>Home</a></li>
                    <li><a href="variable.jsp">Variables</a></li>
                    <li><a href="Methods.jsp">Methods</a></li>
                    <li><a href="inheritance.jsp">Inheritance</a></li>
                    <li><a href="cupling.jsp">Coupling</a></li>
                     <li><a href="controlStruture.jsp">Control Structure</a></li>
                </ul>
                <hr>
              
                 
 
<script src="js/uploadfile.js"></script>      

                 
    </head>
<body>
        <div class="row">
  <div class="column" style="background-color:#F0FFFF;">
    <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Browse The Code Here</h2>
    
    

    <div class="main-container">
		<center>
			<div class="inner-container">
				<div class="container"  style="background-color: #6495ED;">
					<label>Size Complexsity<br>
					 <label
						style="font-size: 12px;">JAVA & C++</label><br />
				</div>
				<br />
				<div class="upload">
					<form action="UploadServletSize" method="post" name="form1" id="form1">
						<label style="background-color: #008B8B;">Browse <input name="file" type="file" id="file" multiple
							style="display: none;" onChange="uploadOnChange(this)">
						</label>
						<div class="browse-button" style="margin-bottom: 50px;">
							<input type="text" id="filename" />
							<input type="hidden" id="use" name="path"/>
							<input type="submit" name="submit"
								value="Proceed" />
						</div>
					</form>
					<br>
		<br>
		
		<br>
		<br>
		<br>
				</div>
			</div>
		</center>
		
	</div>
	

	
            
  </div>
<div class="column bg-light">
    <h2>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Weights related to the size factor</h2>
    <div class= "coloum2">
    
    
  <%
	  ArrayList weights = (ArrayList)session.getAttribute("weights");
  
  		
	
    int Wkw =1;
	int Wid=1;
	int Wop = 1;
	int Wnv = 1;
	int Wsl = 1; 
  		
	if(weights != null){
  		Wkw = Integer.parseInt(weights.get(0).toString());
  		Wid = Integer.parseInt(weights.get(1).toString());
  		Wop = Integer.parseInt(weights.get(2).toString());
  		Wnv= Integer.parseInt(weights.get(3).toString());
  		Wsl = Integer.parseInt(weights.get(4).toString());
  	}
	

%> 
     
     <form class="form-inline bg-white" action="UploadServletMethod" method="get">
 
	 				<table class="table table-bordered">
					    <thead>
					      <tr>
					        <th>Program Component</th>
					        <th>Weight</th>
					      </tr>
					    </thead>
					    <tbody>
					      <tr>
					        <td>Keyword</td>
					        <td><input type="number" value="<%= Wkw %>"   class="form-control"  id="weightKey" name="weightKey"></td>
					      </tr>
					      <tr>
					        <td>Identifier</td>
					        <td><input type="number" value="<%= Wid %>"   class="form-control"  id="weightIdent" name="weightIdent"></td>
					      </tr>
					      <tr>
					        <td>Operator</td>
					        <td><input type="number" value="<%= Wop%>" class="form-control" id="weightOp" name="weightOp"></td>
					      </tr>
					      
					      <tr>
					      	<td>Numerical Value</td>
					      	<td><input type="number"   value="<%=Wnv %>" class="form-control"  id="weightNume" name="weightNume"></td>
					      </tr>
					      
					      <tr>
					      	<td>String Literal</td>
					      	<td><input type="number"  value="<%=Wsl %>"  class="form-control" id="weightSl" name="weightSl"></td>
					      </tr>
					    </tbody>
					</table>
 
					<button type="submit" class="btn btn-primary float-right"> Save</button>		
   
				</form>
     
    </div>
 
  </div>
 
  </div>
</div>
</body>
<footer>
    <br>
    <hr><div>
        <div>
            <table align="center">
				<tr>
				<div>
						<th><a button href="#" class="">Help  </button> </a></th>
						<th><a button href="#" class="">Feedback  </button> </a></th>
						<th><a button href="#" class="">Contact Us  </button> </a></th>
				</div>
				</tr>
		</table>
        </div>
    </div>
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
</footer>
</html>