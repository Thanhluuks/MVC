package model;

import java.util.Date;
import java.util.List;

public class Orders {
	private int orderId;
	private float price;
	private int status;
	private Date orderDate;
	private Date reveiveDate;
	private String address;
	private String phoneNumber;
	private List<ProductOrders> lp;
	private String userMail;
	private String discount;
	private String message="";
	public Orders() {
	}
	public Orders(int orderId, float price, int status, Date orderDate, Date reveiveDate, String address,
			String phoneNumber, List<ProductOrders> lp, String userMail) {
		super();
		this.orderId = orderId;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
		this.reveiveDate = reveiveDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.lp = lp;
		this.userMail = userMail;
	}
	public Orders(int status, Date orderDate, String address, String phoneNumber, String userMail, String discount) {
		super();
		this.status = status;
		this.orderDate = orderDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.userMail = userMail;
		this.discount = discount;
	}
	

	public boolean validate() {
		if(userMail=="") {
			message ="Bạn chưa nhập địa chỉ email. Vui lòng nhập lại.";
			return false;
		}
		if(!userMail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			message ="Địa chỉ email không hợp lệ. Vui lòng nhập lại." ;
			return false;
		}
		return true;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getReveiveDate() {
		return reveiveDate;
	}
	public void setReveiveDate(Date reveiveDate) {
		this.reveiveDate = reveiveDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<ProductOrders> getLp() {
		return lp;
	}
	public void setLp(List<ProductOrders> lp) {
		this.lp = lp;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
