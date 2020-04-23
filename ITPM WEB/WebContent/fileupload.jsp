<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
<link rel="stylesheet" href="css/fileUpload.css">
<script src="js/uploadfilecup.js"></script>
</head>
<body>
	<div class="main-container">
		<center>
			<div class="inner-container" style="background-color: #6495ED;">
				<div class="container" style="background-color: #008B8B;">
					<label
						style="font-size: 12px;">JAVA & C++</label><br />
				</div>
				<br />
				<div class="upload">
					<form action="UploadServlet" method="post" enctype="multipart/form-data" name="form1" id="form1">
						<label style="color:blue;">Browse <input name="file" type="file" id="file" multiple
							style="display: none;" onChange="uploadOnChange(this)">
						</label>
						<div class="browse-button" style="margin-bottom: 50px;">
							<input type="text" id="filename" /><input type="submit" name="submit"
								value="Proceed" />
						</div>
					</form>
				</div>
			</div>
		</center>
	</div>
</body>
</html>
