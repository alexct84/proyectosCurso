<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><h:outputText value="#{msjs.titulo}"/></title>
		<html:base/>
		<link href="mycss.css" rel="stylesheet" type="text/css">
		<f:loadBundle basename="mensajes" var="msjs"/>
	</head>
	<body>
	<center>
	<f:subview id="cap">
		<jsp:include page="/pages/header.jsp" />
	</f:subview>

			<h:form>
				<h:outputText value="#{msjs.nombreCiudad}" />:
				<h:inputText value="#{beanCiudad.ciudad.nombreCiudad}" />

				<br>
				<br>
				<h:commandButton value="#{msjs.crearCiudad}" action="#{beanCiudad.create}" />

				<p>
				<h:commandLink value="#{msjs.volver}" action="volverAdministrar"/>
				</p>
			</h:form>

			<f:subview id="footer">
				<jsp:include page="/pages/footer.jsp" />
			</f:subview>
		</center>
	</body>
</f:view>
</html>