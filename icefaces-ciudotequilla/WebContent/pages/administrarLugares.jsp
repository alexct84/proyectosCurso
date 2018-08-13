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
	<f:subview id="cap">
		<jsp:include page="/pages/header.jsp" />
	</f:subview>
			<p>
			<h:outputText value="#{msjs.Ciudad}"/>
		    <b><h:outputText value="#{beanLugar.ciudad.nombreCiudad}"/></b>
			</p>
			<h:form>
				<h:dataTable value="#{beanLugar.lugares}"
		             var="lug"
		             border="1"
		             headerClass="HEADING"
		             rowClasses="ROW1,ROW2"
		             >

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.ID}"/></f:verbatim>
					    </f:facet>
					    <h:outputText value="#{lug.idLugar}"/>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.Lugar}"/></f:verbatim>
					    </f:facet>
					    <h:outputText value="#{lug.nombreLugar}"/>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.editarLugar}"/></f:verbatim>
					    </f:facet>
					    <h:commandLink value="#{msjs.editarLugar}" action="#{beanLugar.paramEditar}">
					    	<f:param name="idLugar" value="#{lug.idLugar}"/>
					    </h:commandLink>
					</h:column>

					<h:column>
						<f:facet name="header">
					    	<f:verbatim><h:outputText value="#{msjs.borrarLugar}"/></f:verbatim>
					    </f:facet>
					    <h:commandLink value="#{msjs.borrarLugar}" action="#{beanLugar.paramBorrar}">
					    	<f:param name="idLugar" value="#{lug.idLugar}"/>
					    </h:commandLink>
					</h:column>
				</h:dataTable>

				<p>
					<h:commandLink value="#{msjs.crearLugar}" action="#{beanLugar.paramCrear}">
						<f:param name="idCiudad" value="#{beanLugar.ciudad.idCiudad}"/>
					</h:commandLink>
					<br>
					<h:commandLink value="#{msjs.volver}" action="volver"/>
				</p>
			</h:form>

			<f:subview id="footer">
				<jsp:include page="/pages/footer.jsp" />
			</f:subview>
		</center>
	</body>
</f:view>
</html>
