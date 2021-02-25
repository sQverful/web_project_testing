<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 24.02.2021
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Testify. Notification</title>

    <link rel="stylesheet" type="text/css" href="admin/vendors/styles/core.css">
    <link rel="stylesheet" type="text/css" href="admin/vendors/styles/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="admin/src/plugins/jquery-steps/jquery.steps.css">
    <link rel="stylesheet" type="text/css" href="admin/vendors/styles/style.css">
</head>
<body>
<div class="wrapper">
    <div class="container notification-page">
        <c:if test="${registrationSuccess}">
            <label class="alert-success">You are successfully registered.!</label>
        </c:if>

    </div>
</div>

</body>
</html>
