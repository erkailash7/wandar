<%-- <%@ taglib prefix="form" url="http://wwww.springframework.org/tags/form" %> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE>

<html>

<head>    <title>  List Of Notes</title>

</head>
<body>

<div id = "wrapper">
	<div id = "header">
		<h2>List of Notes of Current User </h2>
	</div>
</div>

<div id = "container">
	<div id = "content">
	<input type = "button" value ="Add Notes" onclick="window.location.href= 'addNote'; return false;" /> 
	
	<br>
		<c:if test="${fn:length(notes) == 0}">
			<p style="color: red"> There is no Notes for that User . Please add new Notes  </p>
		</c:if>
	<c:if test="${fn:length(notes) > 0}">
	
		<table border="1">
			<tr>
				<th> Title  </th>
				<th> Description </th>
				<th> Created Date </th>
				<th> Updated Date </th>
				<th> Action </th>
			 </tr>
			 <c:forEach  var = "tempNote" items = "${notes}">
			 	 <c:url var = "updateLink" value = "/showFormForUpdate">
						<c:param name="noteId" value = "${tempNote.noteId}"> </c:param>			 	
			 	</c:url>
			 	
			 	<c:url var = "deleteLink" value = "/note/delete">
						<c:param name="noteId" value = "${tempNote.noteId}"> </c:param>			 	
			 	</c:url> 
			 	
			 	
			 
				 <tr>
				 		<td> ${tempNote.title} </td>
				 		<td> ${tempNote.description} </td>
				 		<td> ${tempNote.createdDate} </td>
				 		<td> ${tempNote.updatedDate} </td>
				 		
				 		 <td> <a href="${updateLink}"> Update </a> 
				 		|
				 		<a href="${deleteLink}" onclick="if (!(confirm('Are you sure want to delete the Note?'))) return false"> Delete </a>
				 	   </td> 
				 </tr>
			 </c:forEach>
		
		</table>
		</c:if>
	
	</div>
<br></br>

<input type = "button" value ="Logout" onclick="window.location.href= 'showMyLoginPage'; return false;" /> 



</div>


</body>


</html>