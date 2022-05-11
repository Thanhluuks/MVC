package model;

public class Account {
	private String usr, pwd;
	private int role;
	private String name, phone, address,message="";
	private int check;

	public Account(String usr, String pwd, int role, String name, String phone, String address, int check) {
		super();
		this.usr = usr;
		this.pwd = pwd;
		this.role = role;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.check = check;
	}
	
	public boolean validate() {
		if(usr=="") {
			message ="Bạn chưa nhập địa chỉ email. Vui lòng nhập lại.";
			return false;
		}
		if(!usr.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			message ="Địa chỉ email không hợp lệ. Vui lòng nhập lại." ;
			return false;
		}

		if(pwd=="") {
			message="Bạn chưa nhập mật khẩu. Vui lòng nhập lại.";
			return false;
		}
		if(pwd.length() < 8) {
			message ="Mật khẩu quá ngắn.Vui lòng nhập lại.";
			return false;
		}
		else if(pwd.matches("\\w*\\s+\\w*")) {
			message ="Mật khẩu chưa khoảng trắng. Vui lòng nhập lại.";
			return false;
		}
		return true;
	}
	
	public Account() {
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
