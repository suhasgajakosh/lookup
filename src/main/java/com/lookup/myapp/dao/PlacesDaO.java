package com.lookup.myapp.dao;

import java.util.List;

import com.lookup.myapp.data.Places;

public interface PlacesDaO {
	
	
	public List<Places> getPLacesList(String name, String category) throws ClassNotFoundException;
	
	public int getPlacesCount() throws ClassNotFoundException;
	
	

}
