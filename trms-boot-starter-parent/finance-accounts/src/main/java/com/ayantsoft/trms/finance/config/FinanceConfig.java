package com.ayantsoft.trms.finance.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.client.RestTemplate;

import com.ayantsoft.trms.finance.info.DatabaseInfo;
import com.mongodb.MongoClient;

@Configuration
public class FinanceConfig {
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Bean
	public MongoDbFactory mongoDbFactory() throws UnknownHostException{
		SimpleMongoDbFactory simpleMongoDbFactory = null;
		simpleMongoDbFactory =	new SimpleMongoDbFactory(new MongoClient(DatabaseInfo.IP,DatabaseInfo.PORT),DatabaseInfo.DATABASENAME);
		return simpleMongoDbFactory;
	}

}
