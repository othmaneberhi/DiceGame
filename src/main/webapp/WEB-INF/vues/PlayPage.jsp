<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ensah.dicegame.bo.MessageTypes" %>
<%@ page import="com.ensah.dicegame.bo.State" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Dice Game | PLAY</title>

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
<div class="container mt-4">
    <h2 class="text-center font-weight-bold ">
        Let's Play !
    </h2>

    <div class=" w-fit mx-auto my-3">
        <c:choose>
            <c:when test="${message.type==MessageTypes.INFO}">
                <div class="alert alert-info" role="alert">
                        ${message}
                </div>
            </c:when>
            <c:when test="${message.type==MessageTypes.ERROR}">
                <div class="alert alert-danger" role="alert">
                        ${message}
                </div>
            </c:when>
        </c:choose>
    </div>
    <div class=" w-fit mx-auto px-5">
        <c:choose>
            <c:when test="${gameState.gameOver}">
                <%
                    State gameState  = (State) request.getSession().getAttribute("gameState");
                    HashMap<Integer,Integer> launchedDices = gameState.getLaunchedDices();
                    request.setAttribute("values",launchedDices.values());
                %>
                <div class="d-flex justify-content-center">
                    <c:forEach var="value" items="${values}">
                        <c:choose>
                            <c:when test="${value==1}">
                                <img src="https://img.icons8.com/windows/256/dice-one.png" width="50" height="50">
                            </c:when>
                            <c:when test="${value==2}">
                                <img src="https://img.icons8.com/windows/256/dice-two.png" width="50" height="50">
                            </c:when>
                            <c:when test="${value==3}">
                                <img src="https://img.icons8.com/windows/256/dice-three.png" width="50" height="50">
                            </c:when>
                            <c:when test="${value==4}">
                                <img src="https://img.icons8.com/windows/256/dice-four.png" width="50" height="50">
                            </c:when>
                            <c:when test="${value==5}">
                                <img src="https://img.icons8.com/windows/256/dice-five.png" width="50" height="50">
                            </c:when>
                            <c:when test="${value==6}">
                                <img src="https://img.icons8.com/windows/256/dice-six.png" width="50" height="50">
                            </c:when>
                        </c:choose>
                    </c:forEach>

                </div>
                <div class="card px-5 text-center">
                    <div class="card-body">
                        <span class="card-title"><span class="font-weight-bold">Score</span>  ${gameState.score} pts</span>
                        <span>|</span>
                        <span class="card-title"><span class="font-weight-bold">Best Score</span> ${user.bestScore} pts</span>
                    </div>
                    <a href="${pageContext.request.contextPath}/secure/newGame">
                        <button type="submit" class="btn btn-primary px-5 mb-3">Play again</button>
                    </a>
                </div>
            </c:when>

            <c:otherwise>
                <div class="card px-5 text-center">
                    <div class="card-body text-center">
                        <form action="${pageContext.request.contextPath}/secure/play" method="post">
                            <div class=" mx-auto form-group d-flex justify-content-center align-items-center" style="min-width: 200px">
                                <label for="dice" class="form-label mr-2">Dice</label>
                                <input required type="number" id="dice" name="dice" placeholder="dice number" class="form-control" min="1" max="3">
                            </div>
                            <button type="submit" class="btn btn-primary px-5">Roll</button>
                        </form>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>

    </div>
    </div>

</body>
</html>
