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
 <div class="navbar navbar-static-top">
  	 <nav class="navbar-inner">
  	   <a href="home" class="brand"> <i  class="icon-home"></i>   Home Page</a>
  	 	<ul class="nav">
  	 	    <li class="divider-vertical"></li>
  	 		<li><a href="tree">Проекты</a></li>
  	 		<li class="divider-vertical"></li>
  	 		<li><a href="Units">Изделия</a></li>
  	 		<li class="divider-vertical"></li>
  	 		<li><a href="#">Организационная Структура</a></li> 	 		
  	 	    <li class="divider-vertical"></li>
  	 		<li><a href="#">Нормативная документация</a></li> 
  	 	</ul>
  	 </nav>
</div>
<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h2><spring:message code="label.project" /></h2>

<form:form method="post" action="addproject" commandName="project">

	<table>
	
		<tr>
			<td><form:label path="name">
				<spring:message code="label.name" />
			</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="over_proj">
				<spring:message code="label.over_proj" />
			</form:label></td>
			<td><form:input path="over_proj" /></td>
		</tr>
		<tr>
			<td><form:label path="created">
				<spring:message code="label.created" />
			</form:label></td>
			<td><form:input path="created" /></td>
		</tr>
		<tr>
			<td><form:label path="finished">
				<spring:message code="label.finished" />
			</form:label></td>
			<td><form:input path="finished" /></td>
		</tr>
		<tr>
			<td><form:label path="manager">
				<spring:message code="label.manager" />
			</form:label></td>
			<td><form:input path="manager" /></td>
		</tr>
		<tr>
		<tr>
			<td><form:label path="description">
				<spring:message code="label.description" />
			</form:label></td>
			<td><form:input path="description" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addproject"/>" /></td>
		</tr>
	</table>
</form:form>

<h3><spring:message code="label.addproject" /></h3>
<c:if test="${!empty projectList}">
	<table class="data">
		<tr>
		<th><spring:message code="label.name" /></th>
		<th><spring:message code="label.over_proj" /></th>
			<th><spring:message code="label.created" /></th>
			<th><spring:message code="label.finished" /></th>
			<th><spring:message code="label.manager" /></th>
			<th><spring:message code="label.description" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${projectList}" var="project">
			<tr>
				<td>${project.name}</td>
				<td>${project.over_proj}</td>
				<td>${project.created}</td>
				<td>${project.finished}</td>
				<td>${project.manager}</td>
				<td>${project.description}</td>
				<td><a href="deleteproject/${project.id}"><spring:message code="label.delete" /></a></td>
			</tr>
			
		</c:forEach>
		
	</table>
	${project.name}
</c:if>
<form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Upload File" />
</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>