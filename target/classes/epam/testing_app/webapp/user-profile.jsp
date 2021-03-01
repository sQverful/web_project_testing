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
								<h4>Profile</h4>
							</div>
							<nav aria-label="breadcrumb" role="navigation">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/controller?command=showMainPage">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Profile</li>
								</ol>
							</nav>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 mb-30">
						<div class="pd-20 card-box height-100-p">
							<div class="profile-photo">
								<img src="admin/vendors/images/photo1.jpg" alt="" class="avatar-photo">
							</div>
							<h5 class="text-center h5 mb-0">${user.login}</h5>
							<p class="text-center text-muted font-14">${user.name} ${user.surname}</p>
							<div class="profile-info">
								<h5 class="mb-20 h5 text-blue">Registration Information</h5>
								<ul>
									<li>
										<span>Email Address:</span>
										${user.email}
									</li>
									<li>
										<span>Login:</span>
										${user.login}
									</li>
									<li>
										<span>Name:</span>
										${user.name}
									</li>
									<li>
										<span>Surname:</span>
										${user.surname}
									</li>
									<li>
										<span>Registration date:</span>
										${user.createTime}
									</li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 mb-30">
						<div class="card-box height-100-p overflow-hidden">
							<div class="profile-tab height-100-p">
								<div class="tab height-100-p">
									<ul class="nav nav-tabs customtab" role="tablist">
										<li class="nav-item">
											<a class="nav-link active" data-toggle="tab" href="#testResults" role="tab">Test results</a>
										</li>
										<li class="nav-item">
											<a class="nav-link" data-toggle="tab" href="#updateUser" role="tab">Change registration info</a>
										</li>
									</ul>
									<div class="tab-content">
										<!-- Test results Tab start -->
										<div class="tab-pane fade show active" id="testResults" role="tabpanel">
											<div class="pd-20">
												<div class="card-box mb-30">
													<div class="pd-20">
														<h4 class="text-blue h4">Results table</h4>
													</div>
													<div class="pb-20">
														<table class="data-table table stripe hover nowrap">
															<thead>
															<tr>
																<th>№</th>
																<th>Subject name</th>
																<th>Test name</th>
																<th>Create time</th>
																<th>Result</th>
																<th class="datatable-nosort">Action</th>
															</tr>
															</thead>
															<tbody>

															<c:set var="counter" value="0" scope="page"/>
															<c:forEach var="testResult" items="${testResultList}">
															<c:forEach var="subject" items="${subjectList}">
															<c:forEach var="test" items="${testsList}">

															<tr>
																<c:if test="${testResult.testId == test.id}">
																<c:if test="${subject.id == test.subjectId}">

																<c:set var="counter" value="${counter + 1}" scope="page"/>
																	<td>${counter}</td>
																	<td>${test.subjectId == subject.id ? subject.nameEN : ""}</td>
																	<td>${testResult.testId == test.id ? test.nameEN : ""}</td>
																	<td>${testResult.createdOn}</td>
																	<td>${testResult.result}</td>
																	<td>
																		<div class="dropdown">
																			<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
																				<i class="dw dw-more"></i>
																			</a>
																			<form action="controller" method="post" class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
																				<div class="dropdown-item">
																					<a class="btn" href="controller?command="><i class="fa-question-circle"></i> See detailed result</a>
																				</div>
																				<div class="dropdown-item">
																					<a class="btn" href="controller?command="><i class="dw dw-edit2"></i> Pass test one more time</a>
																				</div>
																			</form>
																		</div>
																	</td>
																</c:if>
																</c:if>
															</tr>
															</c:forEach>
															</c:forEach>
															</c:forEach>
															</tbody>
														</table>
													</div>
												</div>

											</div>
										</div>
										<!-- Test results Tab End -->
										<!-- Tasks Tab start -->
										<div class="tab-pane fade" id="updateUser" role="tabpanel">
											<div class="pd-20 profile-task-wrap">
												<div class="container pd-0">
													<!-- Open Task start -->
													<div class="task-title row align-items-center">
														<div class="col-md-8 col-sm-12">
															<h5>Update registration info</h5>
														</div>
													</div>
													<div class="pd-20 card-box mb-30">
														<form  accept-charset="UTF-8" action="controller" method="post" enctype="multipart/dorm-data">
															<input type="hidden" name="command" value="updateUser"/>
															<input type="hidden" name="id" value="${user.id}"/>
															<input type="hidden" name="blocked" value=""/>
															<input class="form-control" value='${user.roleId}' type="hidden" name="role_id">

															<div class="form-group row">
																<label class="col-sm-12 col-md-2 col-form-label">Login</label>
																<div class="col-sm-12 col-md-10">
																	<input class="form-control" value="${user.login}" type="text" name="login" disabled="disabled">
																</div>
															</div>
															<div class="form-group row">
																<label class="col-sm-12 col-md-2 col-form-label">Name</label>
																<div class="col-sm-12 col-md-10">
																	<input class="form-control" type="text" value="${user.name}" name="name">
																</div>
															</div>
															<div class="form-group row">
																<label class="col-sm-12 col-md-2 col-form-label">Surname</label>
																<div class="col-sm-12 col-md-10">
																	<input class="form-control" value="${user.surname}" type="text" name="surname">
																</div>
															</div>
															<div class="form-group row">
																<label class="col-sm-12 col-md-2 col-form-label">E-mail</label>
																<div class="col-sm-12 col-md-10">
																	<input class="form-control" value="${user.email}" type="email" name="email">
																</div>
															</div>
															<div class="form-group row">
																<label class="col-sm-12 col-md-2 col-form-label">Password</label>
																<div class="col-sm-12 col-md-10">
																	<input class="form-control" value="${user.password}" type="password" name="password"></textarea>
																</div>
															</div>
															<button type="submit" class="btn btn-primary">Update info</button>
														</form>

													</div>

												</div>
											</div>
										</div>
										<!-- Tasks Tab End -->
									</div>
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
	<script src="admin/src/plugins/cropperjs/dist/cropper.js"></script>
</body>
</html>