<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 26.02.2021
  Time: 13:07
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
                            <h4>Test page</h4>
                        </div>
                        <nav aria-label="breadcrumb" role="navigation">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/controller?command=showMainPage">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page"><a href="${pageContext.request.contextPath}/controller?command=subjectPage&id=${selectedSubject.id}">${selectedSubject.nameEN} page</a></li>
                                <li class="breadcrumb-item active" aria-current="page">${selectedTest.nameEN} page</li>
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
                                        <a class="nav-link active" data-toggle="tab" href="#testPage" role="tab">Test page</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#info" role="tab">Info</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <!--  Available Test Tab start -->
                                    <div class="tab-pane fade show active" id="testPage" role="tabpanel">
                                        <div class="pd-20">
                                            <div class="card-box mb-30">
                                                <div class="pd-20">
                                                    <h4 class="text-blue h5">Test lasts ${selectedTest.timeout} minutes</h4>
                                                </div>
                                                <div class="pb-20">
                                                    <c:if test="${!selectedTest.blocked}">
                                                    <a type="button" class="btn btn-primary btn-block">Start</a>
                                                    </c:if>
                                                    <c:if test="${selectedTest.blocked}">
                                                        <button type="submit" class="btn btn-warning btn-block" disabled>Test is closed</button>
                                                    </c:if>
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
                            <h5 class="card-header weight-500">${selectedTest.nameEN}</h5>
                            <div class="card-body">
                                <p class="card-text">${selectedTest.descriptionEN}</p>
                            </div>
                            <div class="card-footer text-muted small">
                                Complexity: ${selectedTest.complexity}
                                <br>
                                Status:
                                <c:if test="${selectedTest.blocked eq 'false'}">
                                    <input type="button" class="btn-success btn-xs" value="Opened">
                                </c:if>
                                <c:if test="${selectedTest.blocked eq 'true'}">
                                    <input type="button" class="btn-warning btn-xs" value="Closed">
                                </c:if>
                                <br>
                                Requests quantity: ${selectedTest.requestsQuantity}
                            </div>
                            <div class="card-footer text-muted small">
                                Created: ${selectedTest.createdOn}
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
