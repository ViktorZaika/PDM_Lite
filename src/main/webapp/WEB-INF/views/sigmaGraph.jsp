<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.khai.diplom.sigma.sigma" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="sigma" class="net.khai.diplom.sigma.sigma" scope="application" />
    <jsp:setProperty name="sigma" property="*"/>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	<link rel="stylesheet"  href="resources/css/bootstrap.min.css">
    <link rel="stylesheet"  href="resources/css/mystyle.css">
	<title><spring:message code="label.provider" /></title>
	<style type="text/css">
  #container {
    max-width: 800px;
    height: 550px;
    margin: auto;
  }
</style>
	
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
<script src="resources/src/sigma.core.js"></script>
<script src="resources/src/conrad.js"></script>
<script src="resources/src/utils/sigma.utils.js"></script>
<script src="resources/src/utils/sigma.polyfills.js"></script>
<script src="resources/src/sigma.settings.js"></script>
<script src="resources/src/classes/sigma.classes.dispatcher.js"></script>
<script src="resources/src/classes/sigma.classes.configurable.js"></script>
<script src="resources/src/classes/sigma.classes.graph.js"></script>
<script src="resources/src/classes/sigma.classes.camera.js"></script>
<script src="resources/src/classes/sigma.classes.quad.js"></script>
<script src="resources/src/classes/sigma.classes.edgequad.js"></script>
<script src="resources/src/captors/sigma.captors.mouse.js"></script>
<script src="resources/src/captors/sigma.captors.touch.js"></script>
<script src="resources/src/renderers/sigma.renderers.canvas.js"></script>
<script src="resources/src/renderers/sigma.renderers.webgl.js"></script>
<script src="resources/src/renderers/sigma.renderers.svg.js"></script>
<script src="resources/src/renderers/sigma.renderers.def.js"></script>
<script src="resources/src/renderers/webgl/sigma.webgl.nodes.def.js"></script>
<script src="resources/src/renderers/webgl/sigma.webgl.nodes.fast.js"></script>
<script src="resources/src/renderers/webgl/sigma.webgl.edges.def.js"></script>
<script src="resources/src/renderers/webgl/sigma.webgl.edges.fast.js"></script>
<script src="resources/src/renderers/webgl/sigma.webgl.edges.arrow.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.labels.def.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.hovers.def.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.nodes.def.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edges.def.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edges.curve.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edges.arrow.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edges.curvedArrow.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edgehovers.def.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edgehovers.curve.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edgehovers.arrow.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.edgehovers.curvedArrow.js"></script>
<script src="resources/src/renderers/canvas/sigma.canvas.extremities.def.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.utils.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.nodes.def.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.edges.def.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.edges.curve.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.labels.def.js"></script>
<script src="resources/src/renderers/svg/sigma.svg.hovers.def.js"></script>
<script src="resources/src/middlewares/sigma.middlewares.rescale.js"></script>
<script src="resources/src/middlewares/sigma.middlewares.copy.js"></script>
<script src="resources/src/misc/sigma.misc.animation.js"></script>
<script src="resources/src/misc/sigma.misc.bindEvents.js"></script>
<script src="resources/src/misc/sigma.misc.bindDOMEvents.js"></script>
<script src="resources/src/misc/sigma.misc.drawHovers.js"></script>
<!-- END SIGMA IMPORTS -->


<div id="container"></div>

<script>
data = {
		  "nodes": [
		    <%=sigma.getData()%> 
		   
		  ],
		  "edges": [<%=sigma.getDataEdges()%> 
		    
		    
		  ]
		}
s = new sigma({ 
    graph: data,
    container: 'container',
    settings: {
        defaultNodeColor: '#ec5148'
    }
});
</script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>