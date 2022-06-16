<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List Of Users</title>
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
		width: auto;
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
	
	#addBtn,
	#logoutBtn {
		display: inline-block;
		background-color: #2271f0;
		color: white;
		padding: 4px 10px;
		border: none; 
		border-radius: 3px;
		font-size: 15px;
		font-family: 'Poppins', sans-serif;
	}
	
	#logoutBtn {
		background-color: #eb1515;
		color: white;
	}
	
	#deleteBtn,
	#editBtn {
		display: inline-block;
		color: white;
		padding: 4px 10px;
		border: none; 
		border-radius: 3px;
		font-size: 15px;
		font-weight: 600;
		font-family: 'Poppins', sans-serif;
	}
	
	#deleteBtn {
		width: 100%;
		color: #eb1515;
	}
	
	#editBtn {
		width: 100%;
		color: #008b8b;
	}
	
	#addBtn:hover {
		cursor: pointer;
		background-color: #1e66d9;
		color: white;
	}
	
	#logoutBtn:hover {
		cursor: pointer;
		background-color: #cf1313;
		color: white;
	}
	
	#deleteBtn:hover {
		cursor: pointer;
		text-decoration: underline;
	}
	
	#editBtn:hover {
		cursor: pointer;
		text-decoration: underline;
	}
	
	a {
		text-decoration: none;
		color: white;
	}
	
	table, 
	th, 
	td {
		border: 1px solid #c2c2c2;
		border-collapse: collapse;
	}
	
	th, 
	td {
		padding: 6px 10px;
		text-align: center;
	}
	
	th {
		border: 0;
		border-bottom: 1px solid #c2c2c2;
		color: white;
		font-weight: 100;
	}
	
	thead tr {
		background: linear-gradient(to right, #6600cc 0%, #cc00cc 100%);
	}
	
	table {
		width: 100%;
	}
	
	td#userId {
		font-weight: bold;
		color: #2150de;
	} 
	
	.tableResponsive {
		margin-top: 10px;
		overflow-x: auto; 
	}
	
	#dotGreen {
		color: #0eeb2b;
		font-size: 20px;
	}
	
	#dotOrange {
		color: #ff7300;
		font-size: 20px;
	}
	
	.navBar {
		width: 100vw;
		display: flex;
		font-family: 'Poppins', sans-serif;
		background-color: white;
		padding: 10px;
		position: fixed;
		justify-content: space-between;
		align-items: center;
		color: white;
	}
	
	.navBar h3 {
		font-weight: 500;
		color: #8000ff;
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
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");		//This perfectly work with HTTP 1.1
		
		response.setHeader("Pragma", "no-cache");		//This will work with older version of HTTP like HTTP 1.0
		
		response.setHeader("Expires", "0");			//This will work if your using a proxy server
		
		if(session.getAttribute("email") == null) {
			
			response.sendRedirect("login.jsp");
		}
	%>
	
	<div class="navBar">
		<h3>User Management System</h3>
		<a href="<%=request.getContextPath()%>/login-out" id="logoutBtn">Logout</a>
	</div>

	<div class="container">
		
		<div class="card">
			<div class="buttonsDiv">
				<c:if test="${role == 'admin'}">
					<a href="addUser.jsp" id="addBtn">Add User</a>
				</c:if>
			</div>
			<div class="tableResponsive">
				<table>
					<thead>
						<tr>
							<th>User ID</th>
	                        <th>First Name</th>
	                        <th>Last Name</th>
	                        <th>Contact</th>
	                        <th>Email</th>
	                        <th>Password</th>
	                        <th>Role</th>
	                        <c:if test="${role == 'admin'}">
		                       	<th>configure</th>
		                        <th>Action</th>
	                        </c:if>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="user" items="${listOfUsers}">
							<tr>
								<td id="userId"><c:out value="${user.userId}"/></td>
								<td><c:out value="${user.firstName}"/></td>
								<td><c:out value="${user.lastName}"/></td>
								<td><c:out value="${user.contact}"/></td>
								<td><c:out value="${user.email}"/></td>
								<td><c:out value="${user.password}"/></td>
								<c:if test="${user.role == 'admin'}">
									<td>
										<span id="dotGreen">&#9679;</span> <c:out value="${user.role}"/>
									</td>
								</c:if>
								<c:if test="${user.role == 'user'}">
									<td>
										<span id="dotOrange">&#9679;</span> <c:out value="${user.role}"/>
									</td>
								</c:if>
								<c:if test="${role == 'admin'}">
									<td>
										<a href="editUpdate?id=<c:out value="${user.userId}"/>" id="editBtn">Edit</a>
									</td>
									<td>
										<a href="delete?id=<c:out value="${user.userId}"/>"  id="deleteBtn">Delete</a>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>