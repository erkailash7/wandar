<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>

<head>  
	<title>  Love 2 code company home page</title>

</head>
 <body>
 
  <h2>   Love 2 code company home page  !!!</h2>
  
  <br>
 <p> Welcome to  the company home Page Kailash and Sons  </p>
  
  <br>
  
  <hr> <p>
  		User : <security:authentication property="principal.username"/>
  		
  		<br>  <br>
  		
  		Roles : <security:authentication property="principal.authorities"/>
  		</p>
  		
  	<security:authorize access="hasRole('MANAGER')">
 	
  		<p>
  			<a href="${pageContext.request.contextPath}/leaders"> LeaderShip Meeting</a>
  			(only for Manager)
  		</p>
  	
  	</security:authorize>
  	<security:authorize access="hasRole('ADMIN')">
  		<p>
  			<a href="${pageContext.request.contextPath}/system"> Admin System Meeting</a>
  			(only for Admin)
  		</p>
  	</security:authorize>
  		
   <hr>
  
 <form:form action="${pageContext.request.contextPath}/logout"  method="POST">
  
  	<input type = "submit" value = "Logout" />
  
  </form:form>
  
 </body>

</html>