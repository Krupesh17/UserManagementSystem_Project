<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add New User</title>
<style type="text/css">
	@import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');

	* {
		box-sizing: border-box;
		margin: 0;
		padding: 0;
	}
	 
	.container {
		height: 100vh;
		width: 100vw;
		display: flex;
		justify-content: center;
		align-items: center;
		background-image: url("https://drive.google.com/uc?id=18yCG04LtogbWo8d-XZwjX4wiMtFZ18vC");
		background-color: #e0e0e0;
		background-position: center; 
  		background-repeat: no-repeat; 
  		background-size: cover;
	}
	
	.card {
		width: 30vw;
		border: 1px solid #e2e2e2;
		border-radius: 3px;
		background: #f7f7f7;
		padding: 10px;
		font-family: 'Poppins', sans-serif;
	}
	
	.card h3 {
		color: #2271f0;
		display: inline;
		margin-left: 6px; 
	}
	
	input[type="text"],
	input[type="number"],
	input[type="email"],
	input[type="password"] {
		width: 100%;
		padding: 10px;
		margin-top: 10px;
		outline: none;
		border: 1px solid #e2e2e2;
		border-radius: 3px;
		font-family: 'Poppins', sans-serif;
	}
	
	#loginBtn,
	#resetBtn {
		width: 100%;
		background-color: #2271f0;
		color: white;
		padding: 10px;
		margin-top: 10px;
		border: none; 
		border-radius: 3px;
		font-size: 15px;
		font-family: 'Poppins', sans-serif;
	}
	
	#resetBtn {
		background-color: #f0222c;
	}
	
	#resetBtn:hover {
		cursor: pointer;
		background-color: #db1f28;
		color: white;
	}
	
	#loginBtn:hover {
		cursor: pointer;
		background-color: #1e66d9;
		color: white;
	}
	
	a {
		text-decoration: none;
		color: #808080;
		font-size: 25px;
		font-weight: 600;
	}
	
	a:hover {
		color: #2271f0;
	}
	
	#backBtn {
		border: 1px solid #e2e2e2;
		border-radius: 25px;
		padding: 1px 16.5px;
	}
	
	#backBtn:hover {
		background-color: #e0e0e0;
		color: #2271f0;
	}
	
	.cardHead {
		display: flex;
		align-items: center;
	}
	
	@media only screen and (max-width: 945px) {
		.card {
			width: 60vw;
		}
	}
	
	@media only screen and (max-width: 600px) {
		.card {
			width: 90vw;
		}
	}
</style>
</head>
<body>
	<div class="container">
		<div class="card">
		
			<form action="<%=request.getContextPath()%>/addNewUser" method="post">
				<div class="cardHead">
					<a href="<%=request.getContextPath()%>/users" id="backBtn" title="Back">&lsaquo;</a>
					<h3>Add New User</h3>
				</div>
				
				<input type="text" name="firstName" placeholder="First Name">
							
				<input type="text" name="lastName" placeholder="Last Name">
				
				<input type="number" name="contact" placeholder="Contact">
				
				<input type="email" name="email" placeholder="Email">
				
				<input type="password" name="password" placeholder="Password">
				
				<input type="submit" value="Register" id="loginBtn">
				
				<input type="reset" value="Reset" id="resetBtn">
			</form>
			
		</div>
	</div>

</body>
</html>