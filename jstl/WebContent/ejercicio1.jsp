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
	<c:forEach var="i" begin="1" end="25">
  	<LI>${i}
  			<c:set var="ndiv" value="0" />
  			<c:forEach var="a" begin="1" end="${i}">
     			<c:if test="${i%a==0}">
      				<c:set value="${ndiv+1}" />
      			</c:if> 
      		</c:forEach>
      		<c:choose>
      			<c:when test="${ndiv == 2}">
			        (PRIMO)
			    </c:when>
			    <c:otherwise>
        			(NO PRIMO)
    			</c:otherwise>
      		</c:choose>
	</c:forEach>
</UL>

</body>
</html>