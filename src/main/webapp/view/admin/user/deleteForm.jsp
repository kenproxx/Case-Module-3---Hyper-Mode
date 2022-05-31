<%--
  Created by IntelliJ IDEA.
  User: MY PC
  Date: 30/05/2022
  Time: 11:36 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Stellar Admin</title>
    <link rel="stylesheet" href="resources/vendors/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="resources/vendors/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="resources/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/vendors/select2/select2.min.css">
    <link rel="stylesheet" href="resources/vendors/select2-bootstrap-theme/select2-bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="shortcut icon" href="resources/images/favicon.png"/>
</head>
<body>
<div class="container-scroller">
    <%--header--%>
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="navbar-brand-wrapper d-flex align-items-center">
            <a class="navbar-brand brand-logo" href="/dashboard">
                <img src="${pageContext.request.contextPath}/resources/images/icons/logo.png" alt="logo" class="logo-dark"/>
            </a>
            <a class="navbar-brand brand-logo-mini" href="/dashboard"><img
                    src="${pageContext.request.contextPath}/resources/images/icons/logo.png"
                    alt="logo"/></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-center flex-grow-1">
            <h5 class="mb-0 font-weight-medium d-none d-lg-flex">Welcome Player Duo dashboard!</h5>
            <ul class="navbar-nav navbar-nav-right ml-auto">
                <form class="search-form d-none d-md-block" action="#">
                    <i class="icon-magnifier"></i><input type="search" class="form-control" placeholder="Tìm kiếm" title="Search here">
                </form>
                <li class="nav-item dropdown d-none d-xl-inline-flex user-dropdown">
                    <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown"
                       aria-expanded="false">
                        <img class="img-xs rounded-circle ml-2"
                             src="${pageContext.request.contextPath}/template/img/team-kien.jpg"
                             alt="Profile image">
                        <span class="font-weight-normal"> Admin </span></a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                        <div class="dropdown-header text-center">
                            <img class="img-md rounded-circle"
                                 src="${pageContext.request.contextPath}/template/img/anhson.jpg"
                                 alt="Profile image">
                            <p class="mb-1 mt-3">Admin</p>
                        </div>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-user text-primary"></i> My Profile
                            <span class="badge badge-pill badge-danger">1</span></a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-speech text-primary"></i>
                            Messages</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-energy text-primary"></i>
                            Activity</a>
                        <a class="dropdown-item"><i class="dropdown-item-icon icon-question text-primary"></i> FAQ</a>
                        <a href="/login" class="dropdown-item"><i class="dropdown-item-icon icon-power text-primary"></i>Sign Out</a>
                    </div>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                    data-toggle="offcanvas">
                <span class="icon-menu"></span>
            </button>
        </div>
    </nav>
    <%--left menu--%>
    <div class="container-fluid page-body-wrapper">
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                        <div class="profile-image">
                            <img class="img-xs rounded-circle"
                                 src="${pageContext.request.contextPath}/template/img/anhson.jpg"
                                 alt="profile image">
                            <div class="dot-indicator bg-success"></div>
                        </div>
                        <div class="text-wrapper">
                            <p class="profile-name">Lê Văn Sơn</p>
                            <p class="designation">Administrator</p>
                        </div>
                        <div class="icon-container">
                            <i class="icon-bubbles"></i>
                            <div class="dot-indicator bg-danger"></div>
                        </div>
                    </a>
                </li>
                <li class="nav-item nav-category">
                    <span class="nav-link">Dashboard</span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/dashboard">
                        <span class="menu-title">Dashboard</span>
                        <i class="icon-screen-desktop menu-icon"></i>
                    </a>
                </li>
                <li class="nav-item nav-category"><span class="nav-link">Cửa hàng</span></li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#brand" aria-expanded="false"
                       aria-controls="brand">
                        <span class="menu-title">Quản lý Nhà cung cấp</span>
                        <i class="icon-grid menu-icon"></i>
                    </a>

                    <div class="collapse" id="brand">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=view_catalog">Xem danh mục</a></li>
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=create_catalog">Thêm danh mục</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#bill" aria-expanded="false"
                       aria-controls="bill">
                        <span class="menu-title">Quản lý hóa đơn</span>
                        <i class="icon-note menu-icon"></i>
                    </a>
                    <div class="collapse" id="bill">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"> <a class="nav-link" href="/admin?action=view_bill">Xem hóa đơn</a></li>
                        </ul>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#user" aria-expanded="false"
                       aria-controls="user">
                        <span class="menu-title">Quản lý người dùng</span>
                        <i class="icon-user menu-icon"></i>
                    </a>
                    <div class="collapse" id="user">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item"> <a class="nav-link" href="/user?action=view_user">Xem người dùng</a></li>
                            <li class="nav-item"> <a class="nav-link" href="/user?action=create_user">Thêm người dùng</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </nav>
        <%--content--%>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Chi tiết tài khoản </h3>
                </div>
                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <form method="post" class="form-sample">
                                    <p class="card-description"> Thông tin cá nhân </p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Tên</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="firstName" class="form-control" value="${user.getFirstName()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Họ và tên đệm</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="lastName" class="form-control" value="${user.getLastName()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Giới tính</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="gender">
                                                        <c:set var="gender" value="${user.getGender()}"/>
                                                        <c:choose>
                                                            <c:when test="${role == 2}">
                                                                <option name="user" value="1" disabled>Người dùng</option>
                                                                <option name="admin" value="2" selected disabled>Admin</option>
                                                                <option name="vipUser" value="3" disabled>Người dùng VIP 1</option>
                                                            </c:when>
                                                            <c:when test="${role == 1}">
                                                                <option name="user" value="1" selected disabled>Người dùng</option>
                                                                <option name="admin" value="2" disabled>Admin</option>
                                                                <option name="vipUser" value="3" disabled>Người dùng VIP 1</option>
                                                            </c:when>
                                                            <c:when test="${role == 3}">
                                                                <option name="user" value="1" disabled>Người dùng</option>
                                                                <option name="admin" value="2" disabled>Admin</option>
                                                                <option name="vipUser" value="3" selected disabled>Người dùng VIP 1</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Ngày sinh</label>
                                                <div class="col-sm-9">
                                                    <input type="date" class="form-control" name="dateOfBirth" value="${user.getDateOfBirth()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Số điện thoại</label>
                                                <div class="col-sm-9">
                                                    <input type="number" class="form-control" name="phone" value="${user.getPhone()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Email</label>
                                                <div class="col-sm-9">
                                                    <input type="email" class="form-control" name="email" value="${user.getEmail()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Tên đăng nhập</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" name="username" value="${user.getUsername()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Mật khẩu</label>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" name="password" value="${user.getPassword()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Loại tài khoản</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="role">
                                                        <c:set var="role" value="${user.getRoleId()}"/>
                                                        <c:choose>
                                                            <c:when test="${role == 2}">
                                                                <option name="user" value="1" disabled>Người dùng</option>
                                                                <option name="admin" value="2" selected disabled>Admin</option>
                                                            </c:when>
                                                            <c:when test="${role == 1}">
                                                                <option name="user" value="1" selected disabled>Người dùng</option>
                                                                <option name="admin" value="2" disabled>Admin</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Trạng thái</label>
                                                <div class="col-sm-9">
                                                    <select class="form-control" name="status">
                                                        <c:set var="status" value="${user.getStatus()}"/>
                                                        <c:choose>
                                                            <c:when test="${status == 1}">
                                                                <option name="admin" value="1" selected disabled>Đang hoạt động</option>
                                                                <option name="user" value="0" disabled>Bị khóa</option>
                                                            </c:when>
                                                            <c:when test="${status == 0}">
                                                                <option name="admin" value="1" disabled>Đang hoạt động</option>
                                                                <option name="user" value="0" selected disabled>Bị khóa</option>
                                                            </c:when>
                                                        </c:choose>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="card-description"> Địa chỉ </p>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group row">
                                                <label class="col-sm-3 col-form-label">Địa chỉ</label>
                                                <div class="col-sm-9">
                                                    <input type="text" name="address" class="form-control" value="${user.getAddress()}" disabled/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div>
                                            <button type="submit" class="btn btn-primary mr-2">Xóa</button>
                                        </div>
                                    </div>
                                    <div class="row" style="margin-top: 20px">
                                        <p>
                                            <c:if test='${message != null}'>
                                                <span style="font-size: 20px" class="badge badge-success">${message}</span>
                                            </c:if>
                                        </p>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="d-sm-flex justify-content-center justify-content-sm-between">
                    <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2020 <a
                            href="https://www.bootstrapdash.com/" target="_blank"></a>. All rights reserved.</span>
                        <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Hand-crafted & made with <i class="icon-heart text-danger"></i></span>
                    </div>
                </footer>
            </div>
        </div>
    </div>
    <script src="resources/vendors/js/vendor.bundle.base.js"></script>
    <script src="resources/vendors/select2/select2.min.js"></script>
    <script src="resources/vendors/typeahead.js/typeahead.bundle.min.js"></script>
    <script src="resources/js/off-canvas.js"></script>
    <script src="resources/js/misc.js"></script>
    <script src="resources/js/typeahead.js"></script>
    <script src="resources/js/select2.js"></script>
</body>
</html>
