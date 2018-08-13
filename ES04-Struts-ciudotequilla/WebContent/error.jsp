<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" session="false"%>
    
<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>error.jsp</title>
	<html:base/>
	<link href="default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1> Nos estamos tomando un descanso :)</h1><p>
	<img src="tomcat.gif"><p>
	<p class="error">
	<!-- Muestra el value asociado al atrib de request de clave mensaje 
	ignore=true hace que si la clave del atrib y el name de la tag son distintos o si no le llega
	el atrib de request, se muestre una cadena vacia. Si se pone a false se lanza una exception 
		<bean:write name="mensaje" ignore="true" scope="request"/>-->
		<html:errors property="mensajeBD"/>
	</p>
	<%--	String mensaje=(String)request.getAttribute("mensaje");
		if(mensaje!=null){%>
			<%=mensaje%>
		<%}
	--%>
	<jsp:include page="footer.jsp"/>	
</body> 
</html>