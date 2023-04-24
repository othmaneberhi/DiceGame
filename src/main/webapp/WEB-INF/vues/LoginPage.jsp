<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ensah.dicegame.bo.MessageTypes" %>
<html>
<head>
    <title>Dice game | Login</title>

    <link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/login.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/main.css"
          rel="stylesheet">


</head>
<body>
<div class="mx-auto w-50">
    <h1 class="text-center">Login</h1>
    <c:choose>
        <c:when test="${message.type==MessageTypes.WARNING}">
            <div class="alert alert-warning" role="alert">
                    ${message}
            </div>
        </c:when>
        <c:when test="${message.type==MessageTypes.ERROR}">
            <div class="alert alert-danger" role="alert">
                    ${message}
            </div>
        </c:when>
        <c:when test="${message.type==MessageTypes.INFO}">
            <div class="alert alert-info" role="alert">
                    ${message}
            </div>
        </c:when>
        <c:otherwise>

        </c:otherwise>
    </c:choose>

    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="form-group">
            <label for="email">Email address</label>
            <input name="login" type="email" class="form-control" id="email" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input name="password" type="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary w-100" >Submit</button>
        <a class="text-end" href="${pageContext.request.contextPath}/register"> Register </a>
    </form>
</div>

</body>
</html>
