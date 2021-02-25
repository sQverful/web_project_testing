<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="header-left">
        <a class="menu-icon dw dw-menu" data-toggle="left-side-bar" href="javascript:;"></a>
        <div class="brand-logo">
            <a href="${pageContext.request.contextPath}/controller?command=showMainPage">
                <img src="admin/vendors/images/deskapp-logo.svg" alt="">
            </a>
        </div>
    </div>
    <div class="header-right">
        <div class="user-info-dropdown">
            <div class="dropdown">
                <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="admin/vendors/images/photo1.jpg" alt="">
						</span>
                    <span class="user-name">${user.login}</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/controller?command=userProfile"><i class="dw dw-user1"></i> Profile</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/controller?command=logout"><i class="dw dw-logout"></i> Log Out</a>
                </div>
            </div>
        </div>
        <div class="github-link">
            <a href="https://github.com/sQverful/web_project_testing" target="_blank"><img src="admin/vendors/images/github.svg" alt=""></a>
        </div>
    </div>
</nav>
