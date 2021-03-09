<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 16.02.2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<%@ include file="jsp-components/admin-head.jsp" %>


<body>

<%@ include file="jsp-components/admin-header.jsp" %>
<%@ include file="left-side-bar.jsp"%>
<div class="mobile-menu-overlay"></div>

<div class="main-container">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">
            <div class="col-md-4 col-sm-12 mb-30">
                <div class="pd-20 card-box height-100-p">
                    <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#bd-example-modal-lg" type="button">Create new user</a>
                    <div class="modal fade bs-example-modal-lg" id="bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-lg modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="text-blue h4">Creating new user</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                </div>
                                <div class="modal-body">
                                    <form  accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                                        <input type="hidden" name="command" value="addNewUser"/>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Select role</label>
                                                    <select class="custom-select2 form-control" name="role_id" style="width: 100%; height: 38px;">
                                                        <option value="1">Student</option>
                                                        <option value="2">Admin</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Login</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter login" type="text" name="login">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Name</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" type="text" placeholder="Enter user name" name="name">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Surname</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter user surname" type="text" name="surname">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">E-mail</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter user e-mail" type="email" name="email">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Password</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter user password" type="password" name="password"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Blocked</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input type="checkbox" class="switch-btn" data-color="#f56767" name="blocked" value="off">
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Create new user</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Default Basic Forms Start -->


            <!-- Simple Datatable start -->
            <div class="card-box mb-30">
                <div class="pd-20">
                    <h4 class="text-blue h4">Users table</h4>
                </div>
                <div class="pb-20">
                    <table class="data-table table stripe hover nowrap" id="tableWithPagination">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Login</th>
                            <th>Name</th>
                            <th>Surname</th>
                            <th>E-mail</th>
                            <th>Create time</th>
                            <th>Blocked</th>
                            <th>Role</th>
                            <th class="datatable-nosort">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${userList}">
                        <tr>
                            <td class="table-plus"><c:out value="${user.id}"/></td>
                            <td><c:out value="${user.login}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/> </td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.createTime}"/></td>
                            <td>
                                <c:if test="${user.blocked eq 'false'}">
                                    <form action="controller" method="post">
                                        <input type="hidden" name="command" value="setBlockedUser">
                                        <input type="hidden" name="id" value="${user.id}">
                                        <input type="hidden" name="isBlocked" value="true">
                                        <input type="submit" class="btn btn-success btn-sm" value="Unblocked">
                                    </form>
                                </c:if>
                                <c:if test="${user.blocked eq 'true'}">
                                    <form action="controller" method="post">
                                        <input type="hidden" name="command" value="setBlockedUser">
                                        <input type="hidden" name="id" value="${user.id}">
                                        <input type="hidden" name="isBlocked" value="false">
                                        <input type="submit" class="btn btn-warning btn-sm" value="Blocked">
                                    </form>
                                </c:if>
                            </td>
                            <td><c:out value='${user.roleId==1 ? "student" : "admin"}'/></td>
                            <td>
                                <div class="dropdown">
                                    <a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                        <i class="dw dw-more"></i>
                                    </a>
                                    <form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                                        <div class="dropdown-item">
                                        <a class="btn" href="controller?command=showUserEditForm&id=${user.id}"><i class="dw dw-edit2"></i> Edit</a>
                                        </div>
                                        <input type="hidden" name="id" value="${user.id}">
                                        <input type="hidden" name="command" value="deleteUser">
                                        <div class="dropdown-item">
                                            <i class="dw dw-delete-3"></i>
                                        <input class="btn" type="submit" value="Delete">
                                        </div>
                                    </form>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Simple Datatable End -->

        </div>
    </div>
</div>
<!-- Default Basic Forms End -->




<!-- js -->
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/core.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/script.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/process.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/layout-settings.js"></script>
<script src="${pageContext.request.contextPath}/admin/src/plugins/datatables/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/src/plugins/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/src/plugins/datatables/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/src/plugins/datatables/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/datatable-setting.js"></script>
<!-- switchery js -->
<script src="${pageContext.request.contextPath}/admin/src/plugins/switchery/switchery.min.js"></script>
<!-- bootstrap-touchspin js -->
<script src="${pageContext.request.contextPath}/admin/src/plugins/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
<script src="${pageContext.request.contextPath}/admin/vendors/scripts/advanced-components.js"></script>

<%--Used for pagination--%>
<script>
    jQuery( document ).ready(function( $ ) {
        $('#tableWithPagination').DataTable({
            scrollCollapse: true,
            autoWidth: false,
            responsive: true,
            searching: false,
            columnDefs: [{
                targets: "datatable-nosort",
                orderable: false,
            }],
            "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
            "language": {
                "info": "_START_-_END_ of _TOTAL_ entries",
                paginate: {
                    next: '<i class="ion-chevron-right"></i>',
                    previous: '<i class="ion-chevron-left"></i>\n'
                }
            }
        });
    });
</script>
</body>
</html>