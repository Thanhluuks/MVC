<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="app">
		<div class="app__container">
			<div class="grid wide">
				<div class="row sm-gutter app__container-1">
					<div class="col l-2 m-0 c-0">
						<nav class="category">
							<h3 class="category__heading">
								<i class="category__heading-icon fa-solid fa-list"></i> Danh mục
							</h3>
							<ul class="category-list">
								<li class="category-item ${search=='apple' ? 'category-item--active' : ''}"><a
									href="/MVC/BrandController?search=apple"
									class="category-item-link">APPLE</a></li>
								<li class="category-item ${search=='samsung' ? 'category-item--active' : ''}"><a
									href="/MVC/BrandController?search=samsung"
									class="category-item-link">SAMSUNG</a></li>
								<li class="category-item ${search=='xiaomi' ? 'category-item--active' : ''}"><a
									href="/MVC/BrandController?search=xiaomi"
									class="category-item-link">XIAOMI</a></li>
							</ul>
						</nav>
					</div>
					<div class="col l-10 m-12 c-12">
						<div class="home__fitler hide-on-mobile-tablet">
							<span class="home__sort-title">Sắp xếp theo</span>
							<button class="btn home__sort-btn">Phổ Biến</button>
							<button class="btn btn--primary home__sort-btn">Mới nhất</button>
							<button class="btn home__sort-btn">Bán chạy</button>
							<div class="home__selection">
								<span class="home__selection-titile">Giá</span> <i
									class="home__selection-icon fa-solid fa-sort-down"></i>
								<ul class="home__selection-list">
									<li class="home__selection-item"><a href=""
										class="home__selection-link">Giá Cao đến thấp</a></li>
									<li class="home__selection-item"><a href=""
										class="home__selection-link">Giá Thấp đến cao</a></li>

								</ul>
							</div>
							<div class="home__sort-page">
								<div class="home__sort-page-num">
									<span class="home__sort-currnum">1</span>/10
								</div>
								<div class="home__sort-control">
									<a href='/MVC/index.jsp?page=${back}'
										class="home__sort-control-link home__sort-control-link--dis">
										<i class="home__sort-control-icon fa-solid fa-angle-left"></i>
									</a> <a href='/MVC/index.jsp?page=${next}' class="home__sort-control-link"> <i
										class="home__sort-control-icon fa-solid fa-angle-right"></i>
									</a>
								</div>
							</div>
						</div>
						<!-- <nav class="mobile-category">
							<ul class="mobile-category-list">
								<li class="mobile-category-item "><a href="/MVC/BrandController?search=apple"
									class="mobile-category-item-link">APPLE</a></li>
								<li class="mobile-category-item"><a href="/MVC/BrandController?search=samsung"
									class="mobile-category-item-link">SAMSUNG</a></li>
								<li class="mobile-category-item"><a href="/MVC/BrandController?search=xiaomi"
									class="mobile-category-item-link">XIAOMI</a></li>
							</ul>
						</nav> -->
						<div class="home__product">
							<div class="row sm-gutter">
								<c:if test="${empty products }">
									<h2 style="color: red">Chúng tôi không có sản phẩm này.
										Vui lòng tìm kiếm lại.</h2>
								</c:if>
								<%--A product item --%>
								<c:forEach var="product" items="${products}">
									<div class="col l-2-4 m-4 c-6">
										<a class="home__product-item"
											href="/MVC/InformationProductController?id=${product.getId()}">
											<div class="home__product-item-img"
												style="background-image: url('${product.getSrc()}');"></div>
											<h4 class="home__product-content">${product.getName() }</h4>
											<div class="home__product-price">
												<span class="home__product-price-old">${product.getPrice() }
													$</span> <span class="home__product-price-curr">${product.getPrice() }
													$</span>
											</div>
											<div class="home__product-action">
												<span class="home__product-like home__product-like--liked ">
													<i class="home__product-like-icon fa-regular fa-heart"></i>
													<i class="home__product-liked-icon fa-solid fa-heart"></i>
												</span>
												<div class="home__product-rating">
													<i class="home__product-rating-icon fa-solid fa-star"></i>
													<i class="home__product-rating-icon fa-solid fa-star"></i>
													<i class="home__product-rating-icon fa-solid fa-star"></i>
													<i class="fa-solid fa-star"></i> <i
														class="fa-solid fa-star"></i>
												</div>
												<span class="home__product-action-sold">Đã bán 99+</span>
											</div>
											<div class="home__product-origin">
												<span class="home__product-brand">${product.getBrand() }</span>
												<span class="home__product-country">USA</span>
											</div>
											<div class="home__product-fav">
												<span class="home__product-fav-title"> <i
													class="fa-solid fa-check"></i> <span>Yêu thích</span>
												</span>
											</div>
											<div class="home__product-saleoff">
												<span class="home__product-saleoff-percent">0%</span> <span
													class="home__product-saleoff-title">GIẢM</span>
											</div>
										</a>
									</div>
								</c:forEach>

							</div>
						</div>
						<ul class="home__pagination pagination ">
							<li class="pagination__item "><a
								href='/MVC/index.jsp?page=${back}' class="pagination__item-link">
									<i class="fa-solid fa-angle-left"></i>
							</a></li>
							<c:forEach var="i" begin="1" end="${endPage}">
								<li
									class="pagination__item ${i==page ? 'pagination__item--active' :'' }">
									<a href='/MVC/index.jsp?page=${i}' class="pagination__item-link">${i }
								</a></li>
							</c:forEach>
							<li class="pagination__item "><a
								href='/MVC/index.jsp?page=${next}' class="pagination__item-link">
									<i class="fa-solid fa-angle-right"></i>
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%request.getContextPath();%>/MVC/js/javascript.js"></script>
</body>
</html>