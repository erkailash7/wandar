<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE>

<html>

<head>    <title>  Wander Login page</title>


<style type="text/css">
	.filed {
	color : red;
	}


</style>

</head>
<body>


	 <p style="color: red">  ${errorMessage} </p>
	<form:form action="loginUser" modelAttribute = "user" method="POST">
	
	
		<table>
			<tr>
				<th>  User Name : </th>
				<th><form:input path = "userName" /> </th>
				
			</tr>
			
			<tr>
				<th>  Password : </th>
				<th> <form:input type = "password" path = "password"  />  </th>
			</tr>
			
			<tr>
			<th>  
			<input type = "submit" value = "Login" />
			</th>
				
			</tr>
			
			<tr>
			<th>  
			Not yet Register , Plese 1st Register
			</th>
			<th>  
			<input type = "button" value ="Add User" onclick="window.location.href= 'addUser'; return false;" /> 
			</th>
				
			</tr>
			
		</table>


</form:form>
		




</body>


</html>
