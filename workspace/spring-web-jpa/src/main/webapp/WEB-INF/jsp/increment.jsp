	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8" import="com.cts.entity.Increment"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Apply Increment</title>

 <style>
            .has-noerror {
        border: 2px solid green;
    }
    .has-error {
        border: 2px solid red;
    }
    .error {
       color:red;
    }
            </style>
</head>
<body ng-app>

       <form:form method="post" commandName="increment" modelAttribute="increment" name="incrementForm">    
        <table >    
         <tr>    
          <td>Amount : </td>   
          <td>
          	<form:input type="number" name="amount" path="amount" ng-model="amount" required="true" ng-class="{ 'has-error' : incrementForm.amount.$invalid && !incrementForm.amount.$pristine }"/>
          	<form:errors path="amount" cssClass="error" element="div" />
          	<spring:message code="increment.errMessage"/>
          	<strong class="error" ng-show="incrementForm.amount.$invalid && !incrementForm.amount.$pristine" class="help-block">Amount field is required and should be >0</strong>  	
          </td>  
           <td><form:input  path="employee.id" hidden="true" /></td>  
         </tr>      
         <tr>    
          <td colspan="2">
          	<input ng-disabled="incrementForm.$invalid" type="submit" value="Apply Increment" />
          	          </td>    
         </tr>    
        </table>    
       </form:form>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>

</body>
</html>