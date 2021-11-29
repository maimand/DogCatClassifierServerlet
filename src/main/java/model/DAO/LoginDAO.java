package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Bean.MyJDBC;

public class LoginDAO {
	private static LoginDAO myUserTable;
	private final Statement statement;
	private static final String TABLE_LOGIN_NAME = "Login";
	private static final String COL_USERNAME = "username";
	private static final String COL_PASSWORD = "password";
	private static final String COL_ID_USER = "idUser";
	private MyJDBC myJDBC;

	public static LoginDAO getInstance() throws SQLException {
		if (myUserTable == null) {
			myUserTable = new LoginDAO();
		}
		return myUserTable;
	}

	private LoginDAO() throws SQLException {
		this.myJDBC = MyJDBC.getInstance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(myJDBC.DB_URL + "/" + myJDBC.DATABASE_NAME, myJDBC.USER,
				myJDBC.PASS);

		statement = connection.createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_LOGIN_NAME + "(" + COL_ID_USER
				+ " INTEGER NOT NULL AUTO_INCREMENT, " + COL_USERNAME + " VARCHAR(255) NOT NULL, " + COL_PASSWORD
				+ " VARCHAR(255) NOT NULL, " + " PRIMARY KEY ( idUser ))";

		statement.execute(sql);
	}

	/**
	 * checkLogin 
	 * return : 
	 * userID: login success 
	 * -1 : username not found
	 * -2 : password wrong
	 * -3 : error unKnow
	 *
	 */
	public int checkLogin(String username, String password) {
		try {
			String sql = "SELECT * FROM Login WHERE " + COL_USERNAME + "= " + "'" + username + "'";
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				String emailResult = resultSet.getString(COL_PASSWORD);
				if (password.equals(emailResult)) {
					return resultSet.getInt(COL_ID_USER);
				} else {
					return -2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return -3;
		}
		return -1;
	}
}
