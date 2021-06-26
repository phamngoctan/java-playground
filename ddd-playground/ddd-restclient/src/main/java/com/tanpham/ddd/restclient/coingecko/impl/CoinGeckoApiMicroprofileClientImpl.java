package com.tanpham.ddd.restclient.coingecko.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.tanpham.ddd.restclient.coingecko.CoinGeckoApiClient;
import com.tanpham.ddd.restclient.coingecko.CoinGeckoApiMicroprofileService;
import com.tanpham.ddd.restclient.coingecko.domain.Coins.Coin;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

@Named("CoinGeckoApiMicroprofileClient")
public class CoinGeckoApiMicroprofileClientImpl implements CoinGeckoApiClient {

	@Inject
	@RestClient
	private CoinGeckoApiMicroprofileService coinGeckoApiMicroprofileService;
	
	@Override
	public Ping ping() {
		return coinGeckoApiMicroprofileService.ping();
	}

	@Override
	public List<Coin> getCoins() {
		return coinGeckoApiMicroprofileService.getAll(true);
	}

}
