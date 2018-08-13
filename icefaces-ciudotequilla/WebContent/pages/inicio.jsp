<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>

<head>

	<title><h:outputText value="#{msjs.titulo}"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<html:base/>
	<link href="mycss.css" rel="stylesheet" type="text/css">
	<f:loadBundle basename="mensajes" var="msjs"/>
</head>
<body>
	<center>
	<f:subview id="cap" >
		<jsp:include page="/pages/header.jsp" />
	</f:subview>

	<h:form>
		<p>
		<!-- Propiedad del bean mediante la que se captura el value del elemento seleccionado -->
		<h:selectOneMenu value="#{beanCiudad.idCiudad}">
            <f:selectItems value="#{beanCiudad.listaCiudades}" />
      	</h:selectOneMenu>
		</p>

		<p>
		<!-- type asume tres posiblesvalores: submit-boton envio formulario, reset: resetea camposdel formulario y button -->
		<h:commandButton action="#{beanCiudad.lugaresByCiudad}" value="#{msjs.mostrarLugares}" type="submit" />
		</p>
		<p>
		<h:commandLink action="adminCiudades" value="#{msjs.administrar}" />
		</p>
	</h:form>

	<f:subview id="footer">
		<jsp:include page="/pages/footer.jsp" />
	</f:subview>
	</center>
</body>
</f:view>
</html>
