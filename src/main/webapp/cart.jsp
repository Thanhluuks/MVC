<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="header.jsp"></c:import>

<div class="app">
	<div class="app__container">
		<div class="grid">
			<c:if test="${empty cart.getItems() }">
				<p class="message cart_message">
					Giỏ hàng của bạn đang trống. Vui lòng đến <a class="home__link"href="index.jsp">HOME</a> để thêm sản phẩm vào giỏ hàng.
				</p>
			</c:if>
			<c:if test="${not empty cart.getItems() }">
				<div class="cart__container">


					<table class="cart">
						<tr>
							<th>Sản phẩm thêm vào giỏ</th>
							<th>Giá</th>
							<th>Số lượng</th>
							<th>Tổng giá trị</th>
							<th>Xóa sản phẩm</th>
						</tr>
						<c:forEach var="product" items="${cart.getItems() }">
							<tr>
								<td>${product.getName()}</td>
								<td>${product.getPrice()}$</td>
								<td>${product.getNumber()}</td>
								<td><fmt:formatNumber type="number" maxIntegerDigits="2">${product.getPrice() * product.getNumber()}</fmt:formatNumber>
									$</td>
								<td>
									<form class="cart_delete" action="AddToCartController"
										method="post">
										<input type="hidden" value="${product.getId() }" name="id" />
										<button type="submit" value="delete" name="action">
											<i class="fa-solid fa-trash-can"></i>
										</button>
									</form>
								</td>

							</tr>
						</c:forEach>
						<tr class="total_amout">
							<td  colspan="4">Tổng tiền</td>
							<td>${cart.getAmount()} $</td>
						</tr>
					</table>

				</div>
				<a class="add_product-link"href="index.jsp"><button class="btn btn--primary btn--add_product">Thêm sản phẩm</button></a>
				<form class="cart__user-info" action="PayController" method="post">
					<label for="name">Email của bạn:</label> <input type="text"
						class="user_name" name="name" value=${empty user ? '' : user }><br> <br> <label
						for="address">Địa chỉ của bạn:</label> <input type="text"
						class="user_address" name="address"><br> <br> <label
						for="discountt">Mã giảm giá (nếu có)</label> <input type="text"
						class="user_discount" name="discount"><br> <br>
					<p class="message">${erorr }</p>
					<button class="btn btn--primary btn--add_cart" type="submit">Đặt
						hàng</button>
				</form>
			</c:if>
		</div>

	</div>
</div>
<c:import url="footer.jsp"></c:import>