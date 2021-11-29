package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Bean.History;
import model.Bean.MyJDBC;

public class HistoryDAO {

	private static HistoryDAO myHistoryHelper;
	private Statement statement;
	private static final String TABLE_HISTORY_NAME = "history";
	private static final String COL_IMAGE_URL = "image_url";
	private static final String COL_DESCRIPTION = "description";
	private static final String COL_USER_ID = "idUser";
	private MyJDBC myJDBC;

	public static HistoryDAO getInstance() throws SQLException {
		if (myHistoryHelper == null) {
			myHistoryHelper = new HistoryDAO();
		}
		return myHistoryHelper;
	}

	private HistoryDAO() throws SQLException {
		this.myJDBC = MyJDBC.getInstance();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(myJDBC.DB_URL + "/" + myJDBC.DATABASE_NAME, myJDBC.USER,
					myJDBC.PASS);

			this.statement = connection.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_HISTORY_NAME + " (id INTEGER NOT NULL AUTO_INCREMENT, "
					+ COL_IMAGE_URL + " VARCHAR(255) NOT NULL, " + COL_DESCRIPTION + " VARCHAR(255) NOT NULL, "
					+ COL_USER_ID + " INTEGER NOT NULL, " + " FOREIGN KEY (idUser) REFERENCES Login(idUser),"
					+ " PRIMARY KEY ( id ))";
			statement.execute(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public void insertHistory(String imageUrl, String description, int userId) {
		try {
			String sql = "INSERT INTO " + TABLE_HISTORY_NAME + "(" + COL_IMAGE_URL + "," + COL_DESCRIPTION + ","
					+ COL_USER_ID + ")" + " VALUES(" + "'" + imageUrl + "'," + "'" + description + "'," + userId + ")";

			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<History> getHistory(int userId) {
		List<History> historyList = new ArrayList<>();
		try {
			String sql = "SELECT * FROM " + TABLE_HISTORY_NAME + " WHERE " + COL_USER_ID + " = " + "'" + userId + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				History history = new History(resultSet.getString(COL_IMAGE_URL), resultSet.getString(COL_DESCRIPTION),
						resultSet.getString(COL_USER_ID));
				historyList.add(history);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historyList;
	}

}
