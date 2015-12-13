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
  	   <a href="home" class="brand"> <i  class="icon-home"></i> Home page</a>
  	 	<ul class="nav">
  	 	    <li class="divider-vertical"></li>
  	 		<li><a href="provider"><spring:message code="label.provider" /></a></li>
  	 		<li><a href="project"><spring:message code="label.project" /></a></li>
  	 		<li><a href="galery.html">Галерея</a></li>
  	 		<li class="dropdown">
  	 		   <a href="contacts.html" class="dropdown-toggle" data-toggle="dropdown">Контакты<b class="caret"></b></a>
                <ul class="dropdown-menu">
                	<li><a href="contacts.html"> Киев</a></li>
                	<li><a href="contacts.html"> Харьков </a></li>
                	<li><a href="contacts.html"> Львов </a></li>
                	<li><a href="contacts.html"> Симферополь</a></li>
                </ul>
  	 		</li>

  	 		
  	 	</ul>
  	 	<form class="navbar-form pull-right">
  	 		<input type="text" class="span2  search-query" placeholder="search"/>
  	 	</form>
  	 </nav>

</div>
<a href="<c:url value="/logout" />">
	<spring:message code="label.logout" />
</a>
  
<h2><spring:message code="label.provider" /></h2>

<form:form method="post" action="add" commandName="provider">

	<table>
	
		<tr>
			<td><form:label path="name">
				<spring:message code="label.firstname" />
			</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="family_name">
				<spring:message code="label.lastname" />
			</form:label></td>
			<td><form:input path="family_name" /></td>
		</tr>
		<tr>
			<td><form:label path="company">
				<spring:message code="label.company" />
			</form:label></td>
			<td><form:input path="company" /></td>
		</tr>
		<tr>
			<td><form:label path="telephone">
				<spring:message code="label.telephone" />
			</form:label></td>
			<td><form:input path="telephone" /></td>
		</tr>
		<tr>
			<td><form:label path="address">
				<spring:message code="label.address" />
			</form:label></td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit"
				value="<spring:message code="label.addprovider"/>" /></td>
		</tr>
	</table>
</form:form>

<h3><spring:message code="label.contacts" /></h3>
<c:if test="${!empty providerList}">
	<table class="data">
		<tr>
		<th><spring:message code="label.firstname" /></th>
		<th><spring:message code="label.lastname" /></th>
			<th><spring:message code="label.company" /></th>
			<th><spring:message code="label.telephone" /></th>
			<th><spring:message code="label.address" /></th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach items="${providerList}" var="provider">
			<tr>
				<td>${provider.name}</td>
				<td>${provider.family_name}</td>
				<td>${provider.company}</td>
				<td>${provider.telephone}</td>
				<td>${provider.address}</td>
				<td><a href="delete/${provider.id}"><spring:message code="label.delete" /></a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>



<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>