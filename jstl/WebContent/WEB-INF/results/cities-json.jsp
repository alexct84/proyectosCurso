<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
({ "names": 
    [<c:forEach var="city" items="${cities}">
       "${city.name}", 
     </c:forEach>],
   "times": 
    [<c:forEach var="city" items="${cities}">
       "${city.shortTime}", 
     </c:forEach>],
   "populations": 
    [<c:forEach var="city" items="${cities}">
       "${city.population}", 
     </c:forEach>]
})