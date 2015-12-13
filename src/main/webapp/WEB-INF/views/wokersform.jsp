<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<link rel="stylesheet"  href="resources/css/bootstrap.min.css">
    <link rel="stylesheet"  href="resources/css/mystyle.css">
    
    
	<title><spring:message code="label.project" /></title>
</head>
<body>

<form:form method="post"   commandName="woker">

	<table>
	
		<tr>
			<td><form:label path="name" >
			Имя 
			</form:label></td>
			<td><form:input path="name"  value="${woker.name}"/></td>
		</tr>
		<tr>
			<td><form:label path="telephone">
			Телефон
			</form:label></td>
			<td><form:input path="telephone"  value="${woker.telephone}"/></td>
		</tr>
		
		
		<tr>
			<td><form:label path="job">
			Должность
			</form:label></td>
			<td><form:input  path="job" value="${woker.job}"/></td>
		</tr>
		<tr>
			<td><form:label path="company">
		       Компания
			</form:label></td>
			<td><form:input path="company" value="${woker.company}"/></td>
		</tr>
		<tr>
			<td><form:label path="email">
				Почта
			</form:label></td>
			<td><form:input path="email" value="${woker.email}"/></td>
		</tr>
		<tr>
			<td><form:label path="role">
				Доступен
			</form:label></td>
			<td><form:input path="role" value="${woker.role}" /></td>
		</tr>
		<td><input type="button" class="button" value="Удалить"onclick="location.href='deletewoker/${woker.id}'"/></td>
		
		
	</table>
</form:form>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>