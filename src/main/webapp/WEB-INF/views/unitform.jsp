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
    
    
	<title></title>
</head>
<body>



<form:form method="post"  action="addunit/${unit.id}"  commandName="unit">

	<table>
	
		<tr>
			<td><form:label path="name">
				Имя
			</form:label></td>
			<td><form:input path="name" value="${unit.name}"/></td>
		</tr>
		<tr>
			<td><form:label path="material">
				Материал
			</form:label></td>
			<td><form:input path="material" value="${unit.material}" /></td>
		</tr>
		
		<tr>
			<td><form:label path="version">
			Версия
			</form:label></td>
			<td><form:input path="version" value="${unit.version}"/></td>
		</tr>
		<tr>
			<td><form:label path="weight">
			Вес
			</form:label></td>
			<td><form:input path="weight" value="${unit.weight}"/></td>
		</tr>
		<tr>
			<td><form:label path="scale">
			Масштаб
			</form:label></td>
			<td><form:input path="scale" value="${unit.scale}"/></td>
		</tr>
		<tr>
			<td><form:label path="list_number">
			Лист
			</form:label></td>
			<td><form:input path="list_number" value="${unit.list_number}"/></td>
		</tr>
		<tr>
			<td><form:label path="end_date">
			Дата окончания
			</form:label></td>
			<td><form:input path="end_date" value="${unit.end_date}"/></td>
		</tr>
		<tr>
			<td><form:label path="id_user_creator">
			Разработчик
			</form:label></td>
			<td><form:input path="id_user_creator" value="${unit.id_user_creator}"/></td>
		</tr>
		<tr>
			<td><form:label path="id_user_norm">
			Норм.контроллер
			</form:label></td>
			<td><form:input path="id_user_norm" value="${unit.id_user_creator}"/></td>
		</tr>
		
		<tr>
		
			<td><form:label path="date_control">
			Дата контроля
			</form:label></td>
			<td><form:input path="date_control"  value="${unit.date_control}"/></td>
		</tr>
        <tr>
		
			<td><form:label path="mesure_units">
		  Еденицы измерения
			</form:label></td>
			<td><form:input path="mesure_units"  value="${unit.mesure_units}"/></td>
		</tr>
		 <tr>
		
			<td><form:label path="description">
		  Описание
			</form:label></td>
			<td><form:input path="description"  value="${unit.description}"/></td>
		</tr>
		
		<tr>
			<td><input type="submit"
				value="Добавить новое изделие" /></td>
		
		<td><input type="submit" 
				value="Изменить" /></td>
		
		<td><input type="button" class="button" value="Удалить"onclick="location.href='deleteunit/${unit.id}'"/></td>
		</tr>
	</table>
</form:form>


<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>