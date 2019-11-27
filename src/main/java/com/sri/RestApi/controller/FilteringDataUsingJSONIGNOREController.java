package com.sri.RestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sri.RestApi.model.TestJsonIgnore;

@RestController
public class FilteringDataUsingJSONIGNOREController {

	@GetMapping("/ignorev3")
	public TestJsonIgnore getDetails() {
		return new TestJsonIgnore("v1", "v2", "v3");
	}

}
