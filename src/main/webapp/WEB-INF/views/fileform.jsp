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

<form:form method="post" action="add_file_in_project/${pr_id}" commandName="file">

	<table>
	
		<tr>
			<td><form:label path="name">
			Имя
			</form:label></td>
			<td><form:input path="name" value="${file.name}"/></td>
		</tr>
		<tr>
			<td><form:label path="extention">
				Разширение
			</form:label></td>
			<td><form:input path="extention"  value="${file.extention}"/></td>
		</tr>
		<tr>
			<td><form:label path="description">
				Описание
			</form:label></td>
			<td><form:input path="description" value="${file.description}"/></td>
		</tr>
		<tr>
			<td><form:label path="role">
				Доступен
			</form:label></td>
			<td><form:input path="role" value="${file.role}" /></td>
		</tr>
		<tr>
			<td><form:label path="add_date">
				Дата последней загрузки
			</form:label></td>
			<td><form:input path="add_date" value="${file.add_date}"/></td>
		</tr>
		<tr>
		<tr>
			<td><form:label path="version">
				Версия
			</form:label></td>
			<td><form:input path="version" value="${file.version}"/></td>
		</tr>
		<tr>
			<td><form:label path="size">
				Размер
			</form:label></td>
			<td><form:input path="size" value="${file.size}"/></td>
		</tr>
		<tr>
			<td><form:label path="manager">
				Ответственный
			</form:label></td>
			<td><form:input path="manager" value="${file.manager}"/></td>
		</tr>
		
		<tr>
			<td colspan="1"><input type="submit"
				value="Скачать" /></td>
		     <td ><input type="submit"
				value="Добавить"/></td>
		     
		</tr>
	</table>
</form:form>

<form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />
<input type="submit" value="Загрузить" />
</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>