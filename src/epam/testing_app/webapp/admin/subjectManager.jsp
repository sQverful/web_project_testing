<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>Admin panel</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="vendors/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="vendors/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="vendors/images/favicon-16x16.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendors/styles/style.css">
	<link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="src/plugins/datatables/css/responsive.bootstrap4.min.css">


	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-119386393-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());

		gtag('config', 'UA-119386393-1');
	</script>
</head>
<body>

<div class="header">
	<div class="header-left">
	</div>
	<div class="header-right">
		<div class="dashboard-setting user-notification">
			<div class="dropdown">
				<a class="dropdown-toggle no-arrow" href="javascript:;" data-toggle="right-sidebar">
					<i class="dw dw-settings2"></i>
				</a>
			</div>
		</div>
		<div class="user-info-dropdown">
			<div class="dropdown">
				<a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="vendors/images/photo1.jpg" alt="">
						</span>
					<span class="user-name">Ross C. Lopez</span>
				</a>
				<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
					<a class="dropdown-item" href="profile.html"><i class="dw dw-user1"></i> Profile</a>
					<a class="dropdown-item" href="profile.html"><i class="dw dw-settings2"></i> Setting</a>
					<a class="dropdown-item" href="faq.html"><i class="dw dw-help"></i> Help</a>
					<a class="dropdown-item" href="../login.html"><i class="dw dw-logout"></i> Log Out</a>
				</div>
			</div>
		</div>

	</div>
</div>

<%@ include file="left-side-bar.html"%>
<div class="mobile-menu-overlay"></div>

<div class="main-container">
	<div class="pd-ltr-20 xs-pd-20-10">
		<div class="min-height-200px">
			<%--Modal window starts--%>
			<div class="pd-20 card-box height-100-p">
				<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#bd-example-modal-lg" type="button">Create new subject</a>
				<div class="modal fade bs-example-modal-lg" id="bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg modal-dialog-centered">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="text-blue h4">Creating new subject</h4>
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							</div>
							<div class="modal-body">
								<%--Adding new subject form starts--%>
									<form accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
										<input type="hidden" name="command" value="addNewSubject">
										<div class="form-group row">
											<label class="col-sm-12 col-md-2 col-form-label">Your admin ID</label>
											<div class="col-sm-12 col-md-10">
												<input class="form-control" type="text" value="${user.id}" name="adminId" disabled="disabled">
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
										<button type="submit" class="btn btn-primary">Add subject</button>
									</form>
								<%--Adding new subject form ends--%>
							</div>
						</div>
					</div>
				</div>
			</div>
				<%--Modal window ends--%>
				<!-- Simple Datatable start -->
				<div class="card-box mb-30">
					<div class="pd-20">
						<h4 class="text-blue h4">Subjects table</h4>
					</div>
					<div class="pb-20">
						<table class="data-table table stripe hover nowrap">
							<thead>
							<tr>
								<th>ID</th>
								<th>Name ua</th>
								<th>Name en</th>
								<th>Description UA</th>
								<th>Description EN</th>
								<th>Admin ID</th>
								<th>Create time</th>
								<th class="datatable-nosort">Action</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach var="subject" items="${subjectList}">
							<tr>
								<td><c:out value="${subject.id}"/></td>
								<td><c:out value="${subject.nameUA}"/></td>
								<td><c:out value="${subject.nameEN}"/></td>
								<td><c:out value="${subject.descriptionUA}"/></td>
								<td><c:out value="${subject.descriptionEN}"/></td>
								<td><c:out value="${subject.adminId}"/></td>
								<td><c:out value="${subject.createdOn}"/></td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<div class="dropdown-item">
												<a class="btn" href="controller?command=showSubjectEditForm&id=${subject.id}"><i class="dw dw-edit2"></i> Edit</a>
											</div>
											<input type="hidden" name="id" value="${subject.id}">
											<input type="hidden" name="command" value="deleteSubject">
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