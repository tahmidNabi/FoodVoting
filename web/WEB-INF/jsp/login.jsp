<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en" />
<fmt:setBundle basename="messages" />




<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<div style="padding-left:500">
<form action="Home" method="POST">

    <fieldset>
        <legend>Log In</legend>
        Username: <br> <input name="Name" type="text">
        <br><br>
        Password: <br> <input type="password" name="Password">
    <br><br>
    <input type="submit" value=<fmt:message key="login.btn.label"/> />

        </fieldset>

</form>
</div>
<div style="padding-left:500;font-size:20px">
    ${loginError}
</div>
</body>
</html>
