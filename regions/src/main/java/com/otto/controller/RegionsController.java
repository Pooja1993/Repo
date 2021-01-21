package com.otto.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otto.service.RegionsService;

@RestController
public class RegionsController {
	
	@Autowired
	RegionsService regionsService;

	@GetMapping("/regions")
	public String getRegions(@RequestParam(name="region", defaultValue="ALL", required=false) String region) {
		List<String> allowedValues = getAllowedValuesFromDB();
	     if(allowedValues.contains(region)){
	 		return regionsService.getRegions(region);
	     }
	     return "Enter valid region(EU, US, AP, CN, SA, AF, CA or ALL)";
	}
	
	private List<String> getAllowedValuesFromDB(){
		String[] av = {"EU","US","AP","CN","SA","AF","CA","ALL"};
	    List<String> allowedValues = Arrays.asList(av);
	    return allowedValues;
	}

}
