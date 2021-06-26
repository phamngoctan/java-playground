package com.tanpham.ddd.restclient.coingecko.impl;

import java.util.List;

import javax.inject.Named;

import com.tanpham.ddd.restclient.coingecko.CoinGeckoApiClient;
import com.tanpham.ddd.restclient.coingecko.CoinGeckoApiRetrofitService;
import com.tanpham.ddd.restclient.coingecko.CoinGeckoRetrofitSetup;
import com.tanpham.ddd.restclient.coingecko.domain.Coins.Coin;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

@Named("CoinGeckoApiRetrofitClient")
public class CoinGeckoApiRetrofitClientImpl implements CoinGeckoApiClient {
    private CoinGeckoApiRetrofitService coinGeckoApiService;
    private CoinGeckoRetrofitSetup coinGeckoApi;

    public CoinGeckoApiRetrofitClientImpl() {
        this.coinGeckoApi = new CoinGeckoRetrofitSetup();
        this.coinGeckoApiService = coinGeckoApi.createService(CoinGeckoApiRetrofitService.class);
    }

    @Override
    public Ping ping() {
        return coinGeckoApi.executeSync(coinGeckoApiService.ping());
    }

	@Override
	public List<Coin> getCoins() {
		return coinGeckoApi.executeSync(coinGeckoApiService.getCoins());
	}

}
