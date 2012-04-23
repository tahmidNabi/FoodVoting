<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="en" />
<fmt:setBundle basename="messages" />


<html>
<head><title><fmt:message key="login.title"/></title></head>
<body>
<form action="Login.do" method="POST">

    <label>User Name</label> <input name="Name" type="text">
    <br>
    <label>Password</label> <input type="password" name="Password">
    <br>
    <input type="submit" value=<fmt:message key="login.btn.label"/> />

</form>

</body>
</html>
