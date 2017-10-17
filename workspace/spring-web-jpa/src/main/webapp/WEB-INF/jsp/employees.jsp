<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cts.entity.Employee"%>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Employees Page</h2>
	<h2><a href="increment?empid=1">Apply for Incremnt for Employee 1</a></h2>
	<h2><a href="increment?empid=2">Apply for Incremnt for Employee 1</a></h2>
	<h2><a href="#">View Increments for Employee 1</a></h2>

	
	<table>
	<c:forEach var="emp" items="${emps}"> 
    	<tr>
    		<td><a href="increment?empid=${emp.id}"><c:out value="${emp.name}"/></a></td>
    		<td><c:out value="${emp.salary}"/></td>
    	</tr>
	</c:forEach>
	</table>
	
	
		<h3>${emps}</h3>
</body>
</html>