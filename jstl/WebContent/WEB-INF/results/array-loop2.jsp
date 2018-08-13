<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Looping Down Arrays (2)</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Looping Down Arrays (2)
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<CENTER>
<H2>Attendees at the coreservlets.com Party</H2>
<UL>
<c:forEach var="name" items="${names}">
  <LI>${name.firstName} ${name.lastName}
</c:forEach>
</UL>
<H2>Comparing Apples and Oranges</H2>
<TABLE BORDER="1">
  <TR><TH>Year</TH>
      <TH>Apples Sold</TH>
      <TH>Oranges Sold</TH></TR>
<c:forEach var="row" items="${sales}">
  <TR><c:forEach var="col" items="${row}">
        <TD>${col}</TD>
      </c:forEach>
</c:forEach>
</TABLE>
</CENTER></BODY></HTML>