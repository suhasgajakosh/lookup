package com.lookup.myapp.service;

import java.util.List;

import com.lookup.myapp.data.Places;

public interface PlacesService {
	
	public List<Places> getAllPlacesList();
	
	/*public List<Places> getPlacesByName(String name);
	
	public List<Places> getPlacesByCategory(String category);*/
	
	public List<Places> getPlacesByNameANDCategory(String name, String category);
	
	public int getPlacesCount();
}
