package model.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJDBC {
    private static MyJDBC myJDBC;
    public final String DATABASE_NAME = "assignment";
    public final String DB_URL = "jdbc:mysql://localhost:3306";
    public final String USER = "root";
    public final String PASS = "01694429810";
    
    public static MyJDBC getInstance(){
        if(myJDBC==null){
            myJDBC = new MyJDBC();
        }
        return myJDBC;
    }

    private MyJDBC(){
        try {
            createDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void createDatabase() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement statement = connection.createStatement();
        String query = "CREATE DATABASE IF NOT EXISTS "+DATABASE_NAME;
        statement.execute(query);
        System.out.println("Database created successfully...");
    }

}
