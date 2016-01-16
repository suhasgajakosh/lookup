package com.lookup.myapp.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DataSourceFactory {

	private static final Logger logger = Logger.getLogger(DataSourceFactory.class);
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/places?";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	/**
	 * This Method returns a database connection 
	 * */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		logger.info("Getting a Connection for Database from getConnection() method");

		try {
			Class.forName(JDBC_DRIVER).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.error("Exception occured during getting Database Driver" + e.getMessage());

		}
		logger.info("Received a Connection for Database from getConnection() method");
		return DriverManager.getConnection(DB_URL + "user=" + USER + "&password=" + PASSWORD);

	}
}
