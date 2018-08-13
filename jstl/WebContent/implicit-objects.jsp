<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>JSTL Implicit Objects</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  JSTL Implicit Objects
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
  <LI><B>Value of JSESSIONID Cookie:</B> 
      ${cookie.JSESSIONID.value}
  <LI><B>test Request Parameter:</B> 
      ${param.test}
  <LI><B>User-Agent Header:</B> 
      <%-- Using [] syntax because of dash in name! --%>
      ${header["User-Agent"]}
</UL>
</BODY>
</HTML>