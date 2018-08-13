<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>

<%@include file="taglibs_struts.jsp" %>

<html:html>
<head>
	<title>index.jsp</title>
	<html:base/>
	<link href="default.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<p class="titulo-principal"><bean:message key="index.bienvenida"/></p>
	<html:form action="obtenerLugaresCiudad.do">
		<logic:empty name="listaCiudades" scope="request">
			<bean:message key="index.sinCiudad"/>
		</logic:empty>
		<logic:notEmpty name="listaCiudades" scope="request">
			<bean:message key="index.msg" />
			<html:select property="nombreCiudad" value="Palma de Mallorca">
				<logic:iterate id="ciudad" name="listaCiudades" type="trilcejf.tos.Ciudad" >
					<html:option value="<%= ciudad.getNombreCiudad() %>">
						<bean:write name="ciudad" property="nombreCiudad" />
					</html:option>
				</logic:iterate>
			</html:select>
		</logic:notEmpty>
		<p>
		<html:submit styleClass="boton-mini">
			<bean:message key="index.boton" />
		</html:submit>
		<html:hidden property="procedeIndex" value="true"/>
	</html:form>
	<p>
	<html:link action="listarCiudades.do">Administrar</html:link>
	<jsp:include page="footer_index.jsp"/>
</body>
</html:html>
