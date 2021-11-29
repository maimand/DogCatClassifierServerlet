package model.BO;

import java.sql.SQLException;

import model.DAO.LoginDAO;

public class LoginBO {
	private LoginDAO loginDAO;
	
	public LoginBO() {
		try {
			this.loginDAO = LoginDAO.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int checkLogin(String username, String password) {
		return loginDAO.checkLogin(username, password);
	}
}
