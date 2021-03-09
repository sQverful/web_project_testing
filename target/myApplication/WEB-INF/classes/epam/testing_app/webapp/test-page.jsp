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
    <%@ include file="WEB-INF/jsp/client-head.jsp" %>
</head>
<body>
<%@ include file="WEB-INF/jsp/user-navbar.jsp" %>

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
                                <li class="breadcrumb-item"><a
                                        href="${pageContext.request.contextPath}/controller?command=showMainPage">Home</a>
                                </li>
                                <li class="breadcrumb-item active" aria-current="page"><a
                                        href="${pageContext.request.contextPath}/controller?command=subjectPage&id=${selectedSubject.id}">${selectedSubject.nameEN}
                                    page</a></li>
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
                                        <a class="nav-link active" data-toggle="tab" href="#testPage" role="tab">Test
                                            page</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" data-toggle="tab" href="#resultsTab" role="tab">Results</a>
                                    </li>
                                </ul>
                                <div class="tab-content">
                                    <!--  Available Test Tab start -->
                                    <div class="tab-pane fade show active" id="testPage" role="tabpanel">
                                        <div class="pd-20">
                                            <div class="card-box mb-30">
                                                <c:if test="${isStarted}">
                                                    <%--Test passing starts here--%>
                                                    <h2>Questions</h2>
                                                    <div id="accordion">
                                                            <%--Counter for questions--%>
                                                        <c:set var="questionCounter" value="0" scope="page"/>

                                                        <form action="${pageContext.request.contextPath}/controller?command=submitTest"
                                                              method="post">
                                                            <c:forEach var="question" items="${questionList}">
                                                                <div class="card">
                                                                    <div class="card-header small">
                                                                        <a class="card-link" data-toggle="collapse"
                                                                           href="#collapse${question.id}">
                                                                            <c:set var="questionCounter"
                                                                                   value="${questionCounter + 1}"
                                                                                   scope="page"/>
                                                                                ${questionCounter}. ${question.questionEN}
                                                                        </a>
                                                                    </div>
                                                                    <div id="collapse${question.id}" class="collapse"
                                                                         data-parent="#accordion">
                                                                        <div class="card-body">
                                                                            <!-- Simple Datatable start -->
                                                                            <div class="card-box mb-30">
                                                                                <div class="pb-20">
                                                                                    <c:set var="answerCounter" value="0"
                                                                                           scope="page"/>
                                                                                    <c:set var="counter" value="0"
                                                                                           scope="request"/>

                                                                                    <c:forEach var="answer"
                                                                                               items="${answerList}">
                                                                                        <c:set var="counter"
                                                                                               value="${counter + 1}"
                                                                                               scope="request"/>

                                                                                        <c:if test="${answer.questionId == question.id}">
                                                                                            <c:set var="answerCounter"
                                                                                                   value="${answerCounter + 1}"
                                                                                                   scope="page"/>
                                                                                            <div class="p-2">
                                                                                                <input type="checkbox"
                                                                                                       name="answer${counter}"
                                                                                                       id="question-${answerCounter}-answers-A"
                                                                                                       value="${answer.id}"/>
                                                                                                <label for="question-${answerCounter}-answers-A">${answerCounter}) ${answer.answerEN} </label>
                                                                                            </div>
                                                                                        </c:if>

                                                                                    </c:forEach>

                                                                                </div>
                                                                            </div>
                                                                            <!-- Simple Datatable End -->
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </c:forEach>
                                                            <input type="hidden" name="test_id"
                                                                   value="${selectedTest.id}">
                                                            <input type="hidden" name="counter" value="${counter}">
                                                            <input type="submit" class="btn btn-primary btn-block"
                                                                   value="Submit answers">
                                                        </form>
                                                    </div>
                                                    <%--Test passing ends here--%>
                                                </c:if>

                                                <c:if test="${!isStarted}">
                                                    <div class="pd-20">
                                                        <h4 class="text-blue h5">Test lasts ${selectedTest.timer}
                                                            minutes</h4>
                                                    </div>
                                                    <div class="pb-20">
                                                        <c:if test="${!selectedTest.blocked}">
                                                            <a type="button" class="btn btn-primary btn-block"
                                                               href="${pageContext.request.contextPath}/controller?command=startTest&id=${selectedTest.id}">Start</a>
                                                        </c:if>
                                                        <c:if test="${selectedTest.blocked}">
                                                            <button type="submit" class="btn btn-warning btn-block"
                                                                    disabled>Test is closed
                                                            </button>
                                                        </c:if>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Available Test Tab End -->
                                    <!-- Results Tab start -->
                                    <div class="tab-pane fade" id="resultsTab" role="tabpanel">
                                        <div class="pd-20 profile-task-wrap">
                                            <div class="card-box mb-30">
                                                <div class="pd-20">
                                                    <h4 class="text-blue h4">Results table</h4>
                                                    <p>${selectedTest.nameEN}</p>
                                                    <br>
                                                    All test results you can find in Profile page
                                                </div>
                                                <div class="pb-20">
                                                    <table class="data-table table stripe hover nowrap" id="tableWithPagination">
                                                        <thead>
                                                        <tr>
                                                            <th>№</th>
                                                            <th>Result</th>
                                                            <th>Create time</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>
                                                        <c:set var="counter" value="0" scope="page"/>
                                                        <c:forEach var="testResult" items="${allResultsList}">
                                                            <tr>
                                                                <c:set var="counter" value="${counter + 1}"
                                                                       scope="page"/>
                                                                <td>${counter}</td>
                                                                <td>${testResult.result}</td>
                                                                <td>${testResult.createdOn}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Results Tab End -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <c:if test="${isStarted}">
                    <%--Timer div starts--%>
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
                            <div class="card card-box">
                                <h5 class="card-header weight-500">Timer</h5>
                                <div class="card-body">
                                    <p id="testTimer"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--Timer div ends--%>
                </c:if>

            <c:if test="${!isStarted}">
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
            </c:if>
            </div>
        </div>
    </div>
</div>
<%--Timer--%>

<c:if test="${isStarted}">
    <c:if test="${sessionScope.timerID == selectedTest.id}">

        <script>
            // Set the date we're counting down to
            var countDownDate = new Date("${timeEnd}");

            // Update the count down every 1 second
            var x = setInterval(function () {

                // Get today's date and time
                var now = new Date().getTime();

                // Find the distance between now and the count down date
                var distance = countDownDate - now;

                // Time calculations for days, hours, minutes and seconds
                var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
                var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
                var seconds = Math.floor((distance % (1000 * 60)) / 1000);

                // Output the result in an element with id="demo"
                document.getElementById("testTimer").innerHTML = hours + "h "
                    + minutes + "m " + seconds + "s ";

                // If the count down is over, write some text
                if (distance < 0) {
                    clearInterval(x);
                    document.getElementById("testTimer").innerHTML = "EXPIRED";
                }
            }, 1000);
        </script>
    </c:if>
</c:if>

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
<!-- js -->
<script src="admin/vendors/scripts/core.js"></script>
<script src="admin/vendors/scripts/script.min.js"></script>
<script src="admin/vendors/scripts/process.js"></script>
<script src="admin/vendors/scripts/layout-settings.js"></script>
</body>
</html>
