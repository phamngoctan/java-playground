package com.demo.redis.client;

import java.util.UUID;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;

public class RedisClientDemo {

	public static void main(String[] args) {
		HostAndPort hostAndPort = new HostAndPort("localhost", 63799);
        Jedis jedis = new Jedis(hostAndPort); 
        
		System.out.println("Previous foo value: " + jedis.get("foo"));
		
		String curUuid = UUID.randomUUID().toString();
		System.out.println("Cur UUID value: " + curUuid);
		jedis.set("foo", curUuid);
		jedis.close();
	}
	
}
