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
            <%--Modal window starts--%>
            <div class="pd-20 card-box height-100-p">
                <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#bd-example-modal-lg" type="button">Create new test</a>
                <div class="modal fade bs-example-modal-lg" id="bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="text-blue h4">Adding new test</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            </div>
                            <div class="modal-body">
                                <%--Adding new test form starts--%>
                                    <form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                                        <input type="hidden" name="command" value="addNewTest">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Select Subject</label>
                                                    <select class="custom-select2 form-control" name="subject_id" style="width: 100%; height: 38px;">
                                                        <optgroup label="Subjects">
                                                            <c:forEach var="subject" items="${subjectList}">
                                                            <option value="${subject.id}">${subject.nameEN}</option>
                                                            </c:forEach>
                                                        </optgroup>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Name ua</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" type="text" placeholder="Enter name in ua language" name="name_ua">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Name eng</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter name in eng language" type="text" name="name_en">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Complexity</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input class="form-control" placeholder="Enter complexity" type="text" name="complexity">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Blocked</label>
                                            <div class="col-sm-12 col-md-10">
                                                <input type="checkbox" class="switch-btn" data-color="#f56767" name="blocked">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Timer</label>
                                            <div class="form-group">
                                                <label>Time in minutes</label>
                                                <input id="demo_vertical2" type="text" value="60" name="timer">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Description ua</label>
                                            <div class="col-sm-12 col-md-10">
                                                <textarea class="form-control" placeholder="Enter description in ua" name="description_ua"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-12 col-md-2 col-form-label">Description eng</label>
                                            <div class="col-sm-12 col-md-10">
                                                <textarea class="form-control" placeholder="Enter description in eng" name="description_en"></textarea>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Add test</button>
                                    </form>
                                <%--Adding new test form ends--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--Modal window ends--%>

            <!-- Default Basic Forms Start -->
                <br>
                <br>
                <br>
                <!-- Simple Datatable start -->
                <div class="card-box mb-30">
                    <div class="pd-20">
                        <h4 class="text-blue h4">Tests table</h4>
                    </div>
                    <div class="pb-20">
                        <table class="data-table table stripe hover nowrap" id="tableWithPagination">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name ua</th>
                                <th>Name en</th>
                                <th>Complexity</th>
                                <th>Requests quantity</th>
                                <th>Blocked</th>
                                <th>Timer</th>
                                <th>Description ua</th>
                                <th>Description en</th>
                                <th>Subject ID</th>
                                <th>Create time</th>
                                <th class="datatable-nosort">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="test" items="${testList}">
                                <tr>
                                    <td><c:out value="${test.id}"/></td>
                                    <td><c:out value="${test.nameUA}"/></td>
                                    <td><c:out value="${test.nameEN}"/></td>
                                    <td><c:out value="${test.complexity}"/></td>
                                    <td><c:out value="${test.requestsQuantity}"/></td>
                                    <td>
                                        <c:if test="${test.blocked eq 'false'}">
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="setBlockedTest">
                                                <input type="hidden" name="id" value="${test.id}">
                                                <input type="hidden" name="isBlocked" value="true">
                                                <input type="submit" class="btn btn-success btn-sm" value="Unblocked">
                                            </form>
                                        </c:if>
                                        <c:if test="${test.blocked eq 'true'}">
                                            <form action="controller" method="post">
                                                <input type="hidden" name="command" value="setBlockedTest">
                                                <input type="hidden" name="id" value="${test.id}">
                                                <input type="hidden" name="isBlocked" value="false">
                                                <input type="submit" class="btn btn-warning btn-sm" value="Blocked">
                                            </form>
                                        </c:if>
                                    </td>
                                    <td><c:out value="${test.timer}"/></td>
                                    <td><c:out value="${test.descriptionUA}"/></td>
                                    <td><c:out value="${test.descriptionEN}"/></td>
                                    <td><c:out value="${test.subjectId}"/></td>
                                    <td><c:out value="${test.createdOn}"/></td>
                                    <td>
                                        <div class="dropdown">
                                            <a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                                <i class="dw dw-more"></i>
                                            </a>
                                            <form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                                                <div class="dropdown-item">
                                                    <a class="btn" href="controller?command=QAList&id=${test.id}"><i class="fa-question-circle"></i> Questions</a>
                                                </div>
                                                <div class="dropdown-item">
                                                    <a class="btn" href="controller?command=showTestEditForm&id=${test.id}"><i class="dw dw-edit2"></i> Edit</a>
                                                </div>
                                                <input type="hidden" name="id" value="${test.id}">
                                                <input type="hidden" name="command" value="deleteTest">
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
