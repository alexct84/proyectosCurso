<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Session Timeout</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Session Timeout
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
<c:forEach var="seconds" 
           begin="0" 
           end="${pageContext.session.maxInactiveInterval}"
           step="100">
  <LI>${seconds} seconds.
</c:forEach>
  <LI>Timeout exceeded.
</UL>
</BODY></HTML>