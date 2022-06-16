<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
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
	}
	
	#email,
	#password {
		width: 100%;
		padding: 10px;
		margin-top: 10px;
		outline: none;
		border: 1px solid #e2e2e2;
		border-radius: 3px;
		font-family: 'Poppins', sans-serif;
	}
	
	#loginBtn {
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
	
	#loginBtn:hover {
		cursor: pointer;
		background-color: #1e66d9;
		color: white;
	}
	
	.link {
		text-align: center;
		margin-top: 10px;
	}
	
	.link a {
		text-decoration: none;
		color: #808080;
		font-size: 14px;
	}
	
	a:hover {
		color: #2271f0;
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
			<form action="<%=request.getContextPath()%>/login-out" method="post">
				<h3>Login</h3>
				<input type="text" id="email" name="email" placeholder="Enter your email">
				<input type="password" id="password" name="password" placeholder="Enter your password">
				<input type="submit" value="Login" id="loginBtn">
				<div class="link">
					<a href="register.jsp" class="nav-link">Create an account</a>
				</div>
			</form>
		</div>
	</div>

</body>
</html>