<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%@include file="taglibs_struts.jsp" %>

<bean:define id="ciudad" name="ciudad" type="trilcejf.tos.Ciudad" scope="request"></bean:define>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
	<head><title>borrarCiudad.jsp</title>
	<link href="default.css" rel="stylesheet" type="text/css">
	</head>
          <body>
            <jsp:include page="header.jsp"/>
            <p class="titulo-principal">Borrar lugar</p>
              <html:form action="borrarCiudad.do">
            	<table border="1">
	       			<tr class="titulo-tabla">
	                	<td colspan="2">Est&aacute; seguro de que desea borrar la ciudad:</td>
	            	</tr>
	            	<tr>
	            		<td>Lugar:</td>
	          			<td><bean:write name="ciudad" property="nombreCiudad"/></td>
	          			<html:hidden property="idCiudad" value="<%=ciudad.getIdCiudad().toString() %>"/>
	     			</tr>
     			</table><p>
     			<html:submit styleClass="boton-mini" value="S&iacute;" />
      		</html:form>       
    		<jsp:include page="footer.jsp"/>
          </body>
</html:html>