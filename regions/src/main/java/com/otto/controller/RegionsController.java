package com.otto.controller;

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
        return regionsService.getRegions(region);
	}

}