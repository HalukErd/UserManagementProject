<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: HalukErd
  Date: 7/3/2021
  Time: 4:29 AM
  To change this template use File | Settings | File Templates.
--%>
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
<body>
<script src="js/signup.js"></script>
<link href="css/custom.css" rel="stylesheet">

<%--<c:if test="${alreadyLoggedIn}">--%>
<%--    <div>Already logged in...</div>--%>
<%--</c:if>--%>

<c:url var="sign_up_url" value="/signup"/>

<form:form action="${sign_up_url}" method="post" modelAttribute="userRequest">
    <form:label cssClass="sr-only" path="username">Username: </form:label>
    <form:input cssClass="form-control" id="username" type="text" path="username" placeholder="Username"/>

    <form:label cssClass="sr-only" path="password">Username: </form:label>
    <form:input cssClass="form-control" type="password" path="password" placeholder="Password"/>

    <form:label cssClass="sr-only" path="name">Username: </form:label>
    <form:input cssClass="form-control" type="text" path="name" placeholder="First Name"/>

    <form:label cssClass="sr-only" path="lastName">Username: </form:label>
    <form:input cssClass="form-control" type="text" path="lastName" placeholder="Last Name"/>

    <form:label cssClass="sr-only" path="email">Username: </form:label>
    <form:input cssClass="form-control" type="text" path="email" placeholder="E-Mail"/>

    <form:label cssClass="sr-only" path="phoneNumber">Username: </form:label>
    <form:input cssClass="form-control" type="text" path="phoneNumber" placeholder="Phone Number"/>

    <form:label cssClass="sr-only" path="birthDay">Username: </form:label>
    <form:input cssClass="form-control" type="date" path="birthDay" placeholder="Birth Day"/>

    <form:label cssClass="sr-only" path="city">Username: </form:label>
    <form:select id="citySelect" cssClass="form-control" path="city">
        <form:option  disabled="true" value="Select a city" selected="true"/>
    </form:select>
    
    <form:label cssClass="sr-only" path="town">Username: </form:label>
    <form:select id="townSelect" cssClass="form-control" path="town">
        <form:option  disabled="true" value="Select a town" selected="true"/>
    </form:select>

    <input type="submit" class="btn btn-lg btn-primary btn-block" value="Submit">

</form:form>

</body>
</html>
