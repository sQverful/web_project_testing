<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 18.02.2021
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <!-- Basic Page Info -->
        <meta charset="utf-8">
        <title>Admin panel</title>

        <!-- Site favicon -->
        <link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon-16x16.png">

        <!-- Mobile Specific Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
        <link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
        <link rel="stylesheet" type="text/css" href="vendors/styles/style.css">
        <link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/responsive.bootstrap4.min.css">
        <!-- switchery css -->
        <link rel="stylesheet" type="text/css" href="src/plugins/switchery/switchery.min.css">
        <!-- bootstrap-tagsinput css -->
        <link rel="stylesheet" type="text/css" href="src/plugins/bootstrap-tagsinput/bootstrap-tagsinput.css">
        <!-- bootstrap-touchspin css -->
        <link rel="stylesheet" type="text/css" href="src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.css">
        <link rel="stylesheet" type="text/css" href="vendors/styles/style.css">


        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag(){dataLayer.push(arguments);}
            gtag('js', new Date());

            gtag('config', 'UA-119386393-1');
        </script>
    </head>


<body>
<div class="header">
    <div class="header-left">
        <div class="menu-icon dw dw-menu"></div>
    </div>
    <div class="header-right">
        <div class="user-info-dropdown">
            <div class="dropdown">
                <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="vendors/images/photo1.jpg" alt="">
						</span>
                    <span class="user-name">Ross C. Lopez</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                    <a class="dropdown-item" href="#"><i class="dw dw-help"></i> Help</a>
                    <a class="dropdown-item" href="login.html"><i class="dw dw-logout"></i> Log Out</a>
                </div>
            </div>
        </div>
        <div class="github-link">
            <a href="https://github.com/dropways/deskapp" target="_blank"><img src="vendors/images/github.svg" alt=""></a>
        </div>
    </div>
</div>

<%@ include file="left-side-bar.html"%>
<div class="mobile-menu-overlay"></div>

<div class="main-container">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">

            <div class="pd-20 card-box mb-30">
                <div class="clearfix">
                    <div class="pull-left">
                        <h4 class="text-blue h4">Edit user ID ${user.id}</h4>
                    </div>
                </div>
                <form  accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                    <input type="hidden" name="command" value="updateUser"/>
                    <input type="hidden" name="id" value="${user.id}"/>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Select role</label>
                                <select class="custom-select2 form-control" name="role_id" style="width: 100%; height: 38px;">
                                    <option value="1"<c:out value='${user.roleId==1 ? "selected" : ""}'/>> Student</option>
                                    <option value="2"<c:out value='${user.roleId==2 ? "selected" : ""}'/>> Admin</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Login</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${user.login}" type="text" name="login" disabled="disabled">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Name</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="text" value="${user.name}" name="name">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Surname</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${user.surname}" type="text" name="surname">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">E-mail</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${user.email}" type="email" name="email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Password</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${user.password}" type="password" name="password"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Blocked</label>
                        <div class="col-sm-12 col-md-10">
                            <input type="checkbox" class="switch-btn" data-color="#f56767" name="blocked" <c:out value='${user.blocked==true ? "checked" : ""}'/>>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Update user</button>
                </form>

        </div>
    </div>
</div>


</div>
</div>
</div>
<!-- js -->
<script src="vendors/scripts/core.js"></script>
<script src="vendors/scripts/script.min.js"></script>
<script src="vendors/scripts/process.js"></script>
<script src="vendors/scripts/layout-settings.js"></script>
<!-- switchery js -->
<script src="src/plugins/switchery/switchery.min.js"></script>
<!-- bootstrap-touchspin js -->
<script src="src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="vendors/scripts/advanced-components.js"></script>
</body>
</html>
