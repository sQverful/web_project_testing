<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 26.02.2021
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

    <%@ include file="WEB-INF/jsp/client-head.jsp"%>

</head>
<body>

<%@ include file="WEB-INF/jsp/user-navbar.jsp"%>

<div class="main">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">
            <div class="page-header">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="title">
                            <h4>Subject page</h4>
                        </div>
                        <nav aria-label="breadcrumb" role="navigation">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/controller?command=showMainPage">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${selectedSubject.nameEN} page</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-md-9 col-sm-12 mb-30">
                    <div class="card-box height-100-p overflow-hidden">
                        <div class="profile-tab height-100-p">
                            <div class="tab height-100-p">
                                <ul class="nav nav-tabs customtab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" data-toggle="tab" href="#testList" role="tab">Available tests</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#info" role="tab">Info</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <!--  Available Test Tab start -->
                                    <div class="tab-pane fade show active" id="testList" role="tabpanel">
                                        <div class="pd-20">
                                            <div class="card-box mb-30">
                                                <div class="pd-20">
                                                    <h4 class="text-blue h5">Tests</h4>
                                                </div>
                                                <div class="pb-20">
                                                    <table class="data-table table stripe hover nowrap table-responsive-xl">
                                                        <thead>
                                                        <tr>
                                                            <th>№</th>
                                                            <th>Name</th>
                                                            <th>Complexity</th>
                                                            <th>Requests</th>
                                                            <th>Status</th>
                                                            <th>Create time</th>
                                                            <th class="datatable-nosort">Action</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:if test="${!subjectHasTest}">
                                                            <tr>
                                                            <caption class="alert alert-warning">No available tests</caption>
                                                            </tr>
                                                        </c:if>
                                                        <c:set var="questionCounter" value="0" scope="page" />
                                                        <c:if test="${subjectHasTest}">
                                                        <c:forEach var="test" items="${testList}">
                                                            <tr>
                                                                <c:set var="questionCounter" value="${questionCounter + 1}" scope="page"/>
                                                                <td><c:out value="${questionCounter}"/></td>
                                                                <td><c:out value="${test.nameEN}"/></td>
                                                                <td><c:out value="${test.complexity}"/></td>
                                                                <td><c:out value="${test.requestsQuantity}"/></td>
                                                                <td>
                                                                    <c:if test="${test.blocked eq 'false'}">
                                                                            <input type="button" class="btn btn-success btn-sm" value="Opened">
                                                                    </c:if>
                                                                    <c:if test="${test.blocked eq 'true'}">
                                                                            <input type="button" class="btn btn-warning btn-sm" value="Closed">
                                                                    </c:if>
                                                                </td>
                                                                <td><c:out value="${test.createdOn}"/></td>
                                                                <td>
                                                                    <a class="btn-sm btn-info" href="${pageContext.request.contextPath}/controller?command=testPage&id=${test.id}">
                                                                        Pass test
                                                                    </a>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                        </c:if>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Available Test Tab End -->
                                    <!-- Info Tab start -->
                                    <div class="tab-pane fade" id="info" role="tabpanel">
                                        <div class="pd-20 profile-task-wrap">
                                            <!-- Open Task start -->
                                            <div class="task-title row align-items-center">
                                                <div class="col-md-8 col-sm-12">
                                                    <h5>Description</h5>
                                                    <p class="p-4">Something will be here</p>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                    <!-- Info Tab End -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xl-3 col-lg-3 col-md-3 col-sm-12 mb-30">
                    <div class="pd-20 card-box height-100-p">
                        <div class="card card-box">
                            <h5 class="card-header weight-500">${selectedSubject.nameEN}</h5>
                            <div class="card-body">
                                <p class="card-text">${selectedSubject.descriptionEN}</p>
                            </div>
                            <div class="card-footer text-muted small">
                                Created: ${selectedSubject.createdOn}
                            </div>
                            <div class="card-footer text-muted small">
                                By:
                                <button type="button" class="btn btn-outline-dark btn-sm" data-container="body" data-toggle="popover" data-placement="right" data-content="${adminDetails.email}" title="Contact info">
                                    ${adminDetails.name} ${adminDetails.surname}
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

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
