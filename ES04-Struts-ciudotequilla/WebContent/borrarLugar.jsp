<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>

<%@include file="taglibs_struts.jsp" %>

<bean:define id="lugar" name="lugar" type="trilcejf.tos.Lugar" scope="request"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
	<head>
		<title>borrarLugar.jsp</title>
		<link href="default.css" rel="stylesheet" type="text/css">
	</head>
          <body>
            <jsp:include page="header.jsp"/>
            <p class="titulo-principal">Borrar lugar</p>
              <html:form action="borrarLugar.do">
            	<table border="1">
	       			<tr class="titulo-tabla">
	                	<td colspan="2">Est&aacute; seguro de que desea borrar el lugar:</td>
	            	</tr>
	            	<tr>
	            		<td>Lugar:</td>
	          			<td><bean:write name="lugar" property="nombreLugar"/></td>
	          			<html:hidden property="idLugar" value="<%=lugar.getIdLugar().toString() %>"/>
	          			<html:hidden property="ciudadId" value="<%=lugar.getCiudadId().toString() %>"/>
	     			</tr>
     			</table><p>
     			<html:submit styleClass="boton-mini" value="S&iacute;" />
      		</html:form>       
    		<jsp:include page="footer.jsp"/>
          </body>
</html:html>