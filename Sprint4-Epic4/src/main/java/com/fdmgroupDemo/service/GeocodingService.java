package com.fdmgroupDemo.service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fdmgroupDemo.exception.FetchingDataErrorException;

@Service
public class GeocodingService 
{
	private final RestClient restClient;
	
	public GeocodingService()
	{
		restClient = RestClient.builder().baseUrl(null).build();
	}     
	
	
	public JsonNode getCityAndProvince(String postalCode) {
        String url = String.format("https://geocoder.ca/?locate=%s&geoit=XML&json=1", postalCode);
        try 
        {
            return restClient.get()
                    .uri(url)
                    .retrieve() 
                    .body(JsonNode.class);
        } 
        catch (RestClientResponseException e) {throw new FetchingDataErrorException("Error fetching geocoding data", e);}
    }
}
