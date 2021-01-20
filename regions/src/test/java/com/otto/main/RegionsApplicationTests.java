package com.otto.main;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.otto.controller.RegionsController;
import com.otto.service.RegionsService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RegionsApplicationTests {
	
	@Autowired
	private RegionsService service;
	/*
	@Autowired
    private MockMvc mvc;*/
	
	@Test
	void contextLoads() {
		assertThat(service).isNotNull();
	}
	
	@Test
	public void readsFromURL() {
	    String found = service.readURL();
	     assertThat(found.contains("region"));
	}
	
	/*@Test
	public void something() {
		String region = "CN";
		String found = service.getRegions(region);
		System.out.println(found);
		assertThat(found.contains(region.toLowerCase()));
	}*/
	/*
	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200()
	  throws Exception {


	    mvc.perform(get("/api/employees")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(content()
	      .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
	      .andExpect(jsonPath("$[0].name", is("bob")));
	}*/

}
