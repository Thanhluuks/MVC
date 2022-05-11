package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import context.DBcontext;
import model.Cart;
import model.Orders;
import model.Product;

public class OrdersDao {
	// insert order information into database included list of product from cart c
	// and buyer's information from orders o
	public void insertOrder(Orders o, Cart c) throws Exception {
		// get information from Order
		String mail = o.getUserMail();
		int status = o.getStatus();
		Date order_date = new Date(o.getOrderDate().getTime());
		String discount = o.getDiscount();
		String address = o.getAddress();
		// insert orders information to database / Orders table
		Connection conn = new DBcontext().getConnectio();
		String sqlOrders = "INSERT INTO Orders VALUES (?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sqlOrders);
		stmt.setString(1, mail);
		stmt.setInt(2, status);
		stmt.setDate(3, order_date);
		stmt.setString(4, discount);
		stmt.setString(5, address);
		stmt.executeUpdate();
		stmt.close();

		// insert orders_detail information to database / Orders_detail table
		
		String sqlDetail = "INSERT INTO Orders_detail VALUES(?,?,?,?)";
		PreparedStatement stmt2 = conn.prepareStatement(sqlDetail);
		//get this order_id = max ID;
		Statement stmt3 = conn.createStatement();
		ResultSet rs = stmt3.executeQuery("SELECT MAX(order_id) FROM Orders");
		rs.next();
		stmt2.setInt(1, rs.getInt(1));
		List<Product> items = c.getItems();
		for (Product x : items) {
			stmt2.setInt(2, x.getId());
			stmt2.setInt(3, x.getNumber());
			stmt2.setFloat(4, x.getPrice());
			stmt2.execute();
		}
		stmt2.close();
		
	}
}
