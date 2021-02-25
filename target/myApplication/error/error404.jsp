<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 24.02.2021
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <!-- Basic Page Info -->
    <meta charset="utf-8">
    <title>Testify. 404</title>

    <!-- Site favicon -->
    <link rel="apple-touch-icon" sizes="180x180" href="../admin/vendors/images/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="../admin/vendors/images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../admin/vendors/images/favicon-16x16.png">

    <!-- Mobile Specific Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <!-- CSS -->
    <link rel="stylesheet" type="text/css" href="../admin/vendors/styles/core.css">
    <link rel="stylesheet" type="text/css" href="../admin/vendors/styles/icon-font.min.css">
    <link rel="stylesheet" type="text/css" href="../admin/vendors/styles/style.css">

</head>
<body>
<div class="error-page d-flex align-items-center flex-wrap justify-content-center pd-20">
    <div class="pd-10">
        <div class="error-page-wrap text-center">
            <h1>404</h1>
            <h3>Error: 404 Page Not Found</h3>
            <p>Sorry, the page you’re looking for cannot be accessed.<br>Either check the URL</p>
            <div class="pt-20 mx-auto max-width-200">
                <a href="${pageContext.request.contextPath}" class="btn btn-primary btn-block btn-lg">Back To Home</a>
            </div>
        </div>
    </div>
</div>
<!-- js -->
<script src="../admin/vendors/scripts/core.js"></script>
<script src="../admin/vendors/scripts/script.min.js"></script>
<script src="../admin/vendors/scripts/process.js"></script>
<script src="../admin/vendors/scripts/layout-settings.js"></script>
</body>
</html>