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
<body>Vote here

<form method="POST" action="Vote.do">
    Vote for foods:
    <p>
       Food Names: <p>
        <c:forEach var="food" items="${foodNames}">
    
            <input type=radio name=foodNames value=${food}>${food}<br>

        </c:forEach>


        <br><br>
    <center>
        <input type="SUBMIT" value="Submit">
    </center>
</form>



</body>
</html>