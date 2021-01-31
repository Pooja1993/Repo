package com.otto.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.otto.controller.RegionsController;
import com.otto.service.RegionsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

@SpringBootTest
class RegionsApplicationTests {
	
	@Autowired
	RegionsService service;
	
	@Autowired
	RegionsController controller;
	
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void contextLoadsController() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void readsFromURL() {
	    String result = service.readURL();
	    assertTrue(result.contains("region"));
	}
	
	@Test
    public void errorMessageOnInvalidInput() {
		String region = "CP";
        String result = controller.getRegions(region);
        assertTrue(result.contains("Enter valid region"));
    }
	
	@Test
	public void containsRegionIfValid() {
		String region = "EU";
		String[] av = {"us","ap","cn","sa","af","ca"};
		String result = service.getRegions(region);
		assertTrue(result.contains(region.toLowerCase()) 
	    		&& !Arrays.stream(av).allMatch(result::contains));
	}
	
	@Test
	public void containsAllRegionsWithAllParam() {
		String region = "ALL";
		String[] av = {"eu","us","ap","cn","sa","af","ca"};
		String result = service.getRegions(region);
		assertTrue(Arrays.stream(av).allMatch(result::contains));
	}

}
