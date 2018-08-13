<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Simple Loop</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Simple Loop
</TABLE>
<P>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
<c:forEach var="i" begin="1" end="10">
  <LI>${i}
</c:forEach>
</UL>
</BODY></HTML>