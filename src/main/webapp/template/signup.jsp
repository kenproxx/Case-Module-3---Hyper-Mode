<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Player Dou</title>
    <link href="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/login.css">
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 login-section-wrapper">
            <div class="brand-wrapper">
            </div>
            <div class="login-wrapper my-auto">
                <h1 class="login-title">Đăng ký tài khoản</h1>
                <form method="post" name="userForm" onsubmit="return validate();">
                    <div class="form-group">
                        <input type="text" name="firstName" class="form-control" placeholder="Tên">
                        <div id="firstNameError"></div>
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" name="lastName"  class="form-control" placeholder="Họ và tên">
                        <div id="lastNameError"></div>
                    </div>
                    <div class="form-group">
                        <select name="gender" class="form-control">
                            <option disabled="disabled" selected="selected" value="-1">Giới tính</option>
                            <option value="1">Nam</option>
                            <option value="0">Nữ</option>
                        </select>
                        <div id="genderError"></div>
                    </div>
                    <div class="form-group mb-4">
                        <input type="date" class="form-control"  placeholder="Ngày sinh" name="dateOfBirth">
                        <div id="dateOfBirthError"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Số điện thoại" name="phoneNumber" class="form-control">
                        <div id="phoneNumberError"></div>
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" placeholder="Email" name="email" class="form-control">
                        <div id="emailError"></div>
                    </div>
                    <div class="form-group">
                        <input type="text" placeholder="Tên đăng nhập" name="username" class="form-control">
                        <div id="usernameError"></div>
                    </div>
                    <div class="form-group mb-4">
                        <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
                        <div id="passwordError"></div>
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Nhập lại mật khẩu" name="repassword" class="form-control">
                        <div id="repasswordError"></div>
                    </div>
                    <div class="form-group mb-4">
                        <input type="text" placeholder="Địa chỉ" name="address" class="form-control">
                        <div id="addressError"></div>
                    </div>
                    <input name="register" class="btn btn-block login-btn" type="submit" value="Đăng ký">
                </form>
                <c:if test='${message != null}'>
                    <span style="font-size: 20px; color: black">${message}</span>
                </c:if>
                <a href="/home" class="forgot-password-link">Quay về trang chủ</a>
            </div>
        </div>
        <div class="col-sm-6 px-0 d-none d-sm-block">
            <img src="/resources/assets/images/login.jpg" alt="login image" class="login-img">
        </div>
    </div>
</div>

</body>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="resources/js/validateUserFromClient.js"></script>

</html>