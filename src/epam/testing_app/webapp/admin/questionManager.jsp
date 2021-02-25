<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 22.02.2021
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="jsp-components/admin-head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
<%@ include file="jsp-components/admin-header.jsp" %>
<%@ include file="left-side-bar.jsp"%>
<div class="mobile-menu-overlay"></div>

<div class="main-container">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">

            <!-- Simple Datatable start -->
            <div class="card-box mb-30">
                <div class="pd-20">
                    <h4 class="text-blue h4">Selected test</h4>
                </div>
                <div class="pb-20">
                    <table class="data-table table stripe hover nowrap">
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
                            <tr>
                                <td><c:out value="${selectedTest.id}"/></td>
                                <td><c:out value="${selectedTest.nameUA}"/></td>
                                <td><c:out value="${selectedTest.nameEN}"/></td>
                                <td><c:out value="${selectedTest.complexity}"/></td>
                                <td><c:out value="${selectedTest.requestsQuantity}"/></td>
                                <td>
                                    <c:if test="${selectedTest.blocked eq 'false'}">
                                        <form action="controller" method="post">
                                            <input type="hidden" name="command" value="setBlockedTest">
                                            <input type="hidden" name="questionPage" value="true">
                                            <input type="hidden" name="id" value="${selectedTest.id}">
                                            <input type="hidden" name="isBlocked" value="true">
                                            <input type="submit" class="btn btn-success btn-sm" value="Unblocked">
                                        </form>
                                    </c:if>
                                    <c:if test="${selectedTest.blocked eq 'true'}">
                                        <form action="controller" method="post">
                                            <input type="hidden" name="command" value="setBlockedTest">
                                            <input type="hidden" name="questionPage" value="true">
                                            <input type="hidden" name="id" value="${selectedTest.id}">
                                            <input type="hidden" name="isBlocked" value="false">
                                            <input type="submit" class="btn btn-warning btn-sm" value="Blocked">
                                        </form>
                                    </c:if>
                                </td>
                                <td><c:out value="${selectedTest.timer}"/></td>
                                <td><c:out value="${selectedTest.descriptionUA}"/></td>
                                <td><c:out value="${selectedTest.descriptionEN}"/></td>
                                <td><c:out value="${selectedTest.subjectId}"/></td>
                                <td><c:out value="${selectedTest.createdOn}"/></td>
                                <td>
                                    <div class="dropdown">
                                        <a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                            <i class="dw dw-more"></i>
                                        </a>
                                        <form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                                            <div class="dropdown-item">
                                                <a class="btn" href="controller?command=showTestEditForm&id=${selectedTest.id}"><i class="dw dw-edit2"></i> Edit</a>
                                            </div>
                                            <input type="hidden" name="id" value="${selectedTest.id}">
                                            <input type="hidden" name="command" value="deleteTest">
                                            <div class="dropdown-item">
                                                <i class="dw dw-delete-3"></i>
                                                <input class="btn" type="submit" value="Delete">
                                            </div>
                                        </form>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- Simple Datatable End -->




            <div class="pd-20 card-box height-100-p">



                <div class="container">
                    <h2>Questions</h2>
                    <div id="accordion">
                        <%--Counter for questions--%>
                        <c:set var="questionCounter" value="0" scope="page" />
                        <c:forEach var="question" items="${questionList}">
                        <div class="card">
                            <div class="card-header">
                                <a class="card-link" data-toggle="collapse" href="#collapse${question.id}">
                                    <c:set var="questionCounter" value="${questionCounter + 1}" scope="page"/>
                                        ${questionCounter}.  ${question.questionEN}
                                </a>
                            </div>
                            <div id="collapse${question.id}" class="collapse" data-parent="#accordion">
                                <div class="card-body">
                                    <!-- Simple Datatable start -->
                                    <div class="card-box mb-30">
                                        <div class="pb-20">
                                            <table class="data-table table stripe hover nowrap">
                                                <thead>
                                                <tr>
                                                    <th>№</th>
                                                    <th>Answer UA</th>
                                                    <th>Answer EN</th>
                                                    <th>Correct</th>
                                                    <th class="datatable-nosort">Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <%--Counter for answer table--%>
                                                <c:set var="answerCounter" value="0" scope="page" />

                                                <c:forEach var="answer" items="${answerList}">
                                                    <tr>
                                                        <c:if test="${answer.questionId == question.id}">
                                                            <c:set var="answerCounter" value="${answerCounter + 1}" scope="page"/>
                                                            <td>${answerCounter}</td>
                                                        <td>${answer.questionId == question.id ? answer.answerUA : ""}</td>
                                                        <td>${answer.questionId == question.id ? answer.answerEN : ""}</td>
                                                        <td>
                                                            <c:if test="${answer.correct eq 'true'}">
                                                                <form action="controller" method="post">
                                                                    <input type="hidden" name="command" value="setAnswerCorrect">
                                                                    <input type="hidden" name="answer_id" value="${answer.id}">
                                                                    <input type="hidden" name="correct" value="false">
                                                                    <input type="hidden" name="test_id" value="${selectedTest.id}">
                                                                    <input type="submit" class="btn btn-success btn-sm" value="Correct">
                                                                </form>
                                                            </c:if>
                                                            <c:if test="${answer.correct eq 'false'}">
                                                                <form action="controller" method="post">
                                                                    <input type="hidden" name="command" value="setAnswerCorrect">
                                                                    <input type="hidden" name="answer_id" value="${answer.id}">
                                                                    <input type="hidden" name="correct" value="true">
                                                                    <input type="hidden" name="test_id" value="${selectedTest.id}">
                                                                    <input type="submit" class="btn btn-warning btn-sm" value="Not correct">
                                                                </form>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <div class="dropdown">
                                                                <a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
                                                                    <i class="dw dw-more"></i>
                                                                </a>
                                                                <form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                                                                    <input type="hidden" name="answer_id" value="${answer.id}">
                                                                    <input type="hidden" name="test_id" value="${selectedTest.id}">
                                                                    <input type="hidden" name="command" value="deleteAnswer">
                                                                    <div class="dropdown-item">
                                                                        <i class="dw dw-delete-3"></i>
                                                                        <input class="btn" type="submit" value="Delete">
                                                                    </div>
                                                                </form>
                                                            </div>
                                                        </td>
                                                        </c:if>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <a href="#" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#modal-answer${question.id}" type="button">Add new answer</a>
                                    </div>
                                    <!-- Simple Datatable End -->
                                </div>
                            </div>
                        </div>
                            <%--Modal answer starts--%>
                            <div class="modal fade bs-example-modal-lg" id="modal-answer${question.id}" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                                <div class="modal-dialog modal-lg modal-dialog-centered">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h4 class="text-blue h4">Adding new answer variant</h4>
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        </div>
                                        <div class="modal-body">
                                                <%--Adding new test form starts--%>
                                            <form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                                                <input type="hidden" name="command" value="addNewAnswer">
                                                <input type="hidden" name="test_id" value="${selectedTest.id}">
                                                <input type="hidden" value="${question.id}" type="text" name="question_id">
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-md-2 col-form-label">Question ID</label>
                                                    <div class="col-sm-12 col-md-10">
                                                        <input class="form-control" value="${question.id}" type="text" disabled>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-md-2 col-form-label">Answer ua</label>
                                                    <div class="col-sm-12 col-md-10">
                                                        <input class="form-control" type="text" placeholder="Enter answer in ua language" name="answer_ua">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-md-2 col-form-label">Answer eng</label>
                                                    <div class="col-sm-12 col-md-10">
                                                        <input class="form-control" placeholder="Enter answer in eng language" type="text" name="answer_en">
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-12 col-md-2 col-form-label">Correct</label>
                                                    <div class="col-sm-12 col-md-10">
                                                        <input type="checkbox" class="switch-btn" data-color="#f56767" name="correct">
                                                    </div>
                                                </div>
                                                <button type="submit" class="btn btn-primary">Add answer</button>
                                            </form>
                                                <%--Adding new test form ends--%>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%--Modal window ends--%>
                        </c:forEach>
                    </div>
                </div>

                <br>

                <%--Modal question starts--%>
                <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#modal-question" type="button">Add new question</a>
                <div class="modal fade bs-example-modal-lg" id="modal-question" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="text-blue h4">Adding new question</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            </div>
                            <div class="modal-body">
                                <%--Adding new test form starts--%>
                                <form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                                    <input type="hidden" name="test_id" value="${selectedTest.id}">
                                    <input type="hidden" name="command" value="addNewQuestion">
                                    <input type="hidden" value="${selectedTest.id}" type="text" name="test_id">
                                    <div class="form-group row">
                                        <label class="col-sm-12 col-md-2 col-form-label">Test ID</label>
                                        <div class="col-sm-12 col-md-10">
                                            <input class="form-control" value="${selectedTest.id}" type="text" disabled>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-12 col-md-2 col-form-label">Question ua</label>
                                        <div class="col-sm-12 col-md-10">
                                            <input class="form-control" type="text" placeholder="Enter question in ua language" name="question_ua">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-12 col-md-2 col-form-label">Question eng</label>
                                        <div class="col-sm-12 col-md-10">
                                            <input class="form-control" placeholder="Enter question in eng language" type="text" name="question_en">
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Add question</button>
                                </form>
                                <%--Adding new test form ends--%>
                            </div>
                        </div>
                    </div>
                </div>
                <%--Modal window ends--%>


            </div>

    </div>
</div>
<!-- Default Basic Forms End -->


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
