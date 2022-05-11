package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBcontext;
import model.Account;

public class ListAccountDAO {
	//true if user does't have in database
	public boolean isAvaliable(String email) throws Exception {
		Connection conn = new DBcontext().getConnectio();
		String sql = "SELECT * FROM Account WHERE user_mail = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			if(email.equalsIgnoreCase(rs.getString("user_mail"))) {
				return false;
			}
		}
		return true;
	}
	//true if user and password already had
	public boolean isAvaliable(String email, String password) throws Exception {
		Connection conn = new DBcontext().getConnectio();
		String sql = "SELECT * FROM Account WHERE user_mail = ? ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			if(email.equalsIgnoreCase(rs.getString("user_mail")) && password.equals(rs.getString("password"))) {
				return true;
			}
		}
		return false;
	}
	public void addAccount(Account acc) throws Exception{
		if(!isAvaliable(acc.getUsr())) {
		 return;
		}
		Connection conn = new DBcontext().getConnectio();
		String sql = "INSERT INTO Account (user_mail,password,account_role,user_name) VALUES (?,?,?,?) ";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, acc.getUsr());
		stmt.setString(2, acc.getPwd());
		stmt.setInt(3, 1);
		stmt.setString(4, "");
		stmt.executeUpdate();
	}
}
