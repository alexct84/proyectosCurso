<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>
	<head>
		<title><bean:message key="listaCiudades.title" /></title>
		<link href="default.css" rel="stylesheet" type="text/css">
	</head>
<body>
	<jsp:include page="header.jsp"/>
	<p class="titulo-principal"><bean:message key="listaCiudades.bienvenida" /></p>
	<table border="1">
	<tr class="titulo-tabla">
	<tr>
			<td><b>id</b></td><td><b>Ciudad</b></td><td><b>Borrar</b></td><td><b>Editar</b></td><td><b>Editar Lugar</b></td>
	</tr>
	  <logic:empty name="listaCiudades" scope="request">
			<bean:message key="index.sinCiudad"/>
		</logic:empty>
		<logic:notEmpty name="listaCiudades" scope="request">
			<logic:iterate id="ciudad" name="listaCiudades" type="trilcejf.tos.Ciudad" scope="request">
				<tr>
					<td><bean:write name="ciudad" property="idCiudad" /></td>
					<td><bean:write name="ciudad" property="nombreCiudad" /></td>
					<td><html:link action="borrarCiudad.do?mostrarNotificacionBorrar=true" name="ciudad" property="parametrosUrl">Borrar</html:link></td>
					<td><html:link action="editarCiudad.do?mostrarNotificacionEditar=true" name="ciudad" property="parametrosUrl">Editar</html:link></td>
					<td><html:link action="obtenerLugaresCiudad.do" name="ciudad" property="parametrosUrl">Editar lugares</html:link></td>
					
				</tr>
			</logic:iterate>
		</logic:notEmpty>
	
	</table><p>
	<html:link action="crearCiudad.do?crear=si">Crear ciudad</html:link><p>

	<jsp:include page="footer.jsp"/>
</body>

</html:html>
