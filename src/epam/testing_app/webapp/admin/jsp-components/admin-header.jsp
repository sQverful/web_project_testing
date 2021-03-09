<%--
  Created by IntelliJ IDEA.
  User: Dorosh
  Date: 25.02.2021
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="header">
    <div class="header-left">
        <a class="menu-icon dw dw-menu" data-toggle="left-side-bar"></a>
    </div>
    <div class="header-right">
        <div class="user-info-dropdown">
            <div class="dropdown">
                <a class="dropdown-toggle" href="#" role="button" data-toggle="dropdown">
						<span class="user-icon">
							<img src="${pageContext.request.contextPath}/admin/vendors/images/photo1.jpg" alt="">
						</span>
                    <span class="user-name">${user.login}</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-menu-icon-list">
                    <a class="dropdown-item" href="#"><i class="dw dw-help"></i> Help</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/controller?command=logout"><i class="dw dw-logout"></i> Log Out</a>
                </div>
            </div>
        </div>
        <div class="github-link">
            <a href="https://github.com/sQverful/web_project_testing" target="_blank"><img src="vendors/images/github.svg" alt=""></a>
        </div>
    </div>
</div>
