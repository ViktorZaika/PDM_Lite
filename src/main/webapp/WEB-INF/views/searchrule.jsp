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
<form:form method="post"  action="searchrule1" commandName="rules">

	<table>
	
		<tr>
			<td><form:label path="name" >
			Имя документа
			</form:label></td>
			<td><form:input path="name"  /></td>
			<td colspan="1"><input type="submit"
				value="Найти" /></td>
		</tr>
		
		
	</table>
</form:form>
</body>
</html>