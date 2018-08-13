<?xml version="1.0" encoding="UTF-8"?>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<cities>
<c:forEach var="city" items="${cities}">
  <city>
    <name>${city.name}</name>
    <time>${city.shortTime}</time>
    <population>${city.population}</population>
  </city>
</c:forEach>
</cities>