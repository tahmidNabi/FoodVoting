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
<head>
    <title>Simple jsp page</title>
    <style type="text/css">
        #foodtable {
            font-family: Arial;
            width: 50%;
            margin: auto;
        }

        #foodtable td {
            border: 1px solid #4169E1;
            font-size: 1em;
            padding: 8px 1px;
            text-align: center;
        }

        #foodtable th {
            background-color: #A9A9A9;
            color: #FFFFFF;
            font-size: 1.1em;
            padding-bottom: 1px;
            padding-top: 5px;
            text-align:center;
        }


    </style>


</head>
<body>Results here

<table id="foodtable">
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