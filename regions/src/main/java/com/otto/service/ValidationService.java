package com.otto.service;

import java.util.Arrays;
import java.util.List;

public class ValidationService {

	public static List<String> getAllowedValues(){
		String[] av = {"EU","US","AP","CN","SA","AF","CA","ALL"};
	    List<String> allowedValues = Arrays.asList(av);
	    return allowedValues;
	}
}
