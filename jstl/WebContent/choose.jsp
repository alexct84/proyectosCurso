<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>The "choose" Tag</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      The "choose" Tag
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
<c:forEach var="i" begin="1" end="10">
  <LI>${i}
    <c:choose>
      <c:when test="${i < 4}">
        (small)
      </c:when>
      <c:when test="${i < 8}">
        (medium)
      </c:when>
      <c:otherwise>
        (large)
    </c:otherwise>
      </c:choose>
</c:forEach>
</UL>
</BODY></HTML>