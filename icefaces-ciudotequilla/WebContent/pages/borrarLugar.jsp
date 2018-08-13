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
				<h:outputText value="#{msjs.nombreLugar}" />:
				<h:outputText value="#{beanLugar.lugar.nombreLugar}"/>
				<h:inputHidden value="#{beanLugar.lugar.idLugar}"/>

				<br>
				<br>
				<h:commandButton value="#{msjs.borrarLugar}" action="#{beanLugar.delete}" />

				<p>
					<h:commandLink value="#{msjs.volver}" action="#{beanLugar.volver}"/>
				</p>
			</h:form>

			<f:subview id="footer">
				<jsp:include page="/pages/footer.jsp" />
			</f:subview>
		</center>
	</body>
</f:view>
</html>