<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>


	<f:view>
	<html>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<head>
<title>User Login</title>
	<html:base/>
	<link href="pages/mycss.css" rel="stylesheet" type="text/css">
	<f:loadBundle basename="mensajes" var="msjs"/>
</head>
<body >
	<center>
		<f:subview id="cap">
			<jsp:include page="/pages/header.jsp" />
		</f:subview>
		<h:messages showDetail="true" styleClass="errors"/>

		<h:form
			id="loginForm"
			>
			<label for="j_username"><h:outputText value="Username:" /><br />
			</label>
			<h:inputText
				id="j_username"
				value="#{loginBean.username}"
				required="true">
			</h:inputText>

			<br />
			<br />
			<label for="j_password"><h:outputText value="Password:" /><br />
			</label>
			<h:inputSecret
				id="j_password"
				value="#{loginBean.password}"
				required="true">
			</h:inputSecret>

			<br />
			<br />
			<label for="_spring_security_remember_me"> <h:outputText
				value="Remember me" /> </label>
			<h:selectBooleanCheckbox id="_spring_security_remember_me" />
			<br />

			<h:commandButton
				type="submit"
				id="login"
				action="#{loginBean.doLogin}"
				value="Login" />

		</h:form>
		<f:subview id="footer">
			<jsp:include page="/pages/footer.jsp" />
		</f:subview>
	</center>
		</body>
 </html>
	</f:view>
