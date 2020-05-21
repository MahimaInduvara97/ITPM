<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
           <head class="header">
        <title> ITPM </title>
       <link href="http://fonts.googleapis.com/css?family=Abel" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/footer.css" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script type="text/javascript" src="jquery.dropotron-1.0.js"></script>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
                    <li><a href="size.jsp">Size</a></li>
                    <li><a href="variable.jsp">Variables</a></li>
                    <li><a href="Methods.jsp">Methods</a></li>
                    <li><a href="cupling.jsp">Coupling</a></li>
                     <li><a href="controlStruture.jsp">Control Structure</a></li>
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
					<label>Inheritance Complexity<br>
					<label
						style="font-size: 12px;">JAVA & C++</label><br />
				</div>
      <style>

.hoverable{
  display:inline-block;
  backface-visibility: hidden;
  vertical-align: middle;
  position:relative;
  box-shadow: 0 0 1px rgba(0,0,0,0);
  tranform: translateZ(0);
  transition-duration: .3s;
  transition-property:transform;
  
}

.hoverable:before{
  position:absolute;
  pointer-events: none;
  z-index:-1;
  content: '';
  top: 100%;
  left: 5%;
  height:10px;
  width:90%;
  opacity:0;
  background: blue;
  background: radial-gradient(ellipse at center, rgba(255, 255, 255, 0.35) 0%, rgba(255, 255, 255, 0) 80%);
  /* W3C */
  transition-duration: 0.3s;
  transition-property: transform, opacity;
  
}

.hoverable:hover, .hoverable:active, .hoverable:focus{
  transform: translateY(-5px);
}
.hoverable:hover:before, .hoverable:active:before, .hoverable:focus:before{
  opacity: 1;
  transform: translateY(-5px);
}



@keyframes bounce-animation {
  16.65% {
    -webkit-transform: translateY(8px);
    transform: translateY(8px);
  }

  33.3% {
    -webkit-transform: translateY(-6px);
    transform: translateY(-6px);
  }

  49.95% {
    -webkit-transform: translateY(4px);
    transform: translateY(4px);
  }

  66.6% {
    -webkit-transform: translateY(-2px);
    transform: translateY(-2px);
  }

  83.25% {
    -webkit-transform: translateY(1px);
    transform: translateY(1px);
  }

  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
}

.bounce {
  animation-name: bounce-animation;
  animation-duration: 2s;
}

.hideDiv{
	display: none;
}

.displayDiv{
	display: block;
}

/*everything below here is just setting up the page, so dont worry about it */


@media (min-width: 768px) {

body {
  background-color: blue;
  font-weight:600;
  text-align:center !important;
  color: black;
  
}


.page-title {
  opacity: .75 !important;
}

table1, td, th {
  border: 1px solid black;
}

table1 {
  border-collapse: collapse;
  width: 100%;
}

th {
  text-align: left;
}
.button {
  background-color: #555555;
  border: none;
  color: white;
  padding: 12px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

</style>
<script>
$(function(){
  var str = '#len'; //increment by 1 up to 1-nelemnts
  $(document).ready(function(){
    var i, stop;
    i = 1;
    stop = 4; //num elements
    setInterval(function(){
      if (i > stop){
        return;
      }
      $('#len'+(i++)).toggleClass('bounce');
    }, 500)
  });
});
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       
    </head>
  
    <body style="background-color:white;">

<div class="container-fluid">

<div id="what-the-hell-is-this">
    <div class="page-title">
      <h2></h2>
     
    </div>
  </div>
</div>

  <!--nav>
   
 
  </nav-->
  
  <form method="POST" action="testServlet" >
   
        <br>
        
          <hr>
          <div align=center  class="form-group mt-3" >
          
            <textarea rows="5" cols="80" name="code" required></textarea>
          </div>
          <hr>
          
          	<select id="selectOption" name="selectFactor" onchange="setDiv()" required>
          		<option value="">~Select~</option>
				<option value="inheritance">Inheritance</option>
				
			</select>
			
          <hr>
          
         			
		  			<div class="hideDiv" style="margin: auto;width:600px" id="inheritanceFactor">
		  			<br>
		  				<h5 align="center">Weight To The Inheritance</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Inherited Pattern</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>A class with no Inheritance(direct or indirect)</td>
			  						<td>
							  			<select class="form-control" name="Inheritance">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from one user-defined class</td>
			  						<td>
							  			<select class="form-control" name="Inheritance1">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from two user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance2">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from three user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance3">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from more than three user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance4">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			
          
          
          <button type="submit" class="button" value="save" >Save</button>
       
        </form>
  
  

       
    </body>
</html>
<script>

	function setDiv(){
		var div = document.getElementById('selectOption').value;
		
		 if(div=="inheritance"){
			hideAll();
			document.getElementById('inheritanceFactor').classList.add("displayDiv");
		}
		else{
			hideAll();
		}
	}
	
	function hideAll(){
		
		
		document.getElementById('inheritanceFactor').classList.remove("displayDiv");
		
		document.getElementById('inheritanceFactor').classList.add("hideDiv");
		
		
	}
   </script>
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

-----------------------------------------------------------------------------------------
