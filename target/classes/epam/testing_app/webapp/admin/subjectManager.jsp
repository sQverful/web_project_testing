<!DOCTYPE html>
<html>
<head>
	<!-- Basic Page Info -->
	<meta charset="utf-8">
	<title>Admin panel</title>

	<!-- Site favicon -->
	<link rel="apple-touch-icon" sizes="180x180" href="../vendors/images/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="../vendors/images/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="../vendors/images/favicon-16x16.png">

	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- Google Font -->
	<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
	<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="../vendors/styles/core.css">
	<link rel="stylesheet" type="text/css" href="../vendors/styles/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="../vendors/styles/style.css">
	<link rel="stylesheet" type="text/css" href="../src/plugins/datatables/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet" type="text/css" href="../src/plugins/datatables/css/responsive.bootstrap4.min.css">


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
							<img src="../vendors/images/photo1.jpg" alt="">
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
			<div class="page-header">
				<div class="row">
					<div class="col-md-6 col-sm-12">
						<div class="title">
							<h4>Form</h4>
						</div>
						<nav aria-label="breadcrumb" role="navigation">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="index.html">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Form Basic</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
			<!-- Default Basic Forms Start -->
			<div class="pd-20 card-box mb-30">
				<div class="clearfix">
					<div class="pull-left">
						<h4 class="text-blue h4">Adding new subject</h4>
						<p class="mb-30">Fill all fields below</p>
					</div>
				</div>
				<form accept-charset="UTF-8" action="addSubject" method="post" enctype="multipart/dorm-data">
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

				<br>
				<br>
				<br>
				<!-- Simple Datatable start -->
				<div class="card-box mb-30">
					<div class="pd-20">
						<h4 class="text-blue h4">Subjects table</h4>
						<p class="mb-0">you can find more options <a class="text-primary" href="https://datatables.net/" target="_blank">Click Here</a></p>
					</div>
					<div class="pb-20">
						<table class="data-table table stripe hover nowrap">
							<thead>
							<tr>
								<th class="table-plus datatable-nosort">ID</th>
								<th>Name ua</th>
								<th>Name en</th>
								<th>Description</th>
								<th>Create time</th>
								<th class="datatable-nosort">Action</th>
							</tr>
							</thead>
							<tbody>
							<tr>
								<td class="table-plus">Gloria F. Mead</td>
								<td>25</td>
								<td>Sagittarius</td>
								<td>2829 Trainer Avenue Peoria, IL 61602 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Gemini</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>20</td>
								<td>Gemini</td>
								<td>2829 Trainer Avenue Peoria, IL 61602 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Sagittarius</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>25</td>
								<td>Gemini</td>
								<td>2829 Trainer Avenue Peoria, IL 61602 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>20</td>
								<td>Sagittarius</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>18</td>
								<td>Gemini</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Sagittarius</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Sagittarius</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Gemini</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Gemini</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="table-plus">Andrea J. Cagle</td>
								<td>30</td>
								<td>Gemini</td>
								<td>1280 Prospect Valley Road Long Beach, CA 90802 </td>
								<td>29-03-2018</td>
								<td>
									<div class="dropdown">
										<a class="btn btn-link font-24 p-0 line-height-1 no-arrow dropdown-toggle" href="#" role="button" data-toggle="dropdown">
											<i class="dw dw-more"></i>
										</a>
										<div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
											<a class="dropdown-item" href="#"><i class="dw dw-eye"></i> View</a>
											<a class="dropdown-item" href="#"><i class="dw dw-edit2"></i> Edit</a>
											<a class="dropdown-item" href="#"><i class="dw dw-delete-3"></i> Delete</a>
										</div>
									</div>
								</td>
							</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- Simple Datatable End -->

				<br>
				<br>
				<br>
				<br>
				<br>
				<br>

				<form>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Text</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" type="text" placeholder="Johnny Brown">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Search</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" placeholder="Search Here" type="search">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Email</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="bootstrap@example.com" type="email">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">URL</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="https://getbootstrap.com" type="url">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Telephone</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="1-(111)-111-1111" type="tel">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Password</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="password" type="password">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Number</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="100" type="number">
						</div>
					</div>
					<div class="form-group row">
						<label for="example-datetime-local-input" class="col-sm-12 col-md-2 col-form-label">Date and time</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control datetimepicker" placeholder="Choose Date anf time" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Date</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control date-picker" placeholder="Select Date" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Month</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control month-picker" placeholder="Select Month" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Time</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control time-picker" placeholder="Select time" type="text">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Select</label>
						<div class="col-sm-12 col-md-10">
							<select class="custom-select col-12">
								<option selected="">Choose...</option>
								<option value="1">One</option>
								<option value="2">Two</option>
								<option value="3">Three</option>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Color</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="#563d7c" type="color">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-12 col-md-2 col-form-label">Input Range</label>
						<div class="col-sm-12 col-md-10">
							<input class="form-control" value="50" type="range">
						</div>
					</div>
				</form>
				</code></pre>
			</div>
		</div>
	</div>
	<!-- Default Basic Forms End -->


</div>
<div class="footer-wrap pd-20 mb-20 card-box">
	DeskApp - Bootstrap 4 Admin Template By <a href="https://github.com/dropways" target="_blank">Ankit Hingarajiya</a>
</div>
</div>
</div>
<!-- js -->
<script src="../vendors/scripts/core.js"></script>
<script src="../vendors/scripts/script.min.js"></script>
<script src="../vendors/scripts/process.js"></script>
<script src="../vendors/scripts/layout-settings.js"></script>
</body>
</html>