package com.tanpham.ddd.restclient.coingecko;

import java.util.List;

import com.tanpham.ddd.restclient.coingecko.domain.Coins.Coin;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CoinGeckoApiRetrofitService {

	@GET("ping")
    Call<Ping> ping();
	
	@GET("coins/list")
    @Headers({"Cache-Control: no-cache, must-revalidate", "Pragma: no-cache", "Expires: Sat, 26 Jul 1997 05:00:00 GMT"})
    Call<List<Coin>> getCoins();
	
}
