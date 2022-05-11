<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Header Page</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
	integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://kit.fontawesome.com/34b7bf6ca8.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/grid.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet" href="./css/reponsive.css">

<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,400;0,500;0,700;1,300&display=swap"
	rel="stylesheet">

</head>

<body>
	<header class="header">
		<div class="grid wide header_wrap">
			<nav class="header__navbar hide-on-mobile-tablet">
				<ul class="header__navbar-list">
					<li class="header__navbar-item header__navbar-item--seperate">Mở
						ứng dụng cửa hàng MY LIFE</li>
					<li class="header__navbar-item"><span class="title-noselect">Kết
							nối</span> <a href="" class="header__navbar-icon-link"><i
							class="fa-brands fa-facebook"></i></a> <a href=""
						class="header__navbar-icon-link"><i
							class="fa-brands fa-instagram"></i></a></li>
				</ul>
				<ul class="header__navbar-list">
					<li class="header__navbar-item"><a href=""
						class="header__navbar-item-link"> <i class="fa-solid fa-bell"></i>
							Thông báo
					</a></li>
					<li class="header__navbar-item"><a href=""
						class="header__navbar-item-link"> <i
							class="fa-solid fa-circle-question"></i> Trợ giúp
					</a></li>
					<li class="header__navbar-item"><a
						href=${empty user ? '/MVC/signup.jsp' : '#' }
						class="header__navbar-item-link header__navbar-item-link--strong header__navbar-item--seperate">${empty user ? 'Đăng Ký' : user }</a></li>
					<li class="header__navbar-item"><a
						href=${empty user ? '/MVC/login.jsp' : 'logout?logout=ok' }
						class="header__navbar-item-link header__navbar-item-link--strong">${empty user ? 'Đăng Nhập' : 'Thoát' }</a></li>
				</ul>
			</nav>
			<div class="header-with-search">
				<!-- For menu on mobile and tablet -->

				<input type="checkbox" id="header-with-mobile-menu" hidden
					class="header__menu-mobile-checkbox"> <label
					for="header-with-mobile-menu"> <i
					class="header__menu-mobile-icon fa-solid fa-bars"></i>
				</label> <label for="header-with-mobile-menu" class="ovelay"></label>
				<div class="header__menu">
					<label for="header-with-mobile-menu"> <i
						class="fa-solid fa-circle-xmark menu__close-icon"></i>
					</label>
					<ul class="header__menu-list">

						<li class="header__menu-item"><a href="./index.jsp"
							class="header__menu-item-link header__menu-item-link--strong">
								<i class="header__menu-icon fa-solid fa-house-user"></i> Trang
								chủ
						</a></li>
						<!-- 						<li class="header__menu-item"><a href="./signup.jsp"
<!-- 							class="header__menu-item-link header__menu-item-link--strong"> -->
						<!-- 								<i class="header__menu-icon fa-solid fa-user-pen"></i> Đăng ký -->
						<!-- 						</a></li> -->
						-->
						<li class="header__navbar-item"><a href=#
							class="header__navbar-item-link header__navbar-item-link--strong header__navbar-item--seperate">${empty session.getAttribute("user") ? 'Đăng Ký' : session.getAttribute("user") }</a></li>
						<li class="header__menu-item"><a href="./login.jsp"
							class="header__menu-item-link header__menu-item-link--strong">
								<i class="header__menu-icon fa-solid fa-user-lock"></i> Đăng
								nhập
						</a></li>
					</ul>
				</div>
				<!-- For Search box on mobile -->
				<input type="checkbox" id="header-with-mobile-search" hidden
					class=header__search-mobile-checkbox> <label
					for="header-with-mobile-search"> <i
					class="header__search-mobile-icon fa-solid fa-magnifying-glass"></i>
				</label>
				<div class="header__logo hide-on-tablet">
					<a href="/MVC"><img src="./imgs/thanhluu-logo.svg" alt=""
						class="header__logo-img"></a>
				</div>
				<!-- For Search box on tablet and PC -->
				<form class="header__search" action="SearchController" method="POST">
					<input name="search" type="text" class="header__search-input"
						placeholder="Nhập tìm kiếm sản phẩm" value=${empty name ? '' : name }>
					<div class="header__search-select">
						<span class="header__search-title">Trong Shop</span> <i
							class="header__search-icon fa-solid fa-sort-down"></i>
					</div>
					<button class="header__search-btn" type="submit">
						<i class="header__search-btn-icon fa-solid fa-magnifying-glass"></i>
					</button>
				</form>
				<div class="header__cart">
					<a class="header__cart-wrap" href="/MVC/cart.jsp"> <i
						class="header__cart-icon fa-solid fa-cart-shopping"></i> <!-- <div class="header__cart-list header__cart-list--no-cart">
                                <img src="./imgs/no-cart.png" alt="" class="cart__no-cart">
                                <span class="cart__no-cart-title">Chưa có sản phẩm nào</span>
                            </div> -->
					</a>
				</div>
			</div>
		</div>
		<ul class="header__sort-bar ">
			<li class="header__sort-item"><a href=""
				class="header__sort-link">Liên quan</a></li>
			<li class="header__sort-item "><a href=""
				class="header__sort-link header__sort-item--active">Mới nhất</a></li>
			<li class="header__sort-item"><a href=""
				class="header__sort-link">Bán chạy</a></li>
			<li class="header__sort-item"><a href=""
				class="header__sort-link">Giá</a></li>
		</ul>
	</header>
	<%-- </body>

    </html>
    --%>