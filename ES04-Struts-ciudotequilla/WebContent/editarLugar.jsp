<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>

<%@include file="taglibs_struts.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
  <title>editarLugar.jsp</title>
  <link href="default.css" rel="stylesheet" type="text/css">  
</head>

<body>
  <jsp:include page="header.jsp" />
  
  <!-- Cuerpo de página -->
  <p class="titulo-principal">Modificar Lugar</p>
  <bean:define id="lugar" name="lugar" type="trilcejf.tos.Lugar" scope="request"></bean:define>
    <html:form action="editarLugar.do" focus="nombreLugar" onsubmit="return validateLugarForm(this);">
          <table>
              <tr>
                <td>Nombre Lugar:</td>
                
                <td><html:text property="nombreLugar" value="<%=lugar.getNombreLugar() %>"></html:text></td>
                <td><p class="error"><html:errors property="mensajeLugarRepetido"/></p></td>
                <td>
                	<html:hidden  property="idLugar" value="<%=lugar.getIdLugar().toString() %>"/>
                	<html:hidden  property="ciudadId" value="<%=lugar.getCiudadId().toString() %>"/>
                </td>
              </tr>
          </table>
   <p>
    <html:submit styleClass="boton-mini" value="Modificar" />
    <html:javascript formName="lugarForm"/>
    </html:form>
  <p>
  <jsp:include page="footer.jsp" />
</body>
</html:html>