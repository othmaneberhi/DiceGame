<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ensah.dicegame.bo.MessageTypes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dice game </title>

    <link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/main.css"
          rel="stylesheet">
</head>
<body>


<nav class="navbar navbar-light  justify-content-between" style="background-color: #e3f2fd;">
    <a class="navbar-brand font-weight-bold" href="${pageContext.request.contextPath}/secure/game">Dice Game</a>

    <a href="${pageContext.request.contextPath}/secure/logout"><button class="btn btn-outline-dark" >logout</button></a>
</nav>
<div class="container">

    <div class="row mt-4">
        <div class="col w-fit mx-auto">
            <c:choose>
                <c:when test="${message.type==MessageTypes.SUCCESS}">
                    <div class="alert alert-success" role="alert">
                            ${message}
                    </div>
                </c:when>
                <c:otherwise>

                </c:otherwise>
            </c:choose>
        </div>
    </div>


    <div class="row mx-5 px-5">
        <div class="col card card-body mb-2 mt-4">
            <p class="alert-heading">Roll the dice and try to get the highest score in 3 turns!</p>
            <hr>
            <strong><p>Rules:</p></strong>
            <ul class="list-group px-3">
                <li>Players roll three dice one at a time, in any order.</li>
                <li>The same die cannot be rolled more than once.</li>
                <li>If the result of the first die is strictly less than the result of the second die and the result of the second die is strictly less than the result of the third die, the player receives a score equal to the sum of the results of all three dice.</li>
                <li>If the result of the first die is strictly greater than the result of the second die and the result of the second die is strictly greater than the result of the third die, the player receives a score equal to the product of the results of all three dice.</li>
            </ul>
        </div>
    </div>
    <div class="row">
        <div class=" alert alert-info mx-auto p-2 m-2 w-fit text-center">
            <p class="mb-0">Highest score: ${user.bestScore} pts</p>
        </div>
    </div>
    <div class="row mb-5">
        <div class="col text-center">
            <a href="${pageContext.request.contextPath}/secure/newGame"><button class="btn btn-primary">New game</button></a>
        </div>
    </div>
    <c:if test="${users!=null}">
    <div class="row mt-5">
        <div class="col">
            <h4 class="mb-4">Other players scores</h4>
            <table class="table border">
                <thead class="bg-info text-light">
                <tr>
                    <th>Player</th>
                    <th>Score</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.fname} ${user.lname}</td>
                        <td>${user.bestScore} pts</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    </c:if>
</div>


</body>
</html>
