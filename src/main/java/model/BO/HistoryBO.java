package model.BO;

import java.sql.SQLException;
import java.util.List;

import model.Bean.History;
import model.DAO.HistoryDAO;

public class HistoryBO {
	private HistoryDAO historyDAO;

	public HistoryBO() {
		try {
			this.historyDAO = HistoryDAO.getInstance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<History> getHistoriesByUserId(int userId) {
		return historyDAO.getHistory(userId);
	}

	public void addHistoryRecord(String imageUrl, String description, int userId) {
		historyDAO.insertHistory(imageUrl, description, userId);
	}
}
