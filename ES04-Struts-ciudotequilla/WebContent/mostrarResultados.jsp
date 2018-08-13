<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
		 session="false" %>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
  <head>
    <title>mostrarResultados.jsp</title>
    <link href="default.css" rel="stylesheet" type="text/css">  
  </head>
<body>
	<jsp:include page="header.jsp"/>
	
	<p class="titulo-principal"><bean:message key="mostrarResultados.bienvenida"/></p>
	
	<bean:define id="ciudad" name="ciudad" type="trilcejf.tos.Ciudad" scope="request"/>
	<bean:message key="mostrarResultados.msg" arg0="<%=ciudad.getNombreCiudad()%>"/>
	
	<logic:empty name="listaLugaresCiudad" scope="request">
		<bean:message key="mostrarResultados.sinLugares"/>
	</logic:empty>
	<logic:notEmpty name="listaLugaresCiudad" scope="request">
		<logic:iterate id="lugar" name="listaLugaresCiudad" scope="request">
			<bean:write name="lugar" property="nombreLugar" scope="page" />
		</logic:iterate>
	</logic:notEmpty>
	
	<jsp:include page="footer.jsp"/>
</body>
</html:html>
