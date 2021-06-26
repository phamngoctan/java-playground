package com.tanpham.ddd.restclient.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.tanpham.ddd.restclient.coingecko.domain.ping.Ping;
import com.tanpham.ddd.restclient.service.CoinService;

@Path("/coins")
public class CoinResource {

	@Inject
	private CoinService coinService;

    @GET
    @Path("ping1")
    public Ping ping1() {
        return coinService.pingUsingMicroprofile();
    }
    
    @GET
    @Path("ping2")
    public Ping ping2() {
        return coinService.pingUsingRetrofit();
    }
}