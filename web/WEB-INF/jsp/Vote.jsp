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

<fmt:setLocale value="en" />
<fmt:setBundle basename="messages" />

<html>
<head>
    <title>Vote</title>
    <style type="text/css">
        .align-center {
            display: block;
            margin: 1.0em auto;
            text-align: left;
        }

    </style>
</head>
<body>


<div>
    <form method="POST" action="Vote">
        <fieldset class="align-center">
            <legend>
            <span style="font-size:25px;color:	#2F4F4F">Vote</span>
            </legend>

                <c:forEach var="item" items="${foodMap}">

                    <fieldset class="align-center">
                        <legend>
                            ${item.key}


                        </legend>

                        <c:forEach var="food" items="${item.value}">

                            <input style="align:left" type=radio name=${item.key} value=${food.foodName}>${food.foodName}<br>

                        </c:forEach>
                    </fieldset>


                </c:forEach>
            </div>
        </fieldset>


        <br><br>
        <center>
            <input type="SUBMIT" value=<fmt:message key="common.submit"/> />
        </center>

    </form>
</div>


</body>
</html>