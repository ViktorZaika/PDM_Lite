<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<link rel="stylesheet"  href="resources/css/bootstrap.min.css">
    <link rel="stylesheet"  href="resources/css/mystyle.css">
	<title><spring:message code="label.title" /></title>
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

<c:if test="${not empty param.error}">
	<font color="red"> Неправельный логин или пароль! Попробуйте снова. </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />">
<table>
	<tr>
		<td align="right"><spring:message code="label.login" /></td>
		<td><input type="text" name="j_username" /></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.password" /></td>
		<td><input type="password" name="j_password" /></td>
	</tr>
	<tr>
		<td align="right"><spring:message code="label.remember" /></td>
		<td><input type="checkbox" name="_spring_security_remember_me" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><input type="submit" value="Login" />
		
	</tr>
</table>
</form>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>