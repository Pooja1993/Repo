package com.otto.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RegionsService {
	
	public String getRegions(String region) {
		String result = "";
		String response = readURL();
		
		//Read all prefixes from response
		JSONObject responseJson = new JSONObject(response);
        JSONArray array = responseJson.getJSONArray("prefixes");
        
        for(int i=0;i<array.length();i++) {
        	JSONObject json = new JSONObject(array.get(i).toString());
        	if(region.equals("ALL")) {
        		result = result + json + System.getProperty("line.separator");
        	}
        	else if(json.get("region").toString().toUpperCase().contains(region)) {
        		result = result + json + System.getProperty("line.separator");
        	}
        }
        
        //Read all ipv6_prefixes
        array = responseJson.getJSONArray("ipv6_prefixes");
        
        for(int i=0;i<array.length();i++) {
        	JSONObject json = new JSONObject(array.get(i).toString());
        	if(region.equals("ALL")) {
        		result = result + json + System.getProperty("line.separator");
        	}
        	else if(json.get("region").toString().toUpperCase().contains(region)) {
        		result = result + json + System.getProperty("line.separator");
        	}
        }
        //System.out.println(result);
        
        return result;
	}
	
	public String readURL() {
		try
	    {
			//Prepare the connection
	        URL url = new URL("https://ip-ranges.amazonaws.com/ip-ranges.json");
	        URLConnection connection = url.openConnection();

	        //Connect to URL
	        connection.setDoOutput(true);
	        connection.connect();

	        //Read from the URL
	        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuilder response = new StringBuilder();
	        String input;
	        while ((input = reader.readLine()) != null)
	        {
	            response.append(input);
	        }
	        
	        //Close reader and return response
	        reader.close();
	        return response.toString();
	    }
	    catch (Exception e)
	    {
	        throw new RuntimeException(e);
	    }
	}

}
