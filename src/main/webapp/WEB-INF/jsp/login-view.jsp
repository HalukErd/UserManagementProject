<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<script src="js/login-post.js"></script>
<link href="css/custom.css" rel="stylesheet">
<body>
<%--<c:if test="${alreadyLoggedIn}">--%>
<%--    <div>Already logged in...</div>--%>
<%--</c:if>--%>

<%--<div class="container">--%>
<%--    <form:form modelAttribute="request">--%>
<%--        <form:label cssClass="sr-only" path="username">Username: </form:label>--%>
<%--            <form:input cssClass="form-control" id="username" type="text" path="username"/>--%>

<%--        <form:label cssClass="sr-only" path="password">Password: </form:label>--%>
<%--            <form:input cssClass="form-control" id="password" type="text" path="password"/>--%>

<%--        <input id="login-submit" type="submit" class="btn btn-lg btn-primary btn-block" value="Submit">--%>
<%--    </form:form>--%>
<%--</div>--%>
<form>
    <label for="username">username</label><input type="text" id="username"/>
    <label for="password">password</label><input type="text" id="password"/>
    <button id="login-submit" value="login"></button>
</form>

</body>
</html>