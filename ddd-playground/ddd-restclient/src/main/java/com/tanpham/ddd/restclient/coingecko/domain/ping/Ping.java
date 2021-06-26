package com.tanpham.ddd.restclient.coingecko.domain.ping;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ping {

	@JsonProperty("gecko_says")
	private String geckoSays;
	
}
