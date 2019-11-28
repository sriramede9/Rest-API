package com.sri.RestApi.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sri.RestApi.model.TestJsonIgnore;
import com.sri.RestApi.model.Testdynamically;

@RestController
public class FilteringDataUsingJSONIGNOREController {

	@GetMapping("/ignorev3")
	public TestJsonIgnore getDetails() {
		return new TestJsonIgnore("v1", "v2", "v3");
	}

	// filetering data for specific request method

	@GetMapping("/ignoredy")
	public MappingJacksonValue getDetails2() {

		// for this specific request of get.
		// I want the user to see only s1 and s2 params as the output.

		Testdynamically testdynamically = new Testdynamically("s1", "s2", "s3");

		// step One
		MappingJacksonValue mapping = new MappingJacksonValue(testdynamically);

		// step two

		// 3
		FilterProvider filters;
		// 5
		SimpleBeanPropertyFilter filter;
		filter = SimpleBeanPropertyFilter.filterOutAllExcept("s1", "s2");

		// 4
		filters = new SimpleFilterProvider().addFilter("simpleBean", filter);
		
		//5 @JsonFilter ("simpleBean") should be annotated on testdynamically class

		// 2
		mapping.setFilters(filters);

		return mapping;
	}

}
