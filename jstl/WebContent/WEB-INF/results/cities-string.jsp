<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" 
%><c:forEach var="city" items="${cities}">${city.name}#</c:forEach>
<c:forEach var="city" items="${cities}">${city.shortTime}#</c:forEach>
<c:forEach var="city" items="${cities}">${city.population}#</c:forEach>