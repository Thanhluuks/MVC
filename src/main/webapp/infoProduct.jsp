<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="header.jsp"></c:import>

	<div class="app">
		<div class="app__container">
			<div class="grid wide">
				<div class="row app__prododuct">
					<div class="col l-12 m-12 c-12">
						<h1 class="product__name">
							${product.getName() }
						</h1>
					</div>
					<div class="col l-12 m-12 c-12">
						<div class="row app__prododuct">
							<%--A product item --%>
								<div class="product__img">
									<div class="home__product-item-img"
											style="background-image: url('${product.getSrc()}');"></div>
								</div>
								<div class="product__info">
									<div class="">
										<h1 class="product__price">${product.getPrice() } $</h1>
									</div>
									<h2 class="">Thông tin sản phẩm:  ${product.getDescription() }</h2>
									
									<div class="">
										<h3 class="">Thương hiệu: ${product.getBrand() }</h3>
									</div>
									<form action="AddToCartController" method="POST" >
										<input type="hidden" name="id" value ="${product.getId()}" />
										<div class="cart-totals">
											<input class="minus" type="button" value="-" data-for="quantity1"> 
											<input name="quantity" type=number id="quantity1" value="1" min="0"> 
											<input class="plus" type="button" value="+" data-for="quantity1">
										</div>
										<button type="submit" class="btn btn--primary add__cart" name="action" value="add">
											Add to cart
										</button>
										
									</form>
								</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/MVC/js/javascript.js"></script>
<c:import url="footer.jsp"></c:import>