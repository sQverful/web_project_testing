<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 17.02.2021
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>

<html>

<c:set var="title" value="Error" scope="page"/>
<%@ include file="client-head.jsp" %>

<body>

<div class="error-page d-flex align-items-center flex-wrap justify-content-center pd-20">
    <div class="pd-10">
        <div class="error-page-wrap text-center">
            <c:if test="${not empty code}">
                <h1>${code}</h1>
            </c:if>
            <c:if test="${not empty message}">
                <h3>Message: ${message}</h3>
            </c:if>
            <p>
            <div class="pt-20 mx-auto max-width-200">
                <a href="${pageContext.request.contextPath}" class="btn btn-primary btn-block btn-lg">Back To Home</a>
            </div>
        </div>
    </div>
</div>


<!-- js -->
<script src="admin/vendors/scripts/core.js"></script>
<script src="admin/vendors/scripts/script.min.js"></script>
<script src="admin/vendors/scripts/process.js"></script>
<script src="admin/vendors/scripts/layout-settings.js"></script>
</body>
</html>
