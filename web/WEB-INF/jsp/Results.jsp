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
    <title>Results</title>
    <style type="text/css">
        .foodTable {
            font-family: Arial;
            width: 50%;
            margin: auto;
        }

        .foodTable td {
            border: 1px solid #4169E1;
            font-size: 1em;
            padding: 8px 1px;
            text-align: center;
        }

        .foodTable th {
            background-color: #A9A9A9;
            color: #FFFFFF;
            font-size: 1.1em;
            padding-bottom: 1px;
            padding-top: 5px;
            text-align:center;
        }


    </style>


</head>
<body>

<c:forEach var="item" items="${foodMap}">

<table class="foodTable">
    <caption>
        <span style="font-size:20px">${item.key}</span>
    </caption>
    <tr>
        <th>Name</th>
        <th>Votes</th>
    </tr>
    <c:forEach var="food" items="${item.value}">
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
    </br></br>
</c:forEach>


</body>
</html>