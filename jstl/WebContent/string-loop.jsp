<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Looping Down Strings</TITLE>
<LINK REL=STYLESHEET
      HREF="styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Looping Down Strings
</TABLE>
<P>
<H3>Marty has given J2EE short courses in:</H3>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<UL>
<c:forEach var="country" 
           items="Australia,Canada,Japan,Philippines,Mexico,USA">
  <LI>${country}
</c:forEach>
</UL>
For more details or to schedule a short course at <I>your</I> 
company, see <A HREF="http://courses.coreservlets.com">
http://courses.coreservlets.com</A>.
</BODY></HTML>