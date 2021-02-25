<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 21.02.2021
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                        <h4 class="text-blue h4">Edit test ID ${test.id}</h4>
                    </div>
                </div>

                <%--Adding new test form starts--%>
                <form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                    <input type="hidden" name="command" value="updateTest">
                    <input type="hidden" name="id" value="${test.id}">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Select Subject</label>
                                <select class="custom-select2 form-control" name="subject_id" style="width: 100%; height: 38px;">
                                    <optgroup label="Subjects">
                                        <c:forEach var="subject" items="${subjectList}">
                                            <option value="${subject.id}" ${test.subjectId==subject.id ? "selected" : ""}>${subject.nameEN}</option>
                                        </c:forEach>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Name ua</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="text" value="${test.nameUA}" name="name_ua">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Name eng</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${test.nameEN}" type="text" name="name_en">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Complexity</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${test.complexity}" type="text" name="complexity">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Blocked</label>
                        <div class="col-sm-12 col-md-10">
                            <input type="checkbox" class="switch-btn" data-color="#f56767" name="blocked" ${test.blocked==true ? "checked" : ""}>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Timer</label>
                        <div class="form-group">
                            <label>Time in minutes</label>
                            <input id="demo_vertical2" type="text" value="${test.timer}" name="timer">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Description ua</label>
                        <div class="col-sm-12 col-md-10">
                            <textarea class="form-control" name="description_ua">${test.descriptionUA}</textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Description eng</label>
                        <div class="col-sm-12 col-md-10">
                            <textarea class="form-control" name="description_en">${test.descriptionEN}</textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Edit test</button>
                </form>
                <%--Adding new test form ends--%>
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
