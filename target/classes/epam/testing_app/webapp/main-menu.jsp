<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<%@ include file="WEB-INF/jsp/client-head.jsp"%>

<body>

<%@ include file="WEB-INF/jsp/user-navbar.jsp"%>

	<div class="mobile-menu-overlay"></div>

	<div class="main">
		<div class="pd-ltr-20 xs-pd-20-10">
			<div class="min-height-200px">
				<div class="page-header">
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<div class="title">
								<h4>Subjects</h4>
						
							</div>
						</div>
					</div>
				</div>
				<div class="row clearfix">
					<c:forEach var="subject" items="${subjectList}" varStatus="status">
					<div class="col-sm-12 col-md-4 mb-30">
						<div class="card card-box">
							<h5 class="card-header weight-500">${subject.nameEN}</h5>
							<div class="card-body">
								<p class="card-text">${subject.descriptionEN}</p>
								<a href="${pageContext.request.contextPath}/controller?command=subjectPage&id=${subject.id}" class="btn btn-primary btn-sm">See available tests</a>
							</div>
							<div class="card-footer text-muted">
								Created: ${subject.createdOn}
							</div>
							<div class="card-footer text-muted">
								By:
								<button type="button" class="btn btn-outline-dark btn-sm" data-container="body" data-toggle="popover" data-placement="right" data-content="${adminDetails[status.index].email}" title="Contact info">
										${adminDetails[status.index].name} ${adminDetails[status.index].surname}
								</button>
							</div>
						</div>
					</div>
					</c:forEach>
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