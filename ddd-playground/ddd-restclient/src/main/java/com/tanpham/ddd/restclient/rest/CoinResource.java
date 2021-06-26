package com.tanpham.ddd.restclient.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/coins")
public class CoinResource {

    @GET
    public String helloWorld() {
        return "Hello coins!";
    }
}