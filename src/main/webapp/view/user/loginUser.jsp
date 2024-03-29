<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 29/05/2022
  Time: 12:18 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Player Duo V2.1 Admin</title>
    <link rel="stylesheet" href="/resources/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="/resources/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="/resources/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="/resources/css/style.css"/>
    <link rel="shortcut icon" href="/resources/images/62581209.jpg"/>
</head>
<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row flex-grow">
                <div class="col-lg-4 mx-auto">
                    <div class="auth-form-light text-left p-5">
                        <h6 class="font-weight-light">Sign in to continue</h6>
                        <c:if test="${requestScope.error != null}">
                            <span class="font-weight-light">${requestScope.error}</span>
                        </c:if>
                        <form class="pt-3" method="post">
                            <div class="form-group">
                                <input type="text" name="username" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <input type="password" name="password" class="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password">
                            </div>
                            <div class="mt-3">
                                <input type="submit" class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" value="SIGN IN">
                            </div>
                            <div class="my-2 d-flex justify-content-between align-items-center">
                                <div class="form-check">
                                    <label class="form-check-label text-muted">
                                        <input type="checkbox" class="form-check-input"> Keep me signed in </label>
                                </div>
                                <a href="#" class="auth-link text-black">Forgot password?</a>
                            </div>
                            <div class="my-2 d-flex justify-content-between align-items-center">
                            <a href="/view/user/signup.jsp" class="forgot-password-link">Đăng ký tài khoản</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/resources/vendors/js/vendor.bundle.base.js"></script>
<script src="/resources/js/off-canvas.js"></script>
<script src="/resources/js/misc.js"></script>
</body>
</html>