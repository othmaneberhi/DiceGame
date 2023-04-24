<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>DICE GAME!</title>
    <link href="${pageContext.request.contextPath}/style/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/main.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/home.css"
          rel="stylesheet">

</head>
<body>
<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">DICE GAME</h3>
                    <nav class="nav nav-masthead">
                        <a href="${pageContext.request.contextPath}/login" class="nav-link" href="#">Login</a>
                        <a href="${pageContext.request.contextPath}/register" class="nav-link" href="#">Register</a>

                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">DICE GAME</h1>
                <p class="lead">Roll the dice and try to get the highest score in 3 turns!</p>
                <p class="lead">
                    <a href="${pageContext.request.contextPath}/secure/play" class="btn btn-lg btn-secondary">Play now</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Built  by <a href="https://ma.linkedin.com/in/berhiothmane">Othmane berhi</a>.</p>
                </div>
            </div>

        </div>

    </div>

</div>

</body>
</html>