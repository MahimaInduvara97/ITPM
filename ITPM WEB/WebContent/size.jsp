<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
        <style>
* {
  box-sizing: border-box;
}
</style>
    
		<div class="icon-bar">
					<a class="active" href="home.html"><img src="images/homeic.png" width="30px" height="30px"></a> 
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
                    <li><a href="#news">Size</a></li>
                    <li><a href="#contact">Variables</a></li>
                    <li><a href="#contact">Methods</a></li>
                    <li><a href="#contact">Inheritance</a></li>
                    <li><a href="#contact">Coupling</a></li>
                     <li><a href="#contact">Control Structure</a></li>
                </ul>
                <hr>
              
                 
 
<script src="js/uploadfile.js"></script>      

                 
    </head>
<body>
        <div class="row">
  <div class="column" style="background-color:#F0FFFF;">
    <h2>Enter The Code Here</h2>
    
    

    <div class="main-container">
		<center>
			<div class="inner-container">
				<div class="container">
					<label>Size Complexsity<br>
					</label><br /> <br /> <label>Available Languages</label><br /> <br /> <label
						style="font-size: 12px;">&#x1F5F9 JAVA</label><br /> <label
						style="font-size: 12px;">&#x1F5F9 C++</label><br />
				</div>
				<br />
				<div class="upload">
					<form action="UploadServletSize" method="post" name="form1" id="form1">
						<label>Browse <input name="file" type="file" id="file" multiple
							style="display: none;" onChange="uploadOnChange(this)">
						</label>
						<div class="browse-button" style="margin-bottom: 50px;">
							<input type="text" id="filename" />
							<input type="hidden" id="use" name="path"/>
							<input type="submit" name="submit"
								value="Proceed" />
						</div>
					</form>
				</div>
			</div>
		</center>
	</div>
	

	
            
  </div>
  <div class="column" style="background-color:#F0FFFF;">
    <h2>Calculation</h2>
    <div class= "coloum2" style="background-color:gray;">
    <h3 style="color:white;">Answer is here</h3>
    <form action="" method="post" name="form2" id="form2">
    <%Integer name = (Integer)request.getAttribute("TotalSum"); %>
    <% if (name == null) { %>
    <div> <input type="text" id="fresult" name="fname" class ="box1"><br><br></div>
	<% } else { %>
	<div><input type="text" id="fresult" name="fname" class ="box1" value="<%= name%>"><br><br></div>
	<% } %>
    </form> 
           <!--  <input type="text" id="fresult" name="fname" class ="box1"><br><br>-->
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