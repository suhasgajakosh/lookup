package com.lookup.myapp.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import com.lookup.myapp.dao.PlacesDaO;
import com.lookup.myapp.dao.impl.PlacesDaOImpl;
import com.lookup.myapp.data.Places;
import com.lookup.myapp.service.PlacesService;

public class PlacesServiceImpl implements PlacesService {

	private static final Logger logger = Logger.getLogger(PlacesServiceImpl.class);

	PlacesDaO placesDao = new PlacesDaOImpl();

	/**
	 * This method returns list of places to controller
	 * 
	 * @return List<PLaces>
	 */
	@Override
	public List<Places> getAllPlacesList() {
		logger.info("Entered in getPLacesList() of" + PlacesServiceImpl.class.getSimpleName());
		List<Places> places = null;

		try {
			places = placesDao.getPLacesList(null, null);
		} catch (ClassNotFoundException e) {
			logger.error("Exception occured while fetching data" + e.getMessage());
		}

		logger.info("Exiting from getPLacesList() of" + PlacesServiceImpl.class.getSimpleName());
		return places;
	}

	/**
	 * This method returns list of places searched with name
	 * 
	 * @param name
	 * @return List<Places>
	 */
	@Override
	public List<Places> getPlacesByNameANDCategory(String name, String category) {
		logger.info("Entered in getPlacesByName() of" + PlacesServiceImpl.class.getSimpleName());
		List<Places> places = null;
		try {

			places = placesDao.getPLacesList(name, category);
		} catch (ClassNotFoundException e) {
			logger.error("Exception occured while fetching data" + e.getMessage());
		}

		logger.info("Exiting from getPlacesByName() of" + PlacesServiceImpl.class.getSimpleName());
		return places;
	}

	@Override
	public int getPlacesCount() {
		logger.info("Entered in getPlacesCount() of" + PlacesServiceImpl.class.getSimpleName());
		int count = 0;
		try {
			count = placesDao.getPlacesCount();
		} catch (ClassNotFoundException e) {
			logger.error("Exception occured while fetching data" + e.getMessage());
		}

		logger.info("Exiting from getPlacesCount() of" + PlacesServiceImpl.class.getSimpleName());
		return count;
	}

}
