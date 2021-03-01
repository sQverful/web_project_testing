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
<%@ include file="WEB-INF/jsp/client-head.jsp"%>

<body>
<c:if test="${showResultNotification}">
    <%@ include file="WEB-INF/jsp/user-navbar.jsp"%>
    <div class="alert alert-success" role="alert">
        <h4 class="alert-heading h4">You have successfully submitted test!</h4>
        <p class="mb-0">
            <strong>Your result: ${testResult.result}%</strong>
            <br>
            Please, check your result in <a class="alert-link"
                                            href="${pageContext.request.contextPath}/controller?command=testPage&id=${testResult.testId}">Results tab</a>
        </p>
    </div>
</c:if>

<c:if test="${showResultNotificationFail}">
    <%@ include file="WEB-INF/jsp/user-navbar.jsp"%>
    <div class="alert alert-danger" role="alert">
        <h4 class="alert-heading h4">Unfortunately timer has expired. Your result = 0:(</h4>
        <p class="mb-0">
            <strong>Your result: ${testResult.result}%</strong>
            <br>
            You can check your result in <a class="alert-link"
                                            href="${pageContext.request.contextPath}/controller?command=testPage&id=${testResult.testId}">Results tab</a>
        </p>
    </div>
</c:if>

<div class="wrapper">
    <div class="container notification-page">
        <c:if test="${registrationSuccess}">
            <label class="alert-success">You are successfully registered.!</label>
        </c:if>

    </div>
</div>


<!-- js -->
<script src="admin/vendors/scripts/core.js"></script>
<script src="admin/vendors/scripts/script.min.js"></script>
<script src="admin/vendors/scripts/process.js"></script>
<script src="admin/vendors/scripts/layout-settings.js"></script>
</body>
</html>
