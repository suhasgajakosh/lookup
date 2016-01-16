package com.lookup.myapp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ObjectToJSON {

	public static ResponseEntity<Object> genarateJSON(Object places) {

		ResponseEntity<Object> response = new ResponseEntity<Object>(places, HttpStatus.OK);

		return response;
	}

}
