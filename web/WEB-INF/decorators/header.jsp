<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="en" />
<fmt:setBundle basename="messages" />

<br/><br/>

<div class="header" align="right">

    <form action="logout" method="POST">
        <input type="submit" value=<fmt:message key="logout.btn.label"/>>
    </form>
</div>


<div class="header" align="center">

    <h1 class="header">Vote for your favorite foods</h1>

    <h3>
        <c:if test="${not empty USER}">
            Hello, ${USER.userName}
        </c:if>
    </h3>

</div>