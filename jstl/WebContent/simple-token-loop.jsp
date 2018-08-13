<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Token Loop</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Token Loop
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
<c:forTokens var="color"
    items="(red (orange) yellow)(green)((blue) violet)"
    delims="()">
  <LI>${color}
</c:forTokens>
</UL>
</BODY></HTML>