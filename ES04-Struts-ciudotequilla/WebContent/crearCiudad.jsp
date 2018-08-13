<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
	<head>
		<title>crearCiudad.jsp</title>
		<link href="default.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<jsp:include page="header.jsp"/> 
	<p class="titulo-principal">Nueva ciudad</p>
	
	<html:form action="crearCiudad.do" focus="nombreCiudad" onsubmit="return validateCiudadForm(this);">
	  <table>
		<tr>
			<td>Nombre ciudad:</td>
		    <td><html:text property="nombreCiudad" size="25" /></td>
		    <td>
		    	<p class="error">
		    		<!-- Muestra el value asociado al atrib de request de clave mensaje definido 
					ignore=true hace que si la clave del atrib y el name de la tag son distintos o si no le llega
					el atrib de request, se muestre una cadena vacia. Si se pone a false se lanza una exception
					Equiv a <logic:present name="mensaje">
								<bean:write name="mensaje"/>
							</logic:present>
					
					<bean:write name="mensaje" ignore="true"/>-->
					<html:errors property="mensajeCiudadRepetida"/>
		    	</p>
			</td>
	   	</tr>
	  </table>
	  <p>
	<html:submit styleClass="boton-mini">Crear</html:submit>
	<html:javascript formName="ciudadForm"/>
	</html:form>
	<p>
	<jsp:include page="footer.jsp"/> 
</body>
</html:html>