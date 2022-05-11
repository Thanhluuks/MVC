package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBcontext;
import model.Product;

public class ListProductDAO {
	// return the list of products by product name
	public List<Product> search(String productName) throws Exception {
		List<Product> listProduct = new ArrayList<>();
		// get database connect
		Connection conn = new DBcontext().getConnectio();
		String sql ="SELECT * from Products WHERE product_name LIKE ?";
		PreparedStatement stmt =conn.prepareStatement(sql);
		if (productName =="") {
			stmt.setString(1, "%_%");
			 
		} else {
			stmt.setString(1, "%" + productName+"%");
		}
		
		ResultSet rs = stmt.executeQuery();
		// get all products from database
		while (rs.next()) {
			int id = rs.getInt("product_id");
			String name = rs.getString("product_name");
			String des = rs.getString("product_des");
			float price = rs.getFloat("product_price");
			String src = rs.getString("product_img_source");
			String type = rs.getString("product_type");
			String brand = rs.getString("product_brand");
			Product product = new Product(id, name, des, price, src, type, brand);
			listProduct.add(product);
		}
		return listProduct;
		
	}

	// get the product
	public Product getProduct(int productId) throws Exception {
		List<Product> listProduct = search("");
		Product product = new Product();
		for (Product x : listProduct) {
			if (x.getId() == productId) {
				product =x;
			}
		}
		return product;

	}
	//get product by name follow paging
	public List<Product> search(String productName,int firstIdx, int lastIidx) throws Exception {
		List<Product> listProduct = new ArrayList<>();
		Connection conn = new DBcontext().getConnectio();
		String sql = "SELECT * FROM Products WHERE product_name LIKE ? Order by product_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1,  "%" + productName+"%");
		stmt.setInt(2, firstIdx);
		stmt.setInt(3, lastIidx);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("product_id");
			String name = rs.getString("product_name");
			String des = rs.getString("product_des");
			float price = rs.getFloat("product_price");
			String src = rs.getString("product_img_source");
			String type = rs.getString("product_type");
			String brand = rs.getString("product_brand");
			Product product = new Product(id, name, des, price, src, type, brand);
			listProduct.add(product);
		}
		return listProduct;
	}
	
	//get product by brande follow paging
		public List<Product> searchBrand(String productName,int firstIdx, int lastIidx) throws Exception {
			List<Product> listProduct = new ArrayList<>();
			Connection conn = new DBcontext().getConnectio();
			String sql = "SELECT * FROM Products WHERE product_brand LIKE ? Order by product_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,  "%" + productName+"%");
			stmt.setInt(2, firstIdx);
			stmt.setInt(3, lastIidx);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("product_name");
				String des = rs.getString("product_des");
				float price = rs.getFloat("product_price");
				String src = rs.getString("product_img_source");
				String type = rs.getString("product_type");
				String brand = rs.getString("product_brand");
				Product product = new Product(id, name, des, price, src, type, brand);
				listProduct.add(product);
			}
			return listProduct;
		}
	public int getProductQty(String productName) throws Exception {
		int count=0;
		Connection conn = new DBcontext().getConnectio();
		String sql = "SELECT count(*) FROM Products ";
		Statement stmt =conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			count=rs.getInt(1);
		}
		return count;
	}

}
