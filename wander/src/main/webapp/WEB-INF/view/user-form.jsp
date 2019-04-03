<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>

<html>

<head>    <title>  Add User</title>
<style>

.error {color:red}

</style>
</head>
<body>

<div id = "container">
	<h4> Add New User  </h4>
	<div id = "content">
		
		
	<form:form action="saveUser" modelAttribute = "user" method="POST">
			<form:hidden path="userId"/>
			
			<table>
			<tr>
				<th> Enter User Name : </th>
				<th><form:input path = "userName" /> </th>
				
			</tr>
			
			<tr>
				<th> Enter Password : </th>
				<th> <form:input type = "password" path = "password"  />  </th>
			</tr>
			
			<tr>
			<th>  
			<input type = "submit" value = "Register" />
			</th>
			</tr>
			</table>

</form:form>
		
	</div>



</div>



</body>


</html>