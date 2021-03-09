<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 18.02.2021
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="jsp-components/admin-head.jsp" %>

<body>

<%@ include file="jsp-components/admin-header.jsp" %>
<%@ include file="left-side-bar.jsp"%>
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

                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Role</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value='${user.roleId==1 ? "student" : "admin"}' type="text" disabled="disabled">
                            <input class="form-control" value='${user.roleId}' type="hidden" name="role_id">
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
                            <input type="checkbox" class="switch-btn" data-color="#f56767" name="blocked" ${user.blocked==true ? "checked" : ""}>
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
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/layout-settings.js"></script>
<!-- switchery js -->
<script src="${pageContext.request.contextPath}/admin/src/plugins/switchery/switchery.min.js"></script>
<!-- bootstrap-touchspin js -->
<script src="${pageContext.request.contextPath}/admin/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/advanced-components.js"></script>
</body>
</html>
