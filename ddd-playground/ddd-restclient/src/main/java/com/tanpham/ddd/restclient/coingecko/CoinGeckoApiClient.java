package com.tanpham.ddd.restclient.coingecko;

import java.util.List;

import com.tanpham.ddd.restclient.coingecko.domain.Coins.Coin;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

public interface CoinGeckoApiClient {

	Ping ping();
	List<Coin> getCoins();
	
}
