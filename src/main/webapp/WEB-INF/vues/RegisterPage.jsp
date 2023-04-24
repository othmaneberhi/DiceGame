<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 19/04/2023
  Time: 04:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ensah.dicegame.bo.MessageTypes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/main.css"
          rel="stylesheet">

</head>
<body>
<div class="container">
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
    <div class="row justify-content-center">

        <div class="col-md-6">
            <div class="card mt-5">
                <div class="card-header">
                    <h4>Register</h4>
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input name="fname" type="text" class="form-control" id="firstName" placeholder="Enter first name">
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input name="lname" type="text" class="form-control" id="lastName" placeholder="Enter last name">
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input name="login" type="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input name="password" type="password" class="form-control" id="password" placeholder="Enter password">
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword">Confirm Password</label>
                            <input name="password_confirmation" type="password" class="form-control" id="confirmPassword" placeholder="Confirm password">
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                        <a class="text-end" href="${pageContext.request.contextPath}/login"> Login </a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
