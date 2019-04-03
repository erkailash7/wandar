<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>

<html>

<head>    <title>  Add Note</title>
<style>

.error {color:red}

</style>
</head>
<body>



<div id = "container">
	<h4> Add/Update the Note  </h4>
	<div id = "content">
		
		 <p style="color: red">  ${errorMessage} </p>
	<form:form action="saveNote" modelAttribute = "note" method="POST">
			<form:hidden path="noteId"/>
			<table>
				<tr>
					<th>  Title :  </th>
					<th> <form:input path = "title" />  </th>
				</tr>
				
				<tr>
					<th>  Description :  </th>
					<th> <form:input path = "description" />  </th>
				</tr>
			
		     	<tr>
					<th> <input type = "submit" value = "submit">  </th>
				</tr>
			
			
			</table>
			
			

</form:form>
		
	</div>



</div>

<br>
<p>
</p>


</body>


</html>
