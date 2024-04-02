package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class mysqlconnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Connection connection = getConnection();
	}
	
	public static Connection getConnection() {
	    Connection connection = null;
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/realestated?useSSL=false";
	        String username = "root";
	        String password = "sqlAmany@sql999";
	        connection = DriverManager.getConnection(url, username, password);
	        System.out.println("Connected to the database!");
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return connection;
	}
	



}

