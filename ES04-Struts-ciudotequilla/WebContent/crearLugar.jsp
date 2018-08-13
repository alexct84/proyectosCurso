<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head>
    <title>crearLugar.jsp</title>
    <link href="default.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <jsp:include page="header.jsp"/> 
  <p class="titulo-principal">Nuevo Lugar</p>
  <html:form action="crearLugar.do" focus="nombreLugar" onsubmit="return validateLugarForm(this);">
    <table>
	    <tr>
	      <td>Nombre lugar</td>
	          <td><html:text property="nombreLugar" size="25"></html:text></td>
	          <td><p class="error"><html:errors property="mensajeLugarRepetido"/></p></td>
	          <bean:define id="ciudad" name="ciudad" type="trilcejf.tos.Ciudad" scope="request"></bean:define>
	          <td><html:hidden property="idCiudad" value="<%= ciudad.getIdCiudad().toString()%>"></html:hidden></td>
	          <td><html:hidden property="nombreCiudad" value="<%= ciudad.getNombreCiudad() %>"></html:hidden></td>        
	      </tr>
    </table>
    <p>
    <html:submit styleClass="boton-mini">Crear</html:submit>  
    <html:javascript formName="lugarForm"/>
  </html:form>
  <p>
  <jsp:include page="footer.jsp"/> 
</body>
</html:html>