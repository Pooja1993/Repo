package com.otto.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.otto.controller.RegionsController;
import com.otto.service.RegionsService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

@SpringBootTest
class RegionsApplicationTests {
	
	@Autowired
	private RegionsService service;
	
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}
	
	@Test
	public void readsFromURL() {
	    String found = service.readURL();
	    assertThat(found.contains("region"));
	}
	
	@Test
    public void errorMessageOnInvalidInput() {
		String region = "CP";
        RegionsController controller = new RegionsController();
        String result = controller.getRegions(region);
        assertThat(result.contains("Enter valid region"));
    }
	
	@Test
	public void containsRegionIfValid() {
		String region = "EU";
		String[] av = {"us","ap","cn","sa","af","ca"};
		String found = service.getRegions(region);
	    assertThat(found.contains(region.toLowerCase()) 
	    		&& !Arrays.stream(av).anyMatch(found::contains));
	}
	
	@Test
	public void containsAllRegionsWithAllParam() {
		String region = "ALL";
		String[] av = {"eu","us","ap","cn","sa","af","ca"};
		String found = service.getRegions(region);
	    assertThat(Arrays.stream(av).allMatch(found::contains));
	}

}
