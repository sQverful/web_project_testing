<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 18.02.2021
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="jsp-components/admin-head.jsp" %>

<body>
<%@ include file="jsp-components/admin-header.jsp" %>
<%@ include file="left-side-bar.html"%>
<div class="mobile-menu-overlay"></div>

<div class="main-container">
    <div class="pd-ltr-20 xs-pd-20-10">
        <div class="min-height-200px">
            <!-- Default Basic Forms Start -->
            <div class="pd-20 card-box mb-30">
                <div class="clearfix">
                    <div class="pull-left">
                        <h4 class="text-blue h4">Edit subject ID ${subject.id}</h4>
                    </div>
                </div>
                <form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
                    <input type="hidden" name="command" value="updateSubject"/>
                    <input type="hidden" name="id" value="${subject.id}"/>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Name ua</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" type="text" value="${subject.nameUA}" name="name_ua">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Name eng</label>
                        <div class="col-sm-12 col-md-10">
                            <input class="form-control" value="${subject.nameEN}" type="text" name="name_en">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Description ua</label>
                        <div class="col-sm-12 col-md-10">
                            <textarea class="form-control" name="description_ua">${subject.descriptionUA}</textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-12 col-md-2 col-form-label">Description eng</label>
                        <div class="col-sm-12 col-md-10">
                            <textarea class="form-control" name="description_en">${subject.descriptionUA}</textarea>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Edit subject</button>
                </form>
            </div>
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
</body>
</html>
