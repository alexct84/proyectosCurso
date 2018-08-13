<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false" %>

<%@include file="taglibs_struts.jsp" %>

<bean:define id="ciudad" name="ciudad" type="trilcejf.tos.Ciudad" scope="request"></bean:define>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
  <title>editarCiudad.jsp</title>
  <link href="default.css" rel="stylesheet" type="text/css">  
</head>

<body>
  <jsp:include page="header.jsp" />
  
  <!-- Cuerpo de página -->
  <p class="titulo-principal">Modificar ciudad</p>
    <html:form action="editarCiudad.do" focus="nombreCiudad" onsubmit="return validateCiudadForm(this);">
          <table>
              <tr>
                <td>Nombre ciudad:</td>
                <td><html:text property="nombreCiudad" value="<%=ciudad.getNombreCiudad() %>"></html:text></td>
                <td><p class="error"><html:errors property="mensajeCiudadRepetida"/></p></td>
                <td>
                <html:hidden  property="idCiudad" value="<%=ciudad.getIdCiudad().toString() %>"/>
                </td>
              </tr>
          </table>
    <p>
    <html:submit styleClass="boton-mini" value="Modificar" />
    <html:javascript formName="ciudadForm"/>
    </html:form>
  <p>
  <jsp:include page="footer.jsp" />
</body>
</html:html>