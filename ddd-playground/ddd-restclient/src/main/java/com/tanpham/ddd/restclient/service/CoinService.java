package com.tanpham.ddd.restclient.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.tanpham.ddd.restclient.coingecko.CoinGeckoApiClient;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

@RequestScoped
public class CoinService {

	@Inject
	private @Named("CoinGeckoApiMicroprofileClient") CoinGeckoApiClient coinGeckoMicroprofileClient;
	
	@Inject
	private @Named("CoinGeckoApiRetrofitClient") CoinGeckoApiClient coinGeckoRetrofitClient;
	
	public Ping pingUsingMicroprofile() {
		return coinGeckoMicroprofileClient.ping();
	}
	
	public Ping pingUsingRetrofit() {
		return coinGeckoRetrofitClient.ping();
	}
	
}
