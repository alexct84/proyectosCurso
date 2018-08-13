<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Database Example</TITLE>
<LINK REL=STYLESHEET
      HREF="../styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<CENTER>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
      Database Example
</TABLE>
<P>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" 
           uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource
  driver="sun.jdbc.odbc.JdbcOdbcDriver"
  url="jdbc:odbc:Northwind"
  user=""
  password=""/>
<sql:query var="employees">
  SELECT * FROM employees
</sql:query>
<UL>
<c:forEach var="row" items="${employees.rows}">
  <LI>${row.firstname}
      ${row.lastname}
</c:forEach>
</UL>
</CENTER>
</BODY></HTML>