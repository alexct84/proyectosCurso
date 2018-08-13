
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><h:outputText value="#{msjs.titulo}"/></title>
		<html:base/>
		<link href="mycss.css" rel="stylesheet" type="text/css" />
		<f:loadBundle basename="mensajes" var="msjs"/>
	</head>
	<body>
	<center>
	<f:subview id="cap">
		<jsp:include page="/pages/header.jsp" />
	</f:subview>

			<h:form>
				<h:dataTable value="#{beanCiudad.ciudades}"
		             var="dbRow"
		             border="1"
		             headerClass="HEADING"
		             rowClasses="ROW1,ROW2"
		             >

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.ID}"/></f:verbatim>
					    </f:facet>
					    <h:outputText value="#{dbRow.idCiudad}"/>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.Ciudad}"/></f:verbatim>
					    </f:facet>
					    <h:inputText value="#{dbRow.nombreCiudad}"/>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.editarLugares}"/></f:verbatim>
					    </f:facet>
					    <h:commandLink value="#{msjs.editarLugares}" action="#{beanLugar.lugaresByCiudad}">
					    	<f:param name="idCiudad" value="#{dbRow.idCiudad}"/>
					    </h:commandLink>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.editarCiudad}"/></f:verbatim>
					    </f:facet>
					    <!-- Se invoca al metodo paramEditar de beanCiudad pasandole un parametro de request
					    con el name y value especificado. Ojo: debe declararse en el faces-config.
					    Este parametro sera usado mas adelante por editarCiudad.jsp -->
					    <h:commandLink value="#{msjs.editarCiudad}" action="#{beanCiudad.paramEditar}">
					    	<f:param name="idCiudad" value="#{dbRow.idCiudad}"/>
					    </h:commandLink>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.borrarCiudad}"/></f:verbatim>
					    </f:facet>
					    <!-- Se invoca al metodo paramBorrar de beanCiudad pasandole un parametro de request
					    con el name y value especificado. Ojo: debe declararse en el faces-config.
					    Este parametro sera usado mas adelante por borrarCiudad.jsp -->
					    <h:commandLink value="#{msjs.borrarCiudad}" action="#{beanCiudad.paramBorrar}">
					    	<f:param name="idCiudad" value="#{dbRow.idCiudad}"/>
					    </h:commandLink>
					</h:column>
				</h:dataTable>

				<p>
				<h:commandButton action="#{beanCiudad.updateoTabla}" value="#{msjs.updatearCiudoteca}" type="submit" />
				</p>
				<p>
					<h:commandLink value="#{msjs.crearCiudad}" action="crearCiudad"/>
					<br>
					<h:commandLink value="#{msjs.volver}" action="volverInicio"/>
				</p>
			</h:form>

			<f:subview id="footer">
				<jsp:include page="/pages/footer.jsp" />
			</f:subview>
		</center>
	</body>
</f:view>
</html>
