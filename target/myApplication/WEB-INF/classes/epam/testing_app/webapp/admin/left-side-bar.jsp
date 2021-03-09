<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="left-side-bar">
	<div class="brand-logo">
		<a href="${pageContext.request.contextPath}/controller?command=adminPage">
			<img src="${pageContext.request.contextPath}/admin/vendors/images/deskapp-logo.svg" alt="" class="dark-logo">
			<img src="${pageContext.request.contextPath}/admin/vendors/images/deskapp-logo-white.svg" alt="" class="light-logo">
		</a>
		<div class="close-sidebar" data-toggle="left-sidebar-close">
			<i class="ion-close-round"></i>
		</div>
	</div>
	<div class="menu-block customscroll">
		<div class="sidebar-menu">
			<ul id="accordion-menu">
				<li class="dropdown">
					<a href="javascript:;" class="dropdown-toggle">
						<span class="micon dw dw-edit2"></span><span class="mtext">Editor</span>
					</a>
					<ul class="submenu">
						<li><a href="controller?command=subjectList">Subjects</a></li>
						<li><a href="controller?command=testList">Tests</a></li>
						<li><a href="controller?command=userList">Users</a></li>
					</ul>
				</li>
				<li>
					<a href="https://dropways.github.io/deskapp-free-single-page-website-template/" target="_blank" class="dropdown-toggle no-arrow">
						<span class="micon dw dw-paper-plane1"></span>
						<span class="mtext">Landing Page</span>
					</a>
				</li>
			</ul>
		</div>
	</div>
</div>