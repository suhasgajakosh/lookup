package com.lookup.myapp.dao.impl;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lookup.myapp.dao.PlacesDaO;
import com.lookup.myapp.dao.util.DataSourceFactory;
import com.lookup.myapp.data.Places;

public class PlacesDaOImpl implements PlacesDaO {
	private static final Logger logger = Logger.getLogger(DataSourceFactory.class);

	Connection conn = null;
	Statement statement = null;
	ResultSet rs = null;

	@Override
	public List<Places> getPLacesList(String name, String category) throws ClassNotFoundException {

		logger.info("Entered in getPLacesList() of" + PlacesDaOImpl.class.getSimpleName());
		List<Places> places = new ArrayList<>();
		try {
			statement = conn.createStatement();
			if (null == name && null == category) {
				String placesListQuery = "SELECT * FROM places.places";
				rs = statement.executeQuery(placesListQuery);
			} else if (null != name && null != category) {
				String placesListQuery = "SELECT * FROM places.places WHERE name = " + name + "AND" + "category = "
						+ category;
				rs = statement.executeQuery(placesListQuery);
			} else if (null != name) {
				String placesListQuery = "SELECT * FROM places.places WHERE name = " + name;
				rs = statement.executeQuery(placesListQuery);
			} else if (null != category) {
				String placesListQuery = "SELECT * FROM places.places WHERE category = " + category;
				rs = statement.executeQuery(placesListQuery);
			}

			while (rs.next()) {
				Places place = new Places(rs.getInt("id"), rs.getString("name"), rs.getString("category"),
						rs.getDouble("rating"), rs.getDouble("latitude"), rs.getDouble("longitude"));
				places.add(place);
			}
		} catch (SQLException e) {
			logger.error("Exception occured while fetching data" + e.getMessage());
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != statement) {
					statement.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}

		logger.info("Exiting from getPLacesList() of" + PlacesDaOImpl.class.getSimpleName());
		return places;

	}

	/**
	 * This method returns a count of places in database
	 */
	@Override
	public int getPlacesCount() throws ClassNotFoundException {
		logger.info("Entered in getPlacesCount() of" + PlacesDaOImpl.class.getSimpleName());
		int count = 0;
		try {
			conn = DataSourceFactory.getConnection();
			statement = conn.createStatement();

			String placesListQuery = "SELECT COUNT(*) FROM places.places;";
			rs = statement.executeQuery(placesListQuery);

			count = rs.getInt("COUNT(*)");
			logger.info("Exiting from getPlacesCount() of" + PlacesDaOImpl.class.getSimpleName());

		} catch (SQLException e) {
			logger.error("Exception occured while fetching data" + e.getMessage());
		} finally {
			try {
				if (null != rs) {
					rs.close();
				}
				if (null != statement) {
					statement.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {

			}
		}
		return count;
	}

}
