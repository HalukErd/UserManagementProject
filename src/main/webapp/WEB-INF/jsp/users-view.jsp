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
<script src="js/users.js"></script>
<link href="css/custom.css" rel="stylesheet">

<%--<c:if test="${alreadyLoggedIn}">--%>
<%--    <div>Already logged in...</div>--%>
<%--</c:if>--%>
<%--let hasDeleteAndUpdateAuthorities = "${hasDeleteUpdateAuthority}";--%>
<table id="usersTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Role</th>
        <th>Name</th>
        <th>LastName</th>
        <th>Email</th>
        <th>PhoneNumber</th>
        <th>BirthDay</th>
        <c:if test="${hasDeleteUpdateAuthority}">
            <th>Update</th>
            <th>Delete</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.userRole}</td>
            <td>${user.name}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.birthDay}</td>
            <c:if test="${hasDeleteUpdateAuthority}">
                <td><input type="button" id="${user.id}" value='Delete' class="btn-delete"/></td>
                <td><input type="button" id="${user.id}" value='Update' class="btn-update"/></td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
