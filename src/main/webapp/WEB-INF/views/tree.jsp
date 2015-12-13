<%@page import="net.khai.diplom.service.ProjectServiceImpl"%>
<%@page import="net.khai.diplom.domain.Project"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="net.khai.diplom.web.plomController" %>
<%@ page import="net.khai.diplom.service.ProjectService" %>
<%@ page import="net.khai.diplom.tree.Tree" %>
<%@ page import= "java.io.IOException"%>
<%@ page import ="org.springframework.beans.factory.annotation.Autowired" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <jsp:useBean id="tree" class="net.khai.diplom.tree.Tree" scope="application" />
    <jsp:setProperty name="tree" property="*"/> <%-- %>value='<%=request.getParameter("projectList")%>'--%>   
<html> 
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
     <link rel="stylesheet" href="resources/dist/themes/default/style.min.css" />
     <link rel="stylesheet"  href="resources/css/bootstrap.min.css">
    <link rel="stylesheet"  href="resources/css/mystyle.css">
     <script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
     
    <script>  
    function showContent(link) {  
  
        var cont = document.getElementById('contentBody');  
        var loading = document.getElementById('loading');  
  
        cont.innerHTML = loading.innerHTML;  
  
        var http = createRequestObject();  
        if( http )   
        {  
            http.open('get', link);  
            http.onreadystatechange = function ()   
            {  
                if(http.readyState == 4)   
                {  
                    cont.innerHTML = http.responseText;  
                }  
            }  
            http.send(null);      
        }  
        else   
        {  
            document.location = link;  
            
        }  
    }  
  
    // создание ajax объекта  
    function createRequestObject()   
    {  
        try { return new XMLHttpRequest() }  
        catch(e)   
        {  
            try { return new ActiveXObject('Msxml2.XMLHTTP') }  
            catch(e)   
            {  
                try { return new ActiveXObject('Microsoft.XMLHTTP') }  
                catch(e) { return null; }  
            }  
        }  
    }  
</script>  
	<title>tree</title>
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
  	 	<form class="navbar-form pull-right">
  	 		<input type="text" class="span2  search-query" placeholder="search"/>
  	 	</form>
  	 </nav>
</div>
<div id="jstree" style="width: 45%;  float:left;">
    <!-- in this example the tree is populated from inline HTML -->
                               <%=tree.getTreetags()%>                      

</div>
 

<div id="resp">

</div>


      
    <div id="contentBody" style="width: 45%; float:left;">  
    </div>  
  
    <div id="loading" style="display: none">  
    Идет загрузка...  
    </div>  




  <!-- 4 include the jQuery library -->
  <script src="resources/dist/libs/jquery.js"></script> 
  <!-- 5 include the minified jstree source -->
  <script src="resources/dist/jstree.min.js"></script>
  <script>
  $(function () {
    // 6 create an instance when the DOM is ready
    $('#jstree').jstree();
    // 7 bind to events triggered on the tree
  
      $('#jstree').on("changed.jstree", function (e, data) {
    	
    	
    	console.log(data.selected);
      
    });
    jQuery("#jstree ul").on("click","li.jstree-node a",function(){
        document.location.href = this; 
    });
   
    $( "ul.disabled" ).on( "dblclick", false );
    
    // 8 interact with the tree - either way is OK
    $('button').on('click', function () {
      $('#jstree').jstree(true).select_node('child_node_1');
      $('#jstree').jstree('select_node', 'child_node_1');
      $.jstree.reference('#jstree').select_node('child_node_1');
      
    });
    
  });
  </script>
  
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>