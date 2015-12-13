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
	<title><spring:message code="label.provider" /></title>
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
  	 		<li><a href="org_str">Организационная Структура</a></li> 	 		
  	 	    <li class="divider-vertical"></li>
  	 		<li><a href="rules">Нормативная документация</a></li> 
  	 	</ul>
  	 </nav>
</div>
<div id="leftside" style="width: 20%;  height:80%; float:left;">
<img src="resources/K105-7-3-1.jpg" width="189" height="255" alt="K-105">
</div>
<div id="context"style="width: 60%;   height:80%;float:left;">
<h3 align="center">Добро пожаловать</h3>
<h5 align="center">на официальную страницу системы информационной поддержки жизненого цикла АТ</h5>
Данная система обладает следующими преимуществами по с равнению с аналогами:
<ul>
 <li>Данная разработка является бесплатной что позволяет свободно применять систему на малых предприятиях или предприятиях которые не имеют возможности покупок дорогостоящих систем.
 <li>Малая потребляемость в ресурсах позволяет работать с системой на маломощных машинах что позволяет сэкономить на оборудовании. 
 <li>Простота в развертывании системы позволяет в кратчайшие сроки организовать работу на предприятии.
 <li>Открытый код делает систему практически универсальной для всех сфер машиностроения.
 <li>Работает в интернете лишает привязанности людей к рабочему месту и позволяет работать с системой даже в процессе движения.
 <li>Отсутствие клиентского приложения позволяет существенно сэкономить место на жестком диске.
 <li>Кроссплатформенность дает возможность запускать и дорабатывать  приложение в различных система.
</ul>
</div>
<div id="rightside"style="width: 20%;   height:80%;float:left;">
<a href="login.jsp" >Вход</a>
<img src="resources/LogoKHAI-G.jpg" width="189" height="255"  alt="KHAI">
</div>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>