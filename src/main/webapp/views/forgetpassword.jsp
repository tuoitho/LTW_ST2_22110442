<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forget Password</title>
</head>
<body>
<div class="form-container">
    <i class="fa fa-bars" style="display:none"></i>
    <c:if test="${alert !=null}">
        <div class="alert alert-danger" role="alert">
            ${alert}
        </div>
    </c:if>

    <h2>Forget Password</h2>
    <form action="${pageContext.request.contextPath}/forgetpassword" method="post">
        <input type="text" name="email" placeholder="Email" required>
        <input type="text" name="password" placeholder="New Password" required>
        <button type="submit">Submit</button>
    </form>
</div>
</body>
</html>
