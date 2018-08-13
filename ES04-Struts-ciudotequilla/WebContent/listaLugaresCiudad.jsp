<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<bean:define id="ciudad" name="ciudad" type="trilcejf.tos.Ciudad" scope="request" />

<html:html>
  <head>
    <title>listaLugaresCiudad.jsp</title>
    <link href="default.css" rel="stylesheet" type="text/css">
  </head>
<body>
  <jsp:include page="header.jsp"/>
  <p class="titulo-principal">Lugares de <bean:write name="ciudad" property="nombreCiudad" scope="request" /></p>
	  <table border="1">
		  <tr class="titulo-tabla">
		     <td><b>id</b></td><td><b>Lugar</b></td><td><b>Borrar</b></td><td><b>Editar</b></td></tr>
		    	<logic:iterate id="lugar" name="listaLugaresCiudad" type="trilcejf.tos.Lugar" scope="request">
		    		<tr>
		    			<td><bean:write name="lugar" property="idLugar"/></td>
		    			<td><bean:write name="lugar" property="nombreLugar"/></td>
		    			<td><html:link action="borrarLugar.do?mostrarNotificacionBorrar=true" name="lugar" property="parametrosUrl">Borrar</html:link></td>
		    			<td><html:link action="editarLugar.do?mostrarNotificacionEditar=true" name="lugar" property="parametrosUrl">Editar</html:link></td>
		    			
		    		</tr>
		    	</logic:iterate>
	  </table>  
	  <p>	 
  	<html:link action="crearLugar.do?crear=si" name="ciudad" property="parametrosUrl">Crear</html:link>
  	<p>
  	<html:link action="/listarCiudades.do">Regresar</html:link>
  	<p>
  	<jsp:include page="footer.jsp"/>
</body>

</html:html>

