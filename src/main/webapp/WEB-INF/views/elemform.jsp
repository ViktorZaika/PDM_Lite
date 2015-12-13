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

<form:form method="post" action="addorg_elem/${Element.id}"  commandName="Element">

	<table>
	
		<tr>
			<td><form:label path="name" >
			Название
			</form:label></td>
			<td><form:input path="name"  value="${Element.name}"/></td>
		</tr>
		<tr>
			<td><form:label path="id_manager">
			Код
			</form:label></td>
			<td><form:input path="id_manager"  value="${Element.id_manager}"/></td>
		</tr>
		<tr>
			<td><form:label path="telephone">
			Телефон
			</form:label></td>
			<td><form:input path="telephone" value="${Element.telephone}"/></td>
		</tr>
		
		<tr>
			<td >
			<input type="submit" class="button" value="Добавить елемент структуры" /></td>
		    <td><input type="button" class="button" value="Добавить работника"onclick="showContent('getewokerform/${Element.id}')"/>
		    </td>
		     <td >
			<td><input type="submit" value="Изменить" onclick="location.href='${file.change}'"/></td>
			<td><input type="button" class="button" value="Удалить"onclick="location.href='deleteOrg/${Element.id}'"/></td>
		     
		</tr>
	</table>
</form:form>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>