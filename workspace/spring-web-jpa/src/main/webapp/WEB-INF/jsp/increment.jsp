<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.cts.entity.Increment"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

       <form:form method="post" commandName="increment" modelAttribute="increment">    
        <table >    
         <tr>    
          <td>Amount : </td>   
          <td><form:input path="amount"  /></td>  
         </tr>    
         <tr>    
          <td colspan="2"><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>

</body>
</html>