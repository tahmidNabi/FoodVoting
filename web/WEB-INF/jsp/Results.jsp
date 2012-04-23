<%--
  Created by IntelliJ IDEA.
  User: tahmid
  Date: 4/23/12
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head><title>Simple jsp page</title></head>
<body>Results here

<table>
    <tr>
        <th>Name</th>
        <th>Votes</th>
    </tr>
    <c:forEach var="food" items="${foodList}">
        <tr>
            <td>
                 ${food.foodName}
            </td>
            <td>
               ${food.voteCount}
            </td>

        </tr>
    </c:forEach>



</table>


</body>
</html>