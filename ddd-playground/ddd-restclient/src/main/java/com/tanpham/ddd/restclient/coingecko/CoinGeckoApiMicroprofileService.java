package com.tanpham.ddd.restclient.coingecko;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.tanpham.ddd.restclient.coingecko.domain.Coins.Coin;
import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;

@Path("/v3")
@RegisterRestClient(configKey="coin-gecko-api")
public interface CoinGeckoApiMicroprofileService {

	@GET
	@Path("ping")
	Ping ping();
	
	@GET
    @Path("coins/list")
    List<Coin> getAll(@QueryParam(value = "include_platform") boolean includePlatform);
	
}
