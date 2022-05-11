<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-UTF-8">
	<title>Login Page</title>
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
	integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="./css/base.css">
	<link rel="stylesheet" href="./css/grid.css">
	<link rel="stylesheet" href=".css/main.css">
	<link rel="stylesheet" href="./css/login.css">
	<link rel="stylesheet" href="./css/reponsive.css">
	<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;1,300&display=swap"
	rel="stylesheet">
	<script src="https://kit.fontawesome.com/34b7bf6ca8.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<%
	Cookie[] listCookies = request.getCookies();
	String user = "";
	String password = "";
	int idx = 0;
	if (listCookies != null) {
		while (idx < listCookies.length) {
			if (listCookies[idx].getName().equalsIgnoreCase("user")) {
		user = listCookies[idx].getValue();
			}
			if (listCookies[idx].getName().equalsIgnoreCase("password")) {
		password = listCookies[idx].getValue();
			}
			idx++;
		}
	}
	%>

	<header class="login__nav">
		<div class="grid wide">
			<div class="login-nav">
				<img src="./imgs/thanhluu-logo.svg" alt="logo" class="login-logo">
				<a href="index.jsp" class="home-link"><span
					class="login-function">Trang chủ</span></a> <span class="login-help">Bạn
					cần giúp đỡ?</span>

			</div>
		</div>
	</header>
	<div class="login__body">
		<div class="grid wide">
			<div class="login__content">
				<div class="login__content-title">
					<img src="./imgs/thanhluu-logo.svg" alt="logo"
						class="content__logo"> <span class="login__slogan">Nền
						thương mại điện tử yêu thích ở Đông Nam Á và Việt Nam</span>
				</div>
				<div class="login__content-box">
					<span class="login__box-title">Đăng Ký</span>
					<div class="wrap__login">
						<form name="myForm" action="signup" class="myLogin" method="POST"
							onsubmit="return validateForm()">
							<input name="username" class="login__box-username" type="text"
								placeholder="Email/Số điện thoại/ Tên đăng nhập"
								value="<%out.print(user);%>"> <input name="password"
								type="password" class="login__box-pass" placeholder="Mật khẩu"
								value="<%out.print(password);%>">
							<p class="message">${error}</p>
							<input type="submit" class="login__box-btn btn" value="ĐĂNG KÝ">

						</form>
						<div class="login__box-help">
							<a href="" class="forgot-pass">Quên mật khẩu</a> <a href=""
								class="login-by-sms">Đăng nhập bằng SMS</a>
						</div>
						<div class="login__box-sperate">
							<div class="downline"></div>
							<span class="sperate">HOẶC</span>
							<div class="downline"></div>
						</div>
						<div class="login__box-ways">
							<button class="btn login-btn">
								<div class="login-btn-icon login-btn-icon--fb"></div>
								<span class="login-btn-fb-title">Facebook</span>
							</button>
							<button class="btn login-btn">
								<div class="login-btn-icon login-btn-icon--gg"></div>
								<span class="login-btn-gg-title">Google</span>
							</button>
							<button class="btn login-btn">
								<div class="login-btn-icon login-btn-icon--ap"></div>
								<span class="login-btn-ap-title">Apple</span>
							</button>
						</div>
					</div>
					<span class="login_register">Bạn đã có tài khoản? <a
						href="login.jsp" class="login_register-link">Đăng nhập</a></span>
				</div>
			</div>
		</div>
	</div>
	<script src="./js/javascript.js"></script>
</body>
</html>