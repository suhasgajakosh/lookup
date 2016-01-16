package com.lookup.myapp.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lookup.myapp.data.Places;
import com.lookup.myapp.service.PlacesService;
import com.lookup.myapp.service.impl.PlacesServiceImpl;
import com.lookup.myapp.util.ObjectToJSON;

/**
 * Handles requests for the application home page.
 */

@RestController
@RequestMapping("/controller/places")
public class PlacesController {

	private static final Logger logger = Logger.getLogger(PlacesController.class);

	private PlacesService placesService = new PlacesServiceImpl();

	/**
	 * This method returns the List of Places in JSON object format
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Object> getPlaces(@RequestParam(value = "name") String name,
			@RequestParam(value = "category") String category) {
		logger.info("Entered into getPlaces method of " + PlacesController.class.getSimpleName());
		List<Places> places = null;
		ResponseEntity<Object> response = null;

		if (null != name) {
			places = placesService.getPlacesByNameANDCategory(name, null);
		} else if (null != category) {
			places = placesService.getPlacesByNameANDCategory(null, category);
		} else {
			places = placesService.getAllPlacesList();
		}
		response = ObjectToJSON.genarateJSON((Object) places);
		logger.info("Exiting from getPlaces method of " + PlacesController.class.getSimpleName());
		return response;
	}

	/**
	 * This method returns the Number of Places List in JSON object format
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<Object> getPlacesCount() {
		logger.info("Entered into getPlacesCount method of " + PlacesController.class.getSimpleName());
		ResponseEntity<Object> response = null;
		Integer count = 0;

		count = placesService.getPlacesCount();
		response = ObjectToJSON.genarateJSON((Object) count);
		logger.info("Exiting from getPlacesCount method of " + PlacesController.class.getSimpleName());
		return response;
	}

}
