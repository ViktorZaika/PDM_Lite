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


<form:form method="post" action="addproject/${project.id}" commandName="project">

	<table>
	
		<tr>
			<td><form:label path="name">
				Имя
			</form:label></td>
			<td><form:input path="name" value="${project.name}" /></td>
		</tr>
	
		<tr>
			<td><form:label path="created">
				Начало проэкта
			</form:label></td>
			<td><form:input path="created" value="${project.created}"/></td>
		</tr>
		<tr>
			<td><form:label path="finished">
				Конец проэкта
			</form:label></td>
			<td><form:input path="finished" value="${project.finished}"/></td>
		</tr>
		<tr>
			<td><form:label path="manager">
			Руководитель
			</form:label></td>
			<td><form:input path="manager" value="${project.manager}"/></td>
		</tr>
		<tr>
		<tr>
			<td><form:label path="description">
				Описание проэкта
			</form:label></td>
			<td><form:input path="description" value="${project.description}"/></td>
		</tr>
		<tr><td>
	
		<form:select size="8" multiple="multiple" path="links" >
		<c:if test="${!empty ProjectList}">
	
		<c:forEach items="${ProjectList}" var="project">
			
				<option value="${project.id}">${project.name}</option>
		</c:forEach>
	
</c:if>
    
    </form:select></td>
		</tr>
		<tr>
			<td ><input type="submit" value="Добавить новый" />
		    <input type="submit" value="Изменить" />
		    <input type="button" class="button" value="Удалить"onclick="location.href='deleteproject/${project.id}'"/>
			    <input type="button" class="button" value="Добавить файл"onclick="showContent('fileform/${project.id}')"/>
	        <input type="button" class="button" value="Добавить изделие"onclick="showContent('add_unit_in_proj/${project.id}')"/></td>
		    	</tr>
	</table>
</form:form>

<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>